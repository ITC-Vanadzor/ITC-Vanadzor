#!/bin/bash
#Parameters
cards_structure=(HK HQ HJ H10 H9 H8 H7 H6 H5 H4 H3 H2 HA HK HQ HJ H10 H9 H8 H7 H6 H5 H4 H3 H2 HA HK HQ HJ H10 H9 H8 H7 H6 H5 H4 H3 H2 HA HK HQ HJ H10 H9 H8 H7 H6 H5 H4 H3 H2 HA HK HQ HJ H10 H9 H8 H7 H6 H5 H4 H3 H2 HA HK HQ HJ H10 H9 H8 H7 H6 H5 H4 H3 H2 HA HK HQ HJ H10 H9 H8 H7 H6 H5 H4 H3 H2 HA HK HQ HJ H10 H9 H8 H7 H6 H5 H4 H3 H2 HA  )
declare -A showed_cards
declare -A hidden_cards
max_cards_in_row=5
structure=${cards_structure[@]}
#All cards make random
all_cards=($(shuf -e ${cards_structure[@]}))

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
structure=$(echo $structure | sed 's/ //g';)
#echo $structure
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
Change_cards
