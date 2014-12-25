declare -a cards_mast
num_rows=6
num_colums=10
declare -a rand

card=("A" "2" "3" "4" "5" "6" "7" "8" "9" "10" "J" "Q" "K")
mast=("H" "C" "B" "S")

#echo ${card[@]}
#echo ${mast[@]}

for ((i=0;i<=12;i++)) do 
    for ((j=0;j<=3;j++)) do
        cards_mast[$k]=${mast[$j]}${card[$i]}
        printf  ${cards_mast[$k]}
        let k++
    done
        echo
done

rand=$(shuf -e ${cards_mast[@]}) 
echo ${rand[5]}
