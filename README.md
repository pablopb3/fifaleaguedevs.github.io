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

## Upload Goal Videos

Once you've ended your exciting match it's time to upload your amazing match goals so all 
fifadev adicts can enjoy them!

At this point, it's worth to remenber uncle Ben words to you (yes you, local team's manager 
:wink:):

> *Remember, with great power comes great responsibility.*

![alt tag](https://github.com/fifaleaguedevs/fifaleaguedevs.github.io/blob/master/pictures/UncleBen.jpg)

You may be wondering why to bring uncle Ben back, the answer is simple: **If you want to 
upload goals, you have to stay in the match till the very end and wait to end of the match 
screen**. If local team (host of the party) leaves (due to a dramatic 0-5 loss or whatever) 
there is no end of the match screen, the away team would only see a demoralizing *connection 
is lost*.

Now that you all have this clear the steps to follow are easy:

**Record Goals:**

1. Click on a goal video.
2. Double click the ps4 controller button share. A little icon in the top left corner of 
   your 
   screen will tell you the recording has started.
3. Double click again to stop recording. Again and surprisingly an icon pops in your sreen's 
   top left corner.
4. Repeat steps 1 to 3 for all match goals.

**Share Goals:**

At the moment we do not have a standard way to share the goals, but you have plenty of options (actually two... :joy:):

* Export them to a pendrive and send them to <fifaleaguedevs@gmail.com>.
* Upload them to your Youtube account and share with us throgh our official twitter 
  (@fifaleaguedevs).

## Slack's official channel
```
TODO
```

## Author
[fifaleaguedevs team](https://github.com/orgs/fifaleaguedevs/people)

## Colaborators
https://github.com/fifaleaguedevs/fifaleaguedevs.github.io/graphs/contributors
