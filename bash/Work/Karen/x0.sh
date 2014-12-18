#!/bin/bash

start_game(){
    for i in {1..3};
    do
        for j in {1..3};
        do 
            a[$i,$j]=0
        done
    done
}
start_game

show(){
    echo -------------;    
    for i in {1..3};
    do
        echo "| "${a[$i,1]}" | "${a[$i,2]}" | "${a[$i,3]}" |";
    done
    echo -------------;    
}
show

input_x_0(){
    echo "Please set coordinates: input number row."; read row
    echo "Please set coordinates: input number column."; read col
    echo "Please X or O"; read x_or_o
    a[$row,$col]=$x_or_o
    echo ${a[$row,$col]} $x_or_o
    echo ${a[1,2]} 
}
a[2 2]=L
echo ${a[2 2]}
echo ${a[1 2]}
#input_x_0
show
