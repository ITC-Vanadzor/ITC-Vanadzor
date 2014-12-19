#!/bin/bash
#this script runs every hour and inform you who has succecfully connected 
#to your machine using ssh. we also can get an email with such noticitacion,
#but there can be  problems while sending email. Your email can be banned by
#provider.Need to be properly configured. 
grep sshd. /var/log/auth.log > temp_file
cat temp_file
#subject=`date | cut -d ' ' -f 4`
#mail -s $subject sargiskocharyan@yahoo.com < temp_file

crontab -l > temp_file_cron
echo "1 * * * * ~/Desktop/ssh_note.sh" >> temp_file_cron
crontab temp_file_cron
rm temp_file_cron temp_file
