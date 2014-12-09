#!/bin/bash
killllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll () 
{
    if [ `ps -All | grep firefox | wc -l` -eq 0 ];
    then
        echo "no firefox running..."
    else
        user_id=`whoami`
        ps -eo pid,comm,user | grep firefox | grep $user_id > file_name
        pid=`sed 's/[a-z]//g' file_name`
        kill -9 $pid
        
    fi
}
killllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll
