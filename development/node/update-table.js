var results = require('../../_data/results.json');
var fs      = require('fs');

const TYPEOF_UNDEFINED = 'undefined';
const WIN_POINTS   = 3;
const DRAWN_POINTS = 1;
const LOST_POINTS  = 0;
var table = {};

for(round in results){
	addRoundResults(results[round]);
}

fs.writeFileSync('../../_data/table.json', JSON.stringify(table, null, 2));



function addRoundResults(round){
	for(index in round){
		var result = round[index];
		if(result.score1 > result.score2){
		    addTeamInfo(result.team1, WIN_POINTS, result.score1, result.score2);
            addTeamInfo(result.team2, LOST_POINTS, result.score2, result.score1);
        }else if(result.score1 < result.score2){
            addTeamInfo(result.team1, LOST_POINTS, result.score1, result.score2);
            addTeamInfo(result.team2, WIN_POINTS, result.score2, result.score1);
        }else{
            addTeamInfo(result.team1, DRAWN_POINTS, result.score1, result.score2);
            addTeamInfo(result.team2, DRAWN_POINTS, result.score2, result.score1);
        }
	}
}

function addTeamInfo(teamName, points, goalFor,  goalAgainst){
	if(typeof table[teamName] == TYPEOF_UNDEFINED){
		table[teamName] = getEmptyData();
	}
	var team = table[teamName];
    team.played++;
	team.points 	 += points;
	team.goalFor     += goalFor;
	team.goalAgainst += goalAgainst;
    team.goalDifference = team.goalFor - team.goalAgainst;
    if(points == WIN_POINTS){
        team.won++;
    }else if(points == LOST_POINTS){
        team.lost++;
    }else{
        team.drawn++;
    }

}

function getEmptyData() {
	return {
        played: 0,
		won: 0,
        drawn: 0,
        lost: 0,
        points: 0,
        goalFor: 0,
        goalAgainst: 0,
        goalDifference: 0
	}
}