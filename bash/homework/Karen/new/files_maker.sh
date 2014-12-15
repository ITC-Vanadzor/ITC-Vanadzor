#!/bin/bash

#directory path
if [ ! -d "$1" ]; then
	mkdir $1
fi

#count files $2
#type file $3
COUNTER=0
while [  $COUNTER -lt $2 ]; do
	touch ${1}/file_${COUNTER}.${3}
	let COUNTER++ 
done
