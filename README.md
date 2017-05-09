# fifaleaguedevs.github.io
* Are you a developer? :computer:
* Are you a Fifa 17 player (PS4)? :soccer:
* Are you a freak that want to see how to combine both concepts in an awesome project? :bulb:

Simply follow the next steps and enjoy! :checkered_flag:

## How to collaborate
![alt tag](https://github.com/fifaleaguedevs/fifaleaguedevs.github.io/blob/master/development/process.png)

## Join the league
1. Add your information in _data/players.json
```javascript
{
    "name": "your_name",
    "github": "your_github_user",
    "psn": "your_psn_user"
  },
```
2. Open a pull request to merge your user in the players list

## Select your team
1. Check teams in _data/teams.json
2. Change your _data/players.json player adding your team preferences (select only 10 teams please)
```
{
    "name": "your_name",
    "github": "your_github_user",
    "psn": "your_psn_user",
    "teamPreferences" : [your 10 teams separated by commas]
  }
```
3. Open a pull request to merge your preferences in the players list

## Update match results
1. The local team is responsible for adding the result.
2. Checkout to **round-N** (Where **N** is the number of the round):
3. Change results.json adding the result in the following format:
```
{
    "match_id": 1,
    "home_team": "Name of the local team",
    "home_score": 2,
    "home_goals": ["Name 1", "Name 2"],
    "away_team": "Nameof the visiting team",
    "away_score": 0,
    "away_goals": []
  }
```

4. Open a pull request.

## Check classification
```
TODO
```

## Slack's official channel
```
TODO
```

## Author
[fifaleaguedevs team](https://github.com/orgs/fifaleaguedevs/people)

## Colaborators
https://github.com/fifaleaguedevs/fifaleaguedevs.github.io/graphs/contributors
