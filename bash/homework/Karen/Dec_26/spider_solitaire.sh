#This code for game spider solitaire in bash script. 
#You can play this game in terminal,
#you can input coordinates cards and view result pressing enter. 
#Game ended when you collecting a sequence of all cards.
######################################################################
#Set options for game, set suits count: one. two or for
Options(){
	reset	
	suits_count="0"
	while [ "$suits_count" != "1" ] && [ "$suits_count" != "2" ] && [ "$suits_count" != "4" ]
		do
			echo "Set Suits cards(1,2 or 4)"; read suits_count
			clear
		done
	suit_changer=$suits_count 
	if [ "$suits_count" == "1" ];then
		suit_changer=4
	fi
	if [ "$suits_count" == "4" ];then
		suit_changer=1
	fi
}
#Set coordinates cards for you can change
Set_arguments(){
	echo "Set column(Number in top)"; read from
	echo "Set index card(Number in left)"; read count
	echo "Set new column(Numner in top)"; read to	
	Validation_all_arguments	
}
#Validation  coordinates  for cards,and set new cards
Validation_all_arguments(){
	if [[ $from =~ ^-?[0-9]+$ ]] && [[ $count =~ ^-?[0-9]+$ ]] && [[ $to =~ ^-?[0-9]+$ ]];then
		echo -n ""
	else
		String_validate		 
	fi
}
#Validation for  errors and new cards getting
String_validate(){
	if [ "$from" == "new" ] || [ "$count" == "new" ] || [ "$to" == "new" ];then
		Get_new_cards
		reset
		Print_cards;
	else
		clear
		Print_cards 		
		echo "INVALID ARGUMENTS"
		from=""
		to=""
		count=""
		Set_arguments;
	fi
}
#Generation cards for game
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
#Get 10 carsd on all cards and set to playing cards
Get_new_cards(){
	for n in {0..9}
	do
		Playing_cards_to_list
		index=${count_cards_in_column[$n]}
		playing_cards[$n,$index]=${all_cards[$n]}
	done 
	Get_max_cards_in_column
	all_cards=(${all_cards[@]:10})
}
#Get list (string variables) from playing cards
Playing_cards_to_list(){
	for i in `seq 0 104`
	do	
		for j in {0..9}
		do
			if [ -z ${playing_cards[$j,$i]} ];then
				echo -n "";
			else
				playing_cards_list[$j]+=${playing_cards[$j,$i]}" "
			fi
		done
	done
}
#Get maximum lenght in playing card column
Get_max_cards_in_column(){
	Playing_cards_to_list
	max_cards_in_column=0
	count_cards_in_column=()
	local to_arr
	for i in {0..9}
	do
		to_arr=(${playing_cards_list[$i]})
		count_cards_in_column[$i]=${#to_arr[@]}
		if [ ${count_cards_in_column[$i]} -gt $max_cards_in_column ];then
			max_cards_in_column=${count_cards_in_column[$i]}
		fi
	done
}
#Return result for sequence cards in same column
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
#Return result for sequence cards in another columns
Is_next_card(){
	mved_cards=$(Mved_cards)
	mved_cards=($mved_cards)
	let prev_index=$(Get_empty_index $to)-1
	is_next=${playing_cards[$to,$prev_index]}${mved_cards[0]}
	is_next=$(echo $is_next | sed -e 's/[HSDC]//g')
	echo "$structure" | grep -o "$is_next";
}
#Return cards for change
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
#Replaced cards on playing cards array 
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
#Removed cards on old column 
Rm_cards(){
	for i in `seq $count $max_cards_in_column`
	do
		if [ -n ${playing_cards[$from,$i]} ];then
			unset playing_cards[$from,$i]; 
		fi
	done
	if [ -z ${playing_cards[$from,0]} ];then
		local to_arr
		to_arr=(${hidden_cards_list[$from]})
		local count=${#to_arr[@]}
		let count--
		playing_cards[$from,0]=${to_arr[$count]}
		unset hidden_cards[$from,$count]
	fi
}
#Return last index column for change
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
#Print info for hidden cards, print count by column
Print_hidden_info(){
	playing_cards_list=()
	Hidden_cards_to_list	
	echo "_______________________________________________________________________________________";
	echo -n "hidden"$'\t';
	local to_arr
	for i in {0..9}
		do
			to_arr=(${hidden_cards_list[$i]})
			echo -n ${#to_arr[@]}$'\t'
		done
		echo "";
}
#Print playing cards in table
Print_cards(){
	Finish_game
	number=0
	Print_hidden_info
	echo "_______________________________________________________________________________________";
	echo $'\t'"#0"$'\t'"#1"$'\t'"#2"$'\t'"#3"$'\t'"#4"$'\t'"#5"$'\t'"#6"$'\t'"#7"$'\t'"#8"$'\t'"#9"$'\t';
	Get_max_cards_in_column
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
	echo "New cards - "${#all_cards[@]}
	echo "Finished - "$win_game" packs "
	echo "Set 'new' for getting new cards"
}
#Play game when game not ended 
Play(){
	while [ 1 -gt $win_game ]
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
	Print_cards
	echo "****************************************************************"
	echo "****************************You win*****************************"
	echo "****************************************************************"
	sleep 5
}
#Get 44 hidden cards from all cards,set cards to list
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
#Get list (string variables) from hidden cards
Hidden_cards_to_list(){
	hidden_cards_list=()
	for i in {0..5}
	do	
		for j in {0..9}
			do
				hidden_cards_list[$j]+=" "${hidden_cards[$j,$i]}		
			done
	done
}
#Check on correctness of sequence cards on one color.If cards sequence is full removed they.
Finish_game(){
	Playing_cards_to_list
	local to_arr
	local last_char
	to_arr=(${playing_cards_list[$to]})
	let rang=${#to_arr[@]}-1
	if [ $rang -gt 11 ];then
		let j_from=$rang-12
		last_char=$(echo "${to_arr[$rang]}" | grep -o "A");
		if [ "$last_char" == "A" ];then
			local is_struct=""
			for j in `seq $j_from $rang`
			do
				is_struct+=${to_arr[$j]}
			done 
			is_struct=$(echo "$structure_strong" | grep -o "$is_struct")
			if [ -z $is_struct ];then
				echo -n "";
			else
				let j_from=$rang-12
				for n in `seq $j_from $rang`
				do
					unset playing_cards[$to,$n]					
				done
				let win_game++
			fi
		fi
	fi
}
#*************MAIN************
declare -A showed_cards
declare -A playing_cards
declare -A hidden_cards
win_game=0
count_cards_in_column=(0 0 0 0 0 0 0 0 0 0)

Options
Card_generation
cards_structure=($new_cards_str)
structure_strong=${cards_structure[@]}
structure_strong=$(echo $structure_strong | sed 's/ //g';)
structure=$(echo $structure_strong | sed -e 's/[HSDC]//g')
all_cards=($(shuf -e ${cards_structure[@]}))
Get_hidden_cards
Get_new_cards
reset 
Print_cards
Play
