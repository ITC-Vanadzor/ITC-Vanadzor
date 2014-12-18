#!/bin/bash

{qanak}=`wc -l < /var/log/auth.log`
if [ $qanak =! $qanak+1 ];
    then echo kpel en >> file_name
fi
