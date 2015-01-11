#Create Spider game...
#1.pass_cards - Pass cards in 10 columns(4 columns - 6 cards, 6 columns - 5 cards) and 50 cards store in card_store.
#2.print_table - prints the current game.
#3.show_card - shows the last card of the column.
#4.move_card - moves the card from column to column.
#5.is_suit_full - checks if suit is full from King to Ace.
#6.delete_suit - deletes the suit if it is full.
#7.is_move_valid - checks if the move is valid.
#8.is_column_empty
#9.pass_cards_from_store - pass one card to each column from store
#10.win_condition

#!/bin/bash
declare -A comp_cards
declare -a store
num_suit=4
num_cards=13
pack=52
double_pack=104
cards=( ACE 2 3 4 5 6 7 8 9 10 JACK QUEEN KING )
suit=( CLUBS DIAMONDS HEARTS SPADES )
initialize_cards(){
    for((i=0;i<num_suit;i++)) do
        for ((j=0;j<num_cards;j++)) do
            comp_cards[$i,$j]=${cards[$j]}_${suit[$i]}
        done
    done
}
pass_cards(){
store=("${comp_cards[@][@]}" "${comp_cards[@][@]}")
column_1=("${store[@]:0:6}")
column_2=("${store[@]:6:6}")
column_3=("${store[@]:12:6}")
column_4=("${store[@]:18:6}")
column_5=("${store[@]:24:5}")
column_6=("${store[@]:29:5}")
column_7=("${store[@]:34:5}")
column_8=("${store[@]:39:5}")
column_9=("${store[@]:44:5}")
column_10=("${store[@]:49:5}")
play_table=("${column_1[@]}" "${column_2[@]}" "${column_3[@]}" "${column_4[@]}" "${column_5[@]}"
             "${column_6[@]}" "${column_7[@]}" "${column_8[@]}" "${column_9[@]}" "${column_10[@]}")
store=("${store[@]:54:50}")
}

print_table(){
    paste -d' ' <(printf "%-13.13s\n" "${column_1[@]}") <(printf "%-13.13s\n" "${column_2[@]}") <(printf "%-13.13s\n" "${column_3[@]}") <(printf "%-13.13s\n" "${column_4[@]}") <(printf "%-13.13s\n" "${column_5[@]}") <(printf "%-13.13s\n" "${column_6[@]}") <(printf "%-13.13s\n" "${column_7[@]}") <(printf "%-13.13s\n" "${column_8[@]}") <(printf "%-13.13s\n" "${column_9[@]}") <(printf "%s\n" "${column_10[@]}")
}

hide_cards(){
    for iter in "${!column_1[@]}-1"; do
      column_1[$iter]="H"
    done

    for iter in "${!column_2[@]}-1"; do
      column_2[$iter]="H"
    done

    for iter in "${!column_3[@]}-1"; do
      column_3[$iter]="H"
    done

    for iter in "${!column_4[@]}-1"; do
      column_4[$iter]="H"
    done

    for iter in "${!column_5[@]}-1"; do
      column_5[$iter]="H"
    done

    for iter in "${!column_6[@]}-1"; do
      column_6[$iter]="H"
    done

    for iter in "${!column_7[@]}-1"; do
      column_7[$iter]="H"
    done

    for iter in "${!column_8[@]}-1"; do
      column_8[$iter]="H"
    done

    for iter in "${!column_9[@]}-1"; do
      column_9[$iter]="H"
    done

    for iter in "${!column_10[@]}-1"; do
      column_10[$iter]="H"
    done
}
#This function doesn't work!!!
move_card(){
    declare -a src=("${!1}")
    declare -a dest=("${!2}")
    count=${#src[@]}
    dest=("${dest[@]}" "${src[$count - 1]}")
    unset src[$count-1]
    
}

initialize_cards
pass_cards
hide_cards
print_table
move_card column_1[@] column_2[@]
#print_table
#echo ${column_1[@]:(-1)}
#print_question() {
#    echo "Pass the cards from store(yes/no)? "
#    read answer
#    if (answer == 'yes' && not is_empty_spaces)
#        then pass_cards_from_store
#    elif (answer == 'yes' && is_empty_spaces )
#        then echo "Illegal move!!! You must fill all empty spaces."
#    else 
#        echo "Your answer accepted as 'no'"
#    fi
#    while (true){
#        echo "Please choose the column to move from[1-10]: "
#        read choice
#        if (not is_number(choice) || choice < 1 || choice > 10 || is_column_empty(choice))
#            then echo "Invalid number!!!"
#        else 
#            break
#        fi
#        }
#    while (true){
#        echo "Please choose the target column[1-10]: "
#        read target
#        if (not is_number(target) || target < 1 || target > 10 || target == choice)
#            then echo "Invalid number!!!"
#        else 
#            break
#        fi
#        }
#}
#
#main code
#
#pass_cards
#show_cards
#print_table
#
#while(true){
#print_quetion
#if ( not is_move_valid(choice, target) )
#    then echo "The move is invalid,try again." 
#continue
#fi
#move(choice, target)
#if (is_suit_full)
#    then delete_suit
#fi
#
#print_table
#if (win_condition)
#    then echo "YOU WIN!!!"
#    break
#fi
#}
#'''

