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

* The bridge cell (if you go on 6 cell you will go directly to 12 cell).
* The goose cell (if you go in any of those 5, 9, 14, 18, 23, 27 you will move again for the same roll).
* Prank (if you go in a cell where there is already a player he will be moved back to your starting position before the roll).

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
- ***For each command the key word will be the first word***

## Examples before starting the game

### Add new Player

You can add players with this command:

```
add "player name"
```

If you write any sentence, the name of the player will be always last word:

```
Hello i want to add a new player called Pippo -> pippo will be the player name
```

this is done because i wanted to avoid to specifically request two words (add player) in order to understand that you want to add someone but an "issue" of this might be:

```
add player     -> player will be the player name
add new player -> player will be the player name
```

So the only time the program will ask to insert a name is if the name is emtpy or the name is duplicated, for the first case:

```
add
```

### Show Signed Players

You can look players who are already joined for the game and are ready to start with this command:

```
Show Signed Players
```

That is a feature i wanted to add because it was convenient to see the names already inserted and how many players are added till now.

### Start

You can start the game with this command:

```
start
```

As i wrote before that game can only start if there are at least two people.

### Exit

You can exit the game with this command:

```
exit
```

This is used in order to close the program in a clean manner.

## Examples after starting the game

A decided to divert a bit from the challenge transforming the game in a turn base game. 
So instead of letting the user decide who play i determine the order of who play in the game based on the insert order in the first menu, that is done because i wanted to make the game a bit more realistic and fun.

### Play Lazy Mode

You can let the PC do automatic roll with this command:

```
play lazy
```

### Play Active Mode

You can do manual roll with this command:

```
play active
```

After that you will be asked to write how much move, so you just need to write a sentence (or just the numbers) with the two numbers:

```
i want to move of 3 and 5
3 5
```

In order to have acceptable roll you can't write a number greater than 6. 

### Look on board

You can look the board with this command:

```
look
```

I added this feature because it was usefull to see who is where in the game, when you look the list, you will see that is order from the player closer to the last cell to the bottom.

### Quit

You can quit from the game with this command:

```
quit
```

This feature was added because i though that if a player got bored of playing he could quit without stopping the game. Of course the lasting player will automatically win.

***Made By Giampaolo Conca***.
