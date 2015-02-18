declare -a x

for i in {0..2}
do
    for j in {0..2}
    do
        x[$i,$j]=$i"-"$j
        echo ${x[$i,$j]}
        done
    done

echo ${x[20,80]}
