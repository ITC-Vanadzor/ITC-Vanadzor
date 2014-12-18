#!/bin/bash


declare -A matrix
num_rows=3
num_columns=3


for ((i=1;i<=num_rows;i++)) do
    for ((j=1;j<=num_columns;j++)) do
        matrix[$i,$j]="|___|"
        printf  ${matrix[$i,$j]}
    done
    echo
done


result(){
for ((i=1;i<=num_rows;i++)) do
    for ((j=1;j<=num_columns;j++)) do
        printf  ${matrix[$i,$j]}
    done
    echo
done
}
 players(){
for ((i=1;i<=9;i++)) do
echo "Player 1"; read a b
if [ ${matrix[$i,$j]} ]
    then
        matrix[$a,$b]="|_X_|"
	result
	continue
    else
	echo "WARNING: Try again"
	matrix[$a,$b]="|_X_|"
	result
fi
echo "Player 2"; read c d
if [ ${matrix[$i,$j]} ]
    then
        matrix[$c,$d]="|_O_|"
	result
    else
	echo "WARNING: Try again"
	matrix[$a,$b]="|_O_|"
	result
fi	 
done
}

players
