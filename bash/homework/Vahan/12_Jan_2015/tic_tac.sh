#!/bin/bash

declare -A deck[3][3]

rows=3
columns=3

empty_deck(){
   for((i=0;i<rows;i++)) do
        for ((j=0;j<columns;j++)) do
            deck[$i,$j]="[-]"
        done
    done
}

print_deck(){
   for((i=0;i<rows;i++)) do
        for ((j=0;j<columns;j++)) do
            printf ${deck[$i,$j]}
        done
        echo
    done
}

move(){
    if [ "${deck[$1,$2]}" != "[-]" ]
        then
            echo "Hey!This place is busy!!!"
            continue
    else
        deck[$1,$2]="[$3]"
    fi
}

is_end(){
    if [ "${deck[0,$i_column]}" == "${deck[1,$i_column]}" ] && [ "${deck[1,$i_column]}" == "${deck[2,$i_column]}" ]  
       then 
            echo "YOU WIN!!!"
            exit
    elif [ "${deck[$i_row,0]}" == "${deck[$i_row,1]}" ] && [ "${deck[$i_row,1]}" == "${deck[$i_row,2]}" ] 
        then 
            echo "YOU WIN!!!"
            exit
    elif [ "${deck[0,0]}" == "${deck[1,1]}" ] && [ "${deck[1,1]}" == "${deck[2,2]}" ] && [ "${deck[1,1]}" != "[-]" ] 
        then 
            echo "YOU WIN!!!"
            exit
    elif [ "${deck[0,2]}" == "${deck[1,1]}" ] && [ "${deck[1,1]}" == "${deck[2,0]}" ] && [ "${deck[1,1]}" != "[-]" ] 
        then 
            echo "YOU WIN!!!"
            exit
    fi
}

is_valid_input() {
    re='^[0-2]+$'
    if ! [[ $1 =~ $re ]]
        then 
            echo "INVALID INPUT.TRY AGAIN!!!"
            continue
    fi
}

is_valid_symbol(){
    if [ "$symbol" != "x" ] && [ "$symbol" != "o" ]  
        then
            echo "INVALID INPUT.TRY AGAIN!!!"
            continue
    elif [ "$symbol" == "$i_symbol" ]
        then
            echo "USE THE NEXT SYMBOL!!!"   
            continue
    fi
}

empty_deck
print_deck
h=0
  while [ $h -lt ${#deck[*]} ]
    do    
        echo "make move: enter number of row: "
        read i_row
        is_valid_input $i_row
        echo "enter number of column: "
        read i_column
        is_valid_input $i_column
        echo "enter the symbol: "
        read symbol
        is_valid_symbol
        i_symbol="$symbol"
        move $i_row $i_column $symbol
        clear
        print_deck
        is_end
        ((h++))
    done
echo "STAND-OFF"
exit
