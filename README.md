# Goose Game with Java 8

This is my project releated to the Goose Game Kata challenge (https://github.com/xpeppers/goose-game-kata).

## Features

* Add players with simple command line.
* Look players joined in the game.
* Each player have his round, **first to join first to play**.
* Players can look on the board in order to see how is going.
* Players can quit from the game in any time.
* Players can choose how to move themself (Automatic roll or manual roll.

### In Game Features

* The bridge cell 
* The goose cell
* Prank

## How to Play 

 Write command start.

## Rules and info

- Player name must not be emtpy.
- Player name must not be duplicated.
- You need to add at least **two players** in order to play.
- You need to specify with **active** or **lazy** how you want to move in your round.
- Active play must not roll more than 6 for each dice.
- If everyone quit from the game the winner will be last player.
- The board will show from the top to the botton the closer player to the victory.
- ***If you exit or quit there is no turning back***

## Examples

You can add players with this command:

```
add "player name"
```

You can look players ready with this command:

```
show
```

You can exit the game with this command:

```
exit
```

You can start the game with this command:

```
start
```

You can look the board with this command:

```
look
```

You can quit from the game with this command:

```
quit
```

You can do manual roll with this command:

```
play active
```

You can do automatic roll with this command:

```
play lazy
```

***Made By Giampaolo Conca***.
