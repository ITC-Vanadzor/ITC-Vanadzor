#!/bin/bash

#Global variables 
DECK=52
CARDS_IN_SUIT=13
SUIT=4
TOTAL_DECK=104
 
#local variables
declare -a deck
declare -a suit
declare -a card_number
declare  cards_state  #picked:1 or unpicked:0
card_number=(2 3 4 5 6 7 8 9 10 J Q K A)   #cards of one suit
suit=(C D H S)
cards_state=0

initialize_deck(){
    for((j=0;j<CARDS_IN_SUIT;j++))
         do
           for((k=0;k<SUIT;k++))
              do
                 
                     echo -e "\t${suit[k]} ${card_number[j]}"
                   
                   
              done

         done
}
initialize_deck

print_table(){
    echo -e "\t____\t_____\t_____\t_____\t_____\t_____\t_____\t_____\t_____\t_____"
    echo -e "\t"${deck[1]}
}
print_table
