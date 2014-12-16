#!/bin/bash

echo "Set path where you want to make your files"; read dir_path
#write out current crontab
crontab -l > mycron

#Full path and file name
mypath=`pwd`"/"`basename $0`
is_set_corn=`grep -i $mypath mycron`

#echo new cron into cron file
echo "* 1 * * * "$mypath >> mycron

if [ -z "$is_set_corn" ];
	then
		#install new cron file
		crontab mycron
fi

rm mycron

ls -l ~/ > dir_path"`date`"
