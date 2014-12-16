#!/bin/bash
start=`date | cut -d ' ' -f 4`
ls > /home/vahan/Desktop/"$start"

crontab -l > my_cron
echo "05 * * * * /home/vahan/Desktop/current_home.sh" >> my_cron
crontab my_cron
rm my_cron
