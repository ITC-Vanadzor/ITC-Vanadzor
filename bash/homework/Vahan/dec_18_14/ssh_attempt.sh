#!/bin/bash

if [  $(find /var/log/auth.log -cmin 1)  ]
   then 
         echo "attempt to ssh failed" >> log_file
fi
