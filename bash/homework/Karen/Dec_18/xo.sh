#!/bin/bash

#Functions
start_game(){
    for i in {1..3};
    do
        for j in {1..3};
        do 
            matrix[$i,$j]=0
        done
    done
}

show(){
	echo "   __1___2___3__";
	for i in {1..3};
    do
		echo -n " $i ";
        for j in {1..3};
        do
			if [ ${matrix[$i,$j]} -eq 0 ];then
				echo -n "|   ";
			elif [ ${matrix[$i,$j]} -eq 1 ]; then
				echo -n "| X "
			elif [ ${matrix[$i,$j]} -eq 2 ]; then
				echo -n "| O "
			fi
        done
		echo "|";
		echo "   -------------";
    done
}

input_x_o(){
    echo "Please set coordinates: input number row."; read row
    echo "Please set coordinates: input number column."; read col
	if [ -z $col ] || [ -z $row ] || [ $row -gt 3 ] || [ $row -lt 1 ] || [ $col -lt 1 ] || [ $col -gt 3 ] || [ ! ${matrix[$row,$col]} -eq 0 ]; then
		echo "Coordinates Error!!!";
		input_x_o	
	fi
	if [ $x_or_o -eq 1 ];then
		x_or_o=2
		player=O
	else
		x_or_o=1
		player=X
	fi
    matrix[$row,$col]=$x_or_o
	empy=$(empty_elements)
	if [ $empy -gt 0 ];then
		clear
		show
		end=$(revise)
		if [ $end -eq 0 ];then
			input_x_o
		else
			echo "************$player WIN************";
		fi
	else
		echo "*************END*************";
	fi 
}

empty_elements(){
	count=0
	for i in {1..3};
    do
        for j in {1..3};
        do
			if [ ${matrix[$i,$j]} -eq 0 ];then
				let count++
			fi
        done
    done
	echo $count
}

revise(){
	end=0
	#revise rows
	for i in {1..3};
	do 
		if [ ${matrix[$i,1]} -eq ${matrix[$i,2]} ] && [ ${matrix[$i,2]} -eq ${matrix[$i,3]} ] && [ ${matrix[$i,3]} -ne 0 ]; then
			end=1
		fi
	done
	#revise columns
	for i in {1..3};
	do 
		if [ ${matrix[1,$i]} -eq ${matrix[2,$i]} ] && [ ${matrix[2,$i]} -eq ${matrix[3,$i]} ] && [ ${matrix[3,$i]} -ne 0 ]; then
			end=1
		fi
	done
	#revise diagonal	
	if [ ${matrix[1,1]} -eq ${matrix[2,2]} ] && [ ${matrix[2,2]} -eq ${matrix[3,3]} ] && [ ${matrix[3,3]} -ne 0 ]; then
		end=1
	fi
	if [ ${matrix[1,3]} -eq ${matrix[2,2]} ] && [ ${matrix[2,2]} -eq ${matrix[3,1]} ] && [ ${matrix[3,1]} -ne 0 ]; then
		end=1
	fi
	echo $end 
}

#Main code
declare -A matrix
start_game
show
x_or_o=2
input_x_o
