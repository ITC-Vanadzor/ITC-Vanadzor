#!/bin/bash
#Created by Eduard Hakobyan
#to be continued...

# TODO -> Please move the common game loginc from the cases into functions and call them as necessary.
# TODO -> We NEED some comments here, especially on global vars and on the functions that you should add (see above ;)
declare -A matrix
num_rows=3
num_columns=3


for ((i=1;i<=num_rows;i++)) do
    for ((j=1;j<=num_columns;j++)) do
        matrix[$i,$j]="_"
    done
done

f2=" %9s"

for ((j=1;j<=num_columns;j++)) do
    for ((i=1;i<=num_rows;i++)) do
        printf "$f2" ${matrix[$i,$j]}
    done
    echo
done


echo "@ntreq inchpes sksel xax@. [X/0]"

read item
case "$item" in
	x|X)
	
		for ((c=1;c<=5;c++)) do
			
			echo "Xaxacox 1 nermuceq syan hamar@:(1-3)"; read y
			echo "Xaxacox 1 nermuceq toxi hamar@:(1-3)"; read x

			for ((j=1;j<=num_columns;j++)) do
			    for ((i=1;i<=num_rows;i++)) do
	
					if [[ "$x" -eq "$i" && "$y" -eq "$j" ]]; then
					 	matrix[$i,$j]="$item"
						printf "$f2" ${matrix[$i,$j]}
					else
						printf "$f2" ${matrix[$i,$j]}
					fi
			    done
			    echo
			done

if [ ${matrix[1,1]} = "X" ] && [ ${matrix[1,2]} = "X" ] && [ ${matrix[1,3]} = "X" ]; then
	echo "XAXACOX 1 WWWwIIIINNNN"; break
elif [ ${matrix[2,1]} = "X" ] && [ ${matrix[2,2]} = "X" ] && [ ${matrix[2,3]} = "X" ]; then
	echo "XAXACOX 1 WWWwIIIINNNN"; break
elif [ ${matrix[3,1]} = "X" ] && [ ${matrix[3,2]} = "X" ] && [ ${matrix[3,3]} = "X" ]; then
	echo "XAXACOX 1 WWWwIIIINNNN"; break
elif [ ${matrix[1,1]} = "X" ] && [ ${matrix[2,1]} = "X" ] && [ ${matrix[3,1]} = "X" ]; then
	echo "XAXACOX 1 WWWwIIIINNNN"; break
elif [ ${matrix[2,1]} = "X" ] && [ ${matrix[2,2]} = "X" ] && [ ${matrix[3,2]} = "X" ]; then
	echo "XAXACOX 1 WWWwIIIINNNN"; break
elif [ ${matrix[3,1]} = "X" ] && [ ${matrix[3,2]} = "X" ] && [ ${matrix[3,3]} = "X" ]; then
	echo "XAXACOX 1 WWWwIIIINNNN"; break
elif [ ${matrix[1,1]} = "X" ] && [ ${matrix[2,2]} = "X" ] && [ ${matrix[3,3]} = "X" ]; then
	echo "XAXACOX 1 WWWwIIIINNNN"; break
elif [ ${matrix[3,1]} = "X" ] && [ ${matrix[2,2]} = "X" ] && [ ${matrix[1,3]} = "X" ]; then
	echo "XAXACOX 1 WWWwIIIINNNN"; break
fi

			echo "Xaxacox 2 nermuceq syan hamar@:(1-3)"; read y
			echo "Xaxacox 2 nermuceq toxi hamar@:(1-3)"; read x

			for ((j=1;j<=num_columns;j++)) do
			    for ((i=1;i<=num_rows;i++)) do
	
					if [[ "$x" -eq "$i" && "$y" -eq "$j" ]]; then
					 	matrix[$i,$j]="0"
						printf "$f2" ${matrix[$i,$j]}
					else
						printf "$f2" ${matrix[$i,$j]}
					fi
			    done
			    echo
			done
	

if [ ${matrix[1,1]} = "0" ] && [ ${matrix[1,2]} = "0" ] && [ ${matrix[1,3]} = "0" ]; then
	echo "XAXACOX 2 WWWwIIIINNNN"; break
elif [ ${matrix[2,1]} = "0" ] && [ ${matrix[2,2]} = "0" ] && [ ${matrix[2,3]} = "0" ]; then
	echo "XAXACOX 2 WWWwIIIINNNN"; break
elif [ ${matrix[3,1]} = "0" ] && [ ${matrix[3,2]} = "0" ] && [ ${matrix[3,3]} = "0" ]; then
	echo "XAXACOX 2 WWWwIIIINNNN"; break
elif [ ${matrix[1,1]} = "0" ] && [ ${matrix[2,1]} = "0" ] && [ ${matrix[3,1]} = "0" ]; then
	echo "XAXACOX 2 WWWwIIIINNNN"; break
elif [ ${matrix[2,1]} = "0" ] && [ ${matrix[2,2]} = "0" ] && [ ${matrix[3,2]} = "0" ]; then
	echo "XAXACOX 2 WWWwIIIINNNN"; break
elif [ ${matrix[3,1]} = "0" ] && [ ${matrix[3,2]} = "0" ] && [ ${matrix[3,3]} = "0" ]; then
	echo "XAXACOX 2 WWWwIIIINNNN"; break
elif [ ${matrix[1,1]} = "0" ] && [ ${matrix[2,2]} = "0" ] && [ ${matrix[3,3]} = "0" ]; then
	echo "XAXACOX 2 WWWwIIIINNNN"; break
