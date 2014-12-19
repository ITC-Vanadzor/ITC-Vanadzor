#!/bin/bash
all_cards=(HA H2 H3 H4 H5 H6 H7 H8 H9 H10 HJ HQ HK HA H2 H3 H4 H5 H6 H7 H8 H9 H10 HJ HQ HK HA H2 H3 H4 H5 H6 H7 H8 H9 H10 HJ HQ HK HA H2 H3 H4 H5 H6 H7 H8 H9 H10 HJ HQ HK HA H2 H3 H4 H5 H6 H7 H8 H9 H10 HJ HQ HK HA H2 H3 H4 H5 H6 H7 H8 H9 H10 HJ HQ HK HA H2 H3 H4 H5 H6 H7 H8 H9 H10 HJ HQ HK HA H2 H3 H4 H5 H6 H7 H8 H9 H10 HJ HQ HK )

#Array convert to string
make_random(){
for i in {0..103}
do
    echo ${all_cards[$i]}
    let j++
done | shuf
}

#String convert to array
all_cards_rangom=($(make_random))

get_hidden_44_cards(){
    game_situation=('' '' '' '' '' '' '' '' '' '')
    j=0
    for i in {0..43}
    do
        game_situation[$j]=${game_situation[$j]}${all_cards_rangom[$i]}
        let j++
        if [ $j -gt 9 ];then
            j=0
        fi
    done
    echo ${game_situation[@]}
    echo ${game_situation[1]}
}

echo ${all_cards_rangom[@]}
get_hidden_44_cards
kkk=$(shuf -e ${all_cards[@]})
echo "____________";
echo ${kkk[@]}
