# **Dungeons of Doom** #
Welcome to Dungeons Of Doom: The Video Game.
## **Rules Of The Game**
1. You are spawned randomly into a dungeon. Your goal is to collect all the gold and escape. 
2. You have commands available to you: HELLO, GOLD, MOVE, PICKUP, LOOK, QUIT. 
>HELLO - Displays to you the gold required to win
>
>GOLD - Displays your current gold.
>
>MOVE \<D> - Moves your character in the direction specified (N,S,E,W). You cannot move through walls.
>
>PICKUP - Will pickup any gold on your current location
>
>LOOK - displays your current view of the map
>
> QUIT - quits the game, whether you have won or not.

4. Only PICKUP,MOVE and QUIT will use up your turn. The rest you can use as many times as you like. 

5. Items on the map are represented by symbols: 

>P - you!
>
> . - Normal ground
>
> \# - Wall
>
>G - gold
>
> E - Exit portal

6. Watch out for the Monster (B symbol) ...

## **Setup**
From the root directory : 
-  If on linux, install sox (in all major repos - optional),and run the script.sh file. Else, you will have to compile and run it yourself. On Windows: 
```bat
dir /s /B *.java > sources.txt
javac @sources.txt
java Main
```