#!/bin/bash
# ALGORITHM
# 1.board function will be executed with array elements values every time when players input element to array
# 2.win_cases function will check if there is win case after every element input.
# 3.tie function will print message when each element is filled in and no one won(can be executed only in input_funcion)
# 4.input_function will ask players to input x or o and check if that index of array is free or valid.After checking it  
# will put x or y in that given index
#P.S. At the very begining of the game players input their names and recieve the symbol, that will be put in board when they choose index. 
echo "Input the first player name: "; read player1
echo "${player1} your symbol is x "
sleep 2
echo "Input the second player name: "; read player2
echo "${player2} your symbol is o "
sleep 2
export player
array=(' ' ' ' ' ' ' ' ' ' ' ' ' ' ' ' ' ') 
board(){
    echo -e "\t_____________"
    echo -e "\t| ${array[0]} | ${array[1]} | ${array[2]} |"
    echo -e "\t_____________"
    echo -e "\t| ${array[3]} | ${array[4]} | ${array[5]} |"
    echo -e "\t_____________"
    echo -e "\t| ${array[6]} | ${array[7]} | ${array[8]} |"
    echo -e "\t_____________"
}

board
win_status=0
win_cases(){
    if [ "${array[0]}" == "${array[1]}" ] && [ "${array[0]}" == "${array[2]}" ] && [ ! "${array[0]}" == ' ' ]  
        then echo "BRAVO!!!  $player WON!!!"
             win_status=1 
   
    elif [ "${array[3]}" == "${array[4]}" ] && [ "${array[3]}" == "${array[5]}" ] && [ ! "${array[3]}" == ' ' ] 
        then echo "BRAVO!!!  $player WON!!!"
             win_status=1
   
    elif [ "${array[6]}" == "${array[7]}" ] && [ "${array[6]}" == "${array[8]}" ] && [ ! "${array[6]}" == ' ' ] 
        then echo "BRAVO!!!  $player WON!!!"
             win_status=1
    
    elif [ "${array[0]}" == "${array[3]}" ] && [ "${array[0]}" == "${array[6]}" ] && [ ! "${array[0]}" == ' ' ] 
        then echo "BRAVO!!!  $player WON!!!"
             win_status=1   

    elif [ "${array[1]}" == "${array[4]}" ] && [ "${array[1]}" == "${array[7]}" ] && [ ! "${array[1]}" == ' ' ] 
        then echo "BRAVO!!!  $player WON!!!"
             win_status=1   

    elif [ "${array[2]}" == "${array[5]}" ] && [ "${array[2]}" == "${array[8]}" ] && [ ! "${array[2]}" == ' ' ] 
        then echo "BRAVO!!!  $player WON!!!"
             win_status=1   
 
    elif [ "${array[0]}" == "${array[4]}" ] && [ "${array[0]}" == "${array[8]}" ] && [ ! "${array[0]}" == ' ' ] 
        then echo "BRAVO!!!  $player WON!!!"
             win_status=1  
 
    elif [ "${array[2]}" == "${array[4]}" ] && [ "${array[2]}" == "${array[6]}" ] && [ ! "${array[2]}" == ' ' ] 
        then echo "BRAVO!!!  $player WON!!!"
             win_status=1    
    fi
}
#win_cases
#echo $win_status
tie(){
    if [ $i == 8 ]
       then echo "*****Tie****"
       fi
}

input_element(){
    for((i=0;i<9;i++))
    do
        player_turn=$((i % 2))
        if [ ${player_turn} == 0 ]
            then player=$player1                 
                 echo "${player} please input the number of the box from 0 to 8 : "; read index
                         if [ "${array[index]}" == ' ' ]
                              then
                                  array[index]=x
                         else echo "the box is already busy, try again"
                              i=$((i-1))
                              continue              
                         fi
        else 
            player=$player2
            echo "${player} please input the number of the box from 0 to 8 : "; read index
                  if [ "${array[index]}" == ' ' ]
                     then
                         array[index]=o
                  else echo "the box is already busy"
                       i=$((i-1))
                       continue              
                  fi
        fi
        board
        win_cases
        if [ ${win_status} == 1 ]
            then
                break
        fi
        tie
    done
}
input_element

