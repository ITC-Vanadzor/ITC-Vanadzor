Set_arguments(){
	echo "Set column(Number in top)"; read from 
	echo "Set index card(Number in left)"; read count
	echo "Set new column(Numner in top)"; read to
}
Is_structure(){
	local rm_spaces
	rm_spaces=""
	for i in `seq $count $max_cards_in_column`
	do
		if [ -n ${playing_cards[$from,$i]} ];then
			rm_spaces=$rm_spaces""${playing_cards[$from,$i]}
		fi
	done
	rm_spaces=$(echo $rm_spaces | sed -e 's/[HSDC]//g')
	echo "$structure" | grep -o "$rm_spaces";
}
Is_next_card(){
	mved_cards=$(Mved_cards)
	mved_cards=($mved_cards)
	let prev_index=$(Get_empty_index $to)-1
	is_next=${playing_cards[$to,$prev_index]}${mved_cards[0]}
	is_next=$(echo $is_next | sed -e 's/[HSDC]//g')
	echo "$structure" | grep -o "$is_next";
}
Mved_cards(){
	local mved_cards=""
	for i in `seq $count $max_cards_in_column`
	do
		if [ -n ${playing_cards[$from,$i]} ];then
			mved_cards=$mved_cards" "${playing_cards[$from,$i]}
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
		let n=$i+$index_to
		echo ${mved_cards[$i]};
		playing_cards[$to,$n]=${mved_cards[$i]}
	done
}
Rm_cards(){
	for i in `seq $count $max_cards_in_column`
	do
		if [ -n ${playing_cards[$from,$i]} ];then
			unset playing_cards[$from,$i]; 
		fi
	done
	if [ -z ${playing_cards[$from,0]} ];then
		local to_arr
		to_arr=(${hidden_cards_one[$from]})
		local count=${#to_arr[@]}
		let count--
		playing_cards[$from,0]=${to_arr[$count]}
		unset hidden_cards[$from,$count]
	fi
}
Get_empty_index(){
	local empty_index=$max_cards_in_column
	for j in `seq 0 $max_cards_in_column`
	do 
		if [ -z ${playing_cards[$1,$j]} ];then
			empty_index=$j
			break
		fi
	done
	echo $empty_index
}
Print_cards(){
	number=0
	playing_cards_one=()
	#------------------------------
	Hidden_cards_to_one
	
	echo "_______________________________________________________________________________________";
	echo -n "hidden"$'\t';
	local to_arr
	for i in {0..9}
		do
			to_arr=(${hidden_cards_one[$i]})
			echo -n ${#to_arr[@]}$'\t'
		done
		echo "";
	#------------------------------
	echo "_______________________________________________________________________________________";
	echo $'\t'"#0"$'\t'"#1"$'\t'"#2"$'\t'"#3"$'\t'"#4"$'\t'"#5"$'\t'"#6"$'\t'"#7"$'\t'"#8"$'\t'"#9"$'\t';
	for i in `seq 0 $max_cards_in_column`
	do
		for j in {0..9}
		do
			if [ $j -eq 0 ];then
				echo "_______________________________________________________________________________________";
				echo -n "#$number  |"$'\t';
				let number++
			fi
			echo -n ${playing_cards[$j,$i]}$'\t';
		done
		echo "";
	done
}
Change_cards(){
	while [ -z $game_over ]
	do
		Set_arguments 
		is_true_structue=$(Is_structure)
		is_next_card=$(Is_next_card)
		if [ -z "$is_true_structue" ] || [ -z $is_next_card ];then
			continue
		fi
		Move_cards
		Rm_cards		
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
}
Get_hidden_cards(){
	local i=0
	local j=0
	for n in {0..43}
	do
		hidden_cards[$i,$j]=${all_cards[$n]}
		let i++
		if [ $i -gt 9 ];then
			i=0
			let j++
		fi
	done 
	all_cards=(${all_cards[@]:44})
}
Hidden_cards_to_one(){
	hidden_cards_one=()
	for i in {0..5}
	do	
		for j in {0..9}
			do
				hidden_cards_one[$j]+=" "${hidden_cards[$j,$i]}		
			done
	done
}
Playing_cards_to_one(){
	for i in `seq 0 $max_cards_in_column`
	do	
		for j in {0..9}
			do
				playing_cards_one[$i]+=${playing_cards[$i,$j]}		
			done
	done
}
Get_new_cards(){
	for n in {0..9}
	do
		playing_cards[$n,0]=${all_cards[$n]}
	done 
	all_cards=(${all_cards[@]:10})
}
#*************MAIN************
declare -A showed_cards
declare -A playing_cards
declare -A hidden_cards

Options
Card_generation
cards_structure=($new_cards_str)
max_cards_in_column=5
structure=${cards_structure[@]}
#All cards make random
all_cards=($(shuf -e ${cards_structure[@]}))
structure=$(echo $structure | sed 's/ //g';)
#main code
Get_hidden_cards
#-----------------
Get_new_cards
#-----------------
reset 
Print_cards
structure=$(echo $structure | sed -e 's/[HSDC]//g')
Change_cards
