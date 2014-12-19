#!/bin/bash

if [ ! -f ~/Desktop/connections ];then
	touch ~/Desktop/connections
fi

result=`sudo netstat -tnpa | grep ESTABLISHED.*sshd`
if [ -n "$result" ];then
	echo $result >> ~/Desktop/connections
else 
	echo "No NEW connection"
fi

#connection_exist=`grep -i $result ~/Desktop/connections`
#if [[ $connection_exist == *"$result"* ]]
#then
#	echo $connection_exist
#fi
