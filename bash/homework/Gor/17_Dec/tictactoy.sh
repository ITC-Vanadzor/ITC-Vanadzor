#!/bin/bash

#TODO -> there should be a generic function, which determines if the given player has won the game. Currently there is a code duplication (almost identical "if"s for X and O). 
#TODO -> also, the file, functions and everything should have comments :)

echo "PLAYER 1 INPUT YOUR NAME HERE: "; read player1
echo "PLAYER 2 INPUT YOUR NAME HERE: "; read player2

grid=(' ' ' ' ' ' ' ' ' ' ' ' ' ' ' ' ' ')

board(){
echo -e "_____________"
echo -e "| ${grid[0]} | ${grid[1]} | ${grid[2]} |"
echo -e "_____________"
echo -e "| ${grid[3]} | ${grid[4]} | ${grid[5]} |"
echo -e "_____________"
echo -e "| ${grid[6]} | ${grid[7]} | ${grid[8]} |"
echo -e "_____________"
}

board

game_process(){
for((i=0;i<9;i++))
do
	echo "${player1} please input the number of the box from 0 to 8 : "; read coordinates
		if [ "${grid[coordinates]}" == ' ' ]
			then
				grid[coordinates]=X
			else
				echo "the box is already busy, try again"
				i=$((i-1))
				continue
			fi
board
	echo "${player2} please input the number of the box from 0 to 8 : "; read coordinates
		if [ "${grid[coordinates]}" == ' ' ]
			then
				grid[coordinates]=O
			else
				echo "the box is already busy"
				i=$((i-1))
				continue
		fi
board
if [ "${grid[0]}" == "x" ] && [ "${grid[1]}" == "x" ] && [ "${grid[2]}" == "x" ]
	then
	    echo "CONGRATULATIONS ${player1} YOU WIN"; break
	elif [ "${grid[3]}" == "x" ] && [ "${grid[4]}" == "x" ] && [ "${grid[5]}" == "x" ]
		then	
			echo "CONGRATULATIONS ${player1} YOU WIN"; break
	elif [ "${grid[6]}" == "x" ] && [ "${grid[7]}" == "x" ] && [ "${grid[8]}" == "x" ]
		then
			echo "CONGRATULATIONS ${player1} YOU WIN"; break
	elif [ "${grid[0]}" == "x" ] && [ "${grid[3]}" == "X" ] && [ "${grid[6]}" == "x" ]
		then
			echo "CONGRATULATIONS ${player1} YOU WIN"; break
	elif [ "${grid[1]}" == "x" ] && [ "${grid[4]}" == "X" ] && [ ! "${grid[7]}" == "x" ]
		then
			echo "CONGRATULATIONS ${player1} YOU WIN"; break
	elif [ "${grid[2]}" == "x" ] && [ "${grid[5]}" == "X" ] && [ ! "${grid[8]}" == "x" ]
		then
			echo "CONGRATULATIONS ${player1} YOU WIN"; break
	elif [ "${grid[0]}" == "X" ] && [ "${grid[4]}" == "X" ] && [ ! "${grid[8]}" == "x" ]
		then
			echo "CONGRATULATIONS ${player1} YOU WIN"; break
	elif [ "${grid[2]}" == "X" ] && [ "${grid[4]}" == "X" ] && [ ! "${grid[6]}" == "x" ]
		then
			echo "CONGRATULATIONS ${player1} YOU WIN"; break
fi
if [ "${grid[0]}" == "O" ] && [ "${grid[1]}" == "O" ] && [ "${grid[2]}" == "O" ]
	then
	    echo "CONGRATULATIONS ${player2} YOU WIN"; break
	elif [ "${grid[3]}" == "O" ] && [ "${grid[4]}" == "O" ] && [ "${grid[5]}" == "O" ]
		then	
			echo "CONGRATULATIONS ${player2} YOU WIN"; break
	elif [ "${grid[6]}" == "O" ] && [ "${grid[7]}" == "O" ] && [ "${grid[8]}" == "O" ]
		then
			echo "CONGRATULATIONS ${player2} YOU WIN"; break
	elif [ "${grid[0]}" == "O" ] && [ "${grid[3]}" == "O" ] && [ "${grid[6]}" == "O" ]
		then
			echo "CONGRATULATIONS ${player2} YOU WIN"; break
	elif [ "${grid[1]}" == "O" ] && [ "${grid[4]}" == "O" ] && [ ! "${grid[7]}" == "O" ]
		then
			echo "CONGRATULATIONS ${player2} YOU WIN"; break
	elif [ "${grid[2]}" == "O" ] && [ "${grid[5]}" == "O" ] && [ ! "${grid[8]}" == "O" ]
		then
			echo "CONGRATULATIONS ${player2} YOU WIN"; break
	elif [ "${grid[0]}" == "O" ] && [ "${grid[4]}" == "O" ] && [ ! "${grid[8]}" == "O" ]
		then
			echo "CONGRATULATIONS ${player2} YOU WIN"; break
	elif [ "${grid[2]}" == "O" ] && [ "${grid[4]}" == "O" ] && [ ! "${grid[6]}" == "O" ]
		then
			echo "CONGRATULATIONS ${player2} YOU WIN"; break
fi
done
}

game_process
