#!/bin/bash
all_cards=(HA H2 H3 H4 H5 H6 H7 H8 H9 H10 HJ HQ HK HA H2 H3 H4 H5 H6 H7 H8 H9 H10 HJ HQ HK HA H2 H3 H4 H5 H6 H7 H8 H9 H10 HJ HQ HK HA H2 H3 H4 H5 H6 H7 H8 H9 H10 HJ HQ HK HA H2 H3 H4 H5 H6 H7 H8 H9 H10 HJ HQ HK HA H2 H3 H4 H5 H6 H7 H8 H9 H10 HJ HQ HK HA H2 H3 H4 H5 H6 H7 H8 H9 H10 HJ HQ HK HA H2 H3 H4 H5 H6 H7 H8 H9 H10 HJ HQ HK )
declare -a game_situation

column=0
row=0
str=''
for i in {0..43}
do
	game_situation[$row,$column]=${all_cards[$i]}
	echo $row","$column":"${all_cards[$i]}":::"${game_situation[$row,$column]}
	str=${str}" "${all_cards[$i]}
	let column++
	if [ $column -gt 9 ];then
		column=0
		let row++
	fi
done

all_cards=(${all_cards[@]:44})
echo ${all_cards[@]}
echo ${#all_cards[@]}
echo ${game_situation[@]}
echo ${#game_situation[@]}
echo ${game_situation[1]}
echo ${game_situation[2]}
echo "_______________________"
for value in "${game_situation[@]}"; do 
    printf "%-1s\n" "${value}"
done | column
echo 'str-'$str 
