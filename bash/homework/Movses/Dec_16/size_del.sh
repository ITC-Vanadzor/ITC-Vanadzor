#!/bin/bash

for file in `ls`;
    do
{payman} = $(ls -l $file | awk '{print $5}')
echo $payman
{stugum} = $payman -gt 1000  
echo $stugum    
        if $stugum
            then rm -i $file
        fi
    done 

