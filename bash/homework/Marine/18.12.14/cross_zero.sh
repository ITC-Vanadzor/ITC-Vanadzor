#!/bin/bash
 
declare -A matrix
num_rows=3
num_columns=3

# Tpum e skzbnakan matrixy
for ((i=1;i<=num_rows;i++)) do 
    for ((j=1;j<=num_columns;j++)) do
        matrix[$i,$j]="|___|"
        printf  ${matrix[$i,$j]}
    done
    echo
done

# Tpum e martizy arden avelacvac elementnerov
func1(){
    for ((i=1;i<=num_rows;i++)) do
        for ((j=1;j<=num_columns;j++)) do
            printf  ${matrix[$i,$j]}
        done
    echo
    done
}

# Nermucum enq koordinatnery ev "x" kam "o"
func2(){
        echo "player"; read a b
        while [ $a -gt 3 -o $a -lt 1 ];do
            echo "input new a"; read a
        done

        while [ $b -gt 3 -o $b -lt 1 ];do
            echo "input new b"; read b
        done
        echo "mutqagreq x kam o"; read xo
        
        while [ $xo != "x" -a $xo != "o" ];do
            echo "input x or o"; read xo
        done   
}

func3(){
    func2
    while [ ${matrix[$a,$b]}!="|___|" ];do
        echo "mutqagreq nor koordinatner"
        func2
    done
    matrix[$a,$b]="|_"$xo"_|"
    func1
    
    k=0
    for ((i=1;i<=2;i++));do 
        if [ ${matrix[$i,$b]}==${matrix[$(($i+1)),$b]} ]; then
            let k++
        fi
    done
    
    l=0
    for ((j=1;j=2;j++));do 
        if [ ${matrix[$a,$j]}==${matrix[$a,$(($j+1))]} ]; then
            let l++
        fi
    done
    if [ $l -eq 2 -o $k -eq 2 ]; then
        echo "Very good"
    else
        func2
    fi
}

func3

