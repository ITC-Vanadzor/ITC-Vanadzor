#!/bin/bash
#Parameters
#TODO -> there should be the other suites too (e.g. spades)
#TODO -> therefore, it would be better to have a function which generates the cards, not to hand type them ;)
#TODO -> the game doesnt let the user to get many cards in a column (the bottom cards werent shown properly)
#TODO -> there are no error messages in case user enters invalid params (e.g. row number == 100)
#TODO -> not clear when the game should be over; there is a check on game_over var which is never initialized

Set_arguments(){
	echo "Set column(Number in top)"; read from 
	echo "Set index card(Number in left)"; read count
	echo "Set new column(Numner in top)"; read to
}
Print_cards(){
	echo "_______________________________________________________________________________________";
	echo $'\t'"#0"$'\t'"#1"$'\t'"#2"$'\t'"#3"$'\t'"#4"$'\t'"#5"$'\t'"#6"$'\t'"#7"$'\t'"#8"$'\t'"#9"$'\t';
	number=0
	for i in `seq 0 $max_cards_in_row`
	do
		for j in {0..9}
		do
			if [ $j -eq 0 ];then
				echo "_______________________________________________________________________________________";
				echo -n "#$number  |"$'\t';
				let number++
			fi
			echo -n ${h_c[$j,$i]}$'\t';
		done
		echo "";
	done
}
Is_structure(){
	local rm_spaces
	rm_spaces=""
	for i in `seq $count $max_cards_in_row`
	do
		if [ -n ${h_c[$from,$i]} ];then
			rm_spaces=$rm_spaces""${h_c[$from,$i]}
		fi
	done
	echo "$structure" | grep -o "$rm_spaces";
}
Is_next_card(){
	mved_cards=$(Mved_cards)
	mved_cards=($mved_cards)
	let prev_index=$(Get_empty_index $to)-1
	is_next=${h_c[$to,$prev_index]}${mved_cards[0]}
	echo "$structure" | grep -o "$is_next";
}
Mved_cards(){
	local mved_cards=""
	for i in `seq $count $max_cards_in_row`
	do
		if [ -n ${h_c[$from,$i]} ];then
			mved_cards=$mved_cards" "${h_c[$from,$i]}
		fi
	done
	echo $mved_cards;
}
Move_cards(){
	mved_cards=$(Mved_cards)
	mved_cards=($mved_cards)
	index_to=$(Get_empty_index $to)
	for i in `seq 0 ${#mved_cards[@]-1}`
	do
		let j=$i+$index_to
		echo ${mved_cards[$i]}"--loop--$j";
		h_c[$to,$j]=${mved_cards[$i]}	
	done
}
Rm_cards(){
	for i in `seq $count $max_cards_in_row`
	do
		if [ -n ${h_c[$from,$i]} ];then
			unset h_c[$from,$i]
		fi
	done
}
Get_empty_index(){
	local empty_index=$max_cards_in_row
	for j in `seq 0 $max_cards_in_row`
	do 
		if [ -z ${h_c[$1,$j]} ];then
			empty_index=$j
			break
		fi
	done
	echo $empty_index
}
Change_cards(){
	while [ -z $game_over ]
	do
		Set_arguments 
		h_c_str=()
		is_true_structue=$(Is_structure)
		is_next_card=$(Is_next_card)
		if [ -z "$is_true_structue" ] || [ -z $is_next_card ];then
			clear
			Print_cards
			continue
		fi
		Move_cards
		Rm_cards
		
		for i in {0..9}
		do
			for j in `seq 0 $max_cards_in_row`
			do 
				h_c_str[$i]=${h_c_str[$i]}" "${h_c[$i,$j]}
			done
		done		
		mv_card=(${h_c_str[$to]})
		if [ ${#mv_card[@]-1} -gt $max_cards_in_row ];then
			max_cards_in_row=${#mv_card[@]-1}
		fi
		clear
		Print_cards
	done
}
Card_generation(){
	local card=""
	local suits=("H" "S" "D" "C")
	local n=0
	local suit=${suits[$n]}
	local i=103
	local tmp
	let tmp=26*$suit_changer
	echo $tmp
	while [ $i -gt -1 ]
	do
		let chamge=($i+1)%$tmp 
		if [ $chamge -eq 0 ];then
			suit=${suits[$n]}
			let n=$n+1
		fi
		let card=$i%13+1
		case "$card" in
			1)  card="A"
			    ;;
			11)  card="J"
				;;
			12)  card="Q"
				;;
			13)  card="K"
				;;
		esac
		new_cards_str+="$suit$card "; 
		let i=$i-1
	done
}
Options(){
	reset	
	suits_count="0"
	while [ $suits_count -ne 1 ] && [ $suits_count -ne 2 ] && [ $suits_count -ne 4 ]
		do
			echo "Set Suit cards(1,2 or 4)"; read suits_count
		done
	suit_changer=$suits_count 
	if [ $suits_count -eq 1 ];then
		suit_changer=4
	fi
	if [ $suits_count -eq 4 ];then
		suit_changer=1
	fi
	echo $suit_changer
}
#*************MAIN************
declare -A showed_cards
declare -A hidden_cards

Options
Card_generation
cards_structure=($new_cards_str)
max_cards_in_row=5
structure=${cards_structure[@]}
#All cards make random
all_cards=($(shuf -e ${cards_structure[@]}))
structure=$(echo $structure | sed 's/ //g';)
#main code
	declare -A h_c
	i=0
	j=0
	for n in {0..43}
	do
		h_c[$i,$j]=${all_cards[$n]}
		let i++
		if [ $i -gt 9 ];then
			i=0
			let j++
		fi
	done 
#-----------------
reset 
Print_cards
#echo ${cards_structure[@]}
#echo $structure

Change_cards