elif [ ${matrix[3,1]} = "0" ] && [ ${matrix[2,2]} = "0" ] && [ ${matrix[1,3]} = "0" ]; then
	echo "XAXACOX 2 WWWwIIIINNNN"; break
fi
		done
echo "GAME OVER"
	;;

	0)
		for ((c=1;c<=5;c++)) do

			echo "Xaxacox 1 nermuceq syan hamar@:(1-3)"; read y
			echo "Xaxacox 1 nermuceq toxi hamar@:(1-3)"; read x

			for ((j=1;j<=num_columns;j++)) do
			    for ((i=1;i<=num_rows;i++)) do
	
					if [[ "$x" -eq "$i" && "$y" -eq "$j" ]]; then
					 	matrix[$i,$j]="0"
						printf "$f2" ${matrix[$i,$j]}
						else
						printf "$f2" ${matrix[$i,$j]}
					fi
			   
				 done
			     echo
			done


if [ ${matrix[1,1]} = "0" ] && [ ${matrix[1,2]} = "0" ] && [ ${matrix[1,3]} = "0" ]; then
	echo "XAXACOX 1 WWWwIIIINNNN"; break
elif [ ${matrix[2,1]} = "0" ] && [ ${matrix[2,2]} = "0" ] && [ ${matrix[2,3]} = "0" ]; then
	echo "XAXACOX 1 WWWwIIIINNNN"; break
elif [ ${matrix[3,1]} = "0" ] && [ ${matrix[3,2]} = "0" ] && [ ${matrix[3,3]} = "0" ]; then
	echo "XAXACOX 1 WWWwIIIINNNN"; break
elif [ ${matrix[1,1]} = "0" ] && [ ${matrix[2,1]} = "0" ] && [ ${matrix[3,1]} = "0" ]; then
	echo "XAXACOX 1 WWWwIIIINNNN"; break
elif [ ${matrix[2,1]} = "0" ] && [ ${matrix[2,2]} = "0" ] && [ ${matrix[3,2]} = "0" ]; then
	echo "XAXACOX 1 WWWwIIIINNNN"; break
elif [ ${matrix[3,1]} = "0" ] && [ ${matrix[3,2]} = "0" ] && [ ${matrix[3,3]} = "0" ]; then
	echo "XAXACOX 1 WWWwIIIINNNN"; break
elif [ ${matrix[1,1]} = "0" ] && [ ${matrix[2,2]} = "0" ] && [ ${matrix[3,3]} = "0" ]; then
	echo "XAXACOX 1 WWWwIIIINNNN"; break
elif [ ${matrix[3,1]} = "0" ] && [ ${matrix[2,2]} = "0" ] && [ ${matrix[1,3]} = "0" ]; then
	echo "XAXACOX 1 WWWwIIIINNNN"; break
fi
			echo "Xaxacox 2 nermuceq syan hamar@:(1-3)"; read y
			echo "Xaxacox 2 nermuceq toxi hamar@:(1-3)"; read x

			for ((j=1;j<=num_columns;j++)) do
			    for ((i=1;i<=num_rows;i++)) do
	
					if [[ "$x" -eq "$i" && "$y" -eq "$j" ]]; then
					 	matrix[$i,$j]="X"
						printf "$f2" ${matrix[$i,$j]}
						else
						printf "$f2" ${matrix[$i,$j]}
					fi
			    done
			    echo
			done
if [ ${matrix[1,1]} = "X" ] && [ ${matrix[1,2]} = "X" ] && [ ${matrix[1,3]} = "X" ]; then
	echo "XAXACOX 2 WWWwIIIINNNN"; break
elif [ ${matrix[2,1]} = "X" ] && [ ${matrix[2,2]} = "X" ] && [ ${matrix[2,3]} = "X" ]; then
	echo "XAXACOX 2 WWWwIIIINNNN"; break
elif [ ${matrix[3,1]} = "X" ] && [ ${matrix[3,2]} = "X" ] && [ ${matrix[3,3]} = "X" ]; then
	echo "XAXACOX 2 WWWwIIIINNNN"; break
elif [ ${matrix[1,1]} = "X" ] && [ ${matrix[2,1]} = "X" ] && [ ${matrix[3,1]} = "X" ]; then
	echo "XAXACOX 2 WWWwIIIINNNN"; break
elif [ ${matrix[2,1]} = "X" ] && [ ${matrix[2,2]} = "X" ] && [ ${matrix[3,2]} = "X" ]; then
	echo "XAXACOX 2 WWWwIIIINNNN"; break
elif [ ${matrix[3,1]} = "X" ] && [ ${matrix[3,2]} = "X" ] && [ ${matrix[3,3]} = "X" ]; then
	echo "XAXACOX 2 WWWwIIIINNNN"; break
elif [ ${matrix[1,1]} = "X" ] && [ ${matrix[2,2]} = "X" ] && [ ${matrix[3,3]} = "X" ]; then
	echo "XAXACOX 2 WWWwIIIINNNN"; break
elif [ ${matrix[3,1]} = "X" ] && [ ${matrix[2,2]} = "X" ] && [ ${matrix[1,3]} = "X" ]; then
	echo "XAXACOX 2 WWWwIIIINNNN"; break
fi




	done

echo " GAME OVER "
	;;
	*)
		 echo "SXAL MUTQAGRUM Ade ushadir kardaceq et ander@"
;;
esac





