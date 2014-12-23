#!/bin/bash


declare -a matrix
declare player1=X
declare player2=O
num_rows=3
num_columns=3


for ((i=1;i<=num_rows;i++)) do
    for ((j=1;j<=num_columns;j++)) do
        grid[$i,$j]="|___|"
	player1[$i,$j]="|_X_|"
	player2[$i,$j]="|_O_|"
        printf  ${grid[$i,$j]}
    done
    echo
done


player1=$(grid[$i,$j]=a,b)
    echo paste
    read a b
	echo $player1
