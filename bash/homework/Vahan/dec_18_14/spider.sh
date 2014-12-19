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
pass_cards(){

}


print_question() {
    echo "Pass the cards from store(yes/no)? "
    read answer
    if (answer == 'yes' && not is_empty_spaces)
        then pass_cards_from_store
    elif (answer == 'yes' && is_empty_spaces )
        then echo "Illegal move!!! You must fill all empty spaces."
    else 
        echo "Your answer accepted as 'no'"
    fi
    while (true){
        echo "Please choose the column to move from[1-10]: "
        read choice
        if (not is_number(choice) || choice < 1 || choice > 10 || is_column_empty(choice))
            then echo "Invalid number!!!"
        else 
            break
        fi
        }
    while (true){
        echo "Please choose the target column[1-10]: "
        read target
        if (not is_number(target) || target < 1 || target > 10 || target == choice)
            then echo "Invalid number!!!"
        else 
            break
        fi
        }
}

#main code

pass_cards
show_cards
print_table

while(true){
print_quetion
if ( not is_move_valid(choice, target) )
    then echo "The move is invalid,try again." 
continue
fi
move(choice, target)
if (is_suit_full)
    then delete_suit
fi

print_table
if (win_condition)
    then echo "YOU WIN!!!"
    break
fi
}












