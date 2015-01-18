#!/bin/bash
 
declare -A grid
num_rows=3
num_columns=3
#TODO -> it is better to keep just the data, not the formatting with it (in this case, we should not store "|" symbols for the grid cells, just print the cells when we want)
player0="|___|"
player1="|_X_|"
player2="|_O_|"
#TODO -> why do we store X and Y into "a" and "b" variables?
declare a
declare b
declare player

start(){
    for ((i=1;i<=num_rows;i++)) do 
        for ((j=1;j<=num_columns;j++)) do
            grid[$i,$j]=0
        done
        echo
    done
}

show_grid(){
    for ((i=1;i<=num_rows;i++)) do
        for ((j=1;j<=num_columns;j++)) do
            if [ ${grid[$i,$j]} -eq 0 ];then
                printf  $player0 
            fi
            
            if [ ${grid[$i,$j]} -eq 1 ];then
                printf  $player1   
            fi
            
            if [ ${grid[$i,$j]} -eq 2 ];then
                printf  $player2  
            fi
        done
    echo
    done
}

input_X(){
    echo "Input x coordinates"; read a 
    while [ $a -gt 3 -o $a -lt 1 ];do
        echo "Input new x"; read a
    done
}

input_Y(){
    echo "Input y coordinates"; read b 
    while [ $b -gt 3 -o $b -lt 1 ];do
        #TODO -> why do we ask to input new b, if we are supposed to input Y?
        echo "input new b"; read b
    done
}

main(){
    if [ $k -ne 9 ];then
        input_X
        input_Y
        if [ ${grid[$a,$b]} -ne 0 ];then
            echo "input new coordinates"
            main
        fi
    else 
        echo "END GAME"
        exit
    fi
    let k++
    grid[$a,$b]=$player
    echo ${grid[$a,$b]}
    x_or_o    
    show_grid
    check_win
}

check_win(){    
    if [ ${grid[1,$b]} -eq ${grid[2,$b]} ] &&  [ ${grid[2,$b]} -eq ${grid[3,$b]} ] ; then
        win
    elif [ ${grid[$a,1]} -eq ${grid[$a,2]} ] && [ ${grid[$a,2]} -eq ${grid[$a,3]} ]; then
        win
    else       
        check_diagonal
    fi
}

check_diagonal(){
    if [ ${grid[1,1]} -eq ${grid[2,2]} ] && [ ${grid[2,2]} -eq ${grid[3,3]} ] && [ ${grid[1,1]} -ne 0 ];then
        win 
    elif [ ${grid[1,3]} -eq ${grid[2,2]} ] && [ ${grid[2,2]} -eq ${grid[3,1]} ] && [ ${grid[1,3]} -ne 0 ];then
        win
    else
        main
    fi
}

win(){
    echo "YOU WIN!!!!!!!!"
    exit
}

x_or_o(){
    if [ $player -eq 1 ];then
        player=2
    else
        player=1
    fi
}

start
show_grid
player=1
k=0
main

