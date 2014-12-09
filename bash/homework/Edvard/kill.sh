#!/bin/bash
echo -n "Please input ID:"
read a
echo -n "What to do?"
read b

if [ "$b" == "kill" ]; then
    kill "$a"
else
    echo "I'm sorry I can't help YOU"
fi





