#!/bin/bash

# Author: Gor
# script_src: script absolute path
# total: total amount of script absolute path in sshrc
# date: current date
# content(): file & mail content

script_src=`readlink -e "$0"` 	
total=`grep -rc "${script_src}" /etc/ssh/sshrc`	
date=`date +%Y-%m-%d.%H:%M:%S`		

content(){
    echo "---- SECURITTY WARNING!!! ----"
    echo "SSH Connection Established with user" "*""${USER}""*"
    echo "Conection time:" "${date}"
}

if [ ${total} == 0 ]
    then
	sudo sh -c "echo "$script_src" >> /etc/ssh/sshrc" 
	echo "The script is succesfully installed"
	echo "THANKS GOOD JOB"
	content > ~/Desktop/SSH_WARNING.txt
	content | /usr/sbin/sendmail gorjulhakyan90@gmail.com
    else
	echo "This script alrady installed"
	exit
fi
