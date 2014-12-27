#!/bin/bash

if [ $# != 3 ]
then
	echo "write 3 arguments"
	exit 0
fi

int='^[0-9]+$'
if ! [[ $1 =~ $int ]]
then
	echo "The first argument must be integer"
	exit 0
elif [ $2 != "+" ] && [ $2 != "-" ] && [ $2 != "x" ] && [ $2 != "/" ]
then
	echo "The second argument must be + or - or x or /"
	exit 0
elif ! [[ $3 =~ $int ]]
then
    echo "The third argument must be integer"
	exit 0
fi

if [ $2 = "+" ]
then
	echo $(($1+$3))
elif [ $2 = "-" ]
then
	echo $(($1-$3))
elif [ $2 = "x" ]
then
	echo $(($1*$3))
elif [ $2 = "/" ]
then
 	echo $(($1/$3))
fi
