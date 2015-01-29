#!/bin/bash

#TODO -> The functions "stugum_x" and "stugum_o" are almost the same - you should just the symbols to be checked as parameter
#TODO -> i dont see much comments here
#TODO -> code formatting (tabs) are inconsistent ("krestik" and "nolik" functions are indented, others are not)

array=("" "" "" "" "" "" "" "" "")

vandak () {
    clear
    echo -e "\t ${array[0]:-0} | ${array[1]:-1} | ${array[2]:-2} "
    echo -e "\t___________"
    echo -e "\t ${array[3]:-3} | ${array[4]:-4} | ${array[5]:-5} "
    echo -e "\t___________"
    echo -e "\t ${array[6]:-6} | ${array[7]:-7} | ${array[8]:-8} "
}

WIN () {
    echo "Player $1 you Win"    
    break
}

stugum () {
    if [ "$1" == "${array[0]}" ] && [ "$1" == "${array[1]}" ] && [ "$1" == "${array[2]}" ] ; then
    WIN $2
    elif [ "$1" == "${array[3]}" ] && [ "$1" == "${array[4]}" ] && [ "$1" == "${array[5]}" ] ; then
    WIN $2
    elif [ "$1" == "${array[6]}" ] && [ "$1" == "${array[7]}" ] && [ "$1" == "${array[8]}" ] ; then
    WIN $2
    elif [ "$1" == "${array[0]}" ] && [ "$1" == "${array[3]}" ] && [ "$1" == "${array[6]}" ] ; then
    WIN $2
    elif [ "$1" == "${array[1]}" ] && [ "$1" == "${array[4]}" ] && [ "$1" == "${array[7]}" ] ; then
    WIN $2
    elif [ "$1" == "${array[2]}" ] && [ "$1" == "${array[5]}" ] && [ "$1" == "${array[8]}" ] ; then
    WIN $2
    elif [ "$1" == "${array[0]}" ] && [ "$1" == "${array[4]}" ] && [ "$1" == "${array[8]}" ] ; then
    WIN $2
    elif [ "$1" == "${array[2]}" ] && [ "$1" == "${array[4]}" ] && [ "$1" == "${array[6]}" ] ; then
    WIN $2
    fi
}

grel() {
	echo "PLAYER$2: number for $1"
	read i
	if [ "${array[i]}" == "o" ] || [ "${array[i]}" == "x" ]; 
	then 
		echo "Vandaky zbacvac e"
		grel $1 $2
	elif [ $i -ge 0 ] && [ $i -le 8 ];
	then
		array[i]=$1
	else
		echo "input valid number"
		grel $1 $2
	fi
}

vandak
j=0
while true;
    do
        grel x 1
        vandak
        stugum x 1
		j=$(($j+1))
		if [ $j == 5 ];
		then
			echo "tie"
			break
		fi
        grel o 2
        vandak
        stugum o 2
    done
