#!/bin/bash

# Author: Gor
# This script created new file and print all process into file 
# name: current date \Year-Month-Day.Hour.Minute.Second\
# ls..: paste all process into file

cd ~
name=`date +%Y-%m-%d.%H:%M:%S`
ls -la > "${name}"
script_src=`readlink -e "$0"`
cron_command="* 01 * * * "${script_src}""
crontab -l > ~/if.txt
cron=`grep -rc "${cron_command}" ~/if.txt`

if [ ${cron} == 0 ]
    then
	crontab -l > cron    # create crontab 
	echo "${cron_command}" >> cron	# past new cron	
	crontab cron	# install new cron into crontab
	rm -r cron    # delete installed cron
	echo "The script is succesfully installed"
	echo "THANKS GOOD JOB"
	rm -rf ~/if.txt
    else
	echo "This script allready instaled"
	exit
fi
