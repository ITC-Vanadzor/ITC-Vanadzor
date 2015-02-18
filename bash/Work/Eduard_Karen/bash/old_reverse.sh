#!/bin/bash

#$1-file name
#$2-reversed file name
text=`cat $1`
cat $1|rev > $2
