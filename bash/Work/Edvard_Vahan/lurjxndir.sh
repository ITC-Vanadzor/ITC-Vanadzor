#!/bin/bash
echo "please insert first variable"; read a
echo "please insert second variable"; read b
av_sum=$[(a+b)/2]
#echo $av_sum

scp $0 student@192.168.33.51:~/Desktop/  
ssh student@192.168.33.51 'bash ~/Desktop/lurjxndir.sh > ~/Desktop/result.txt'
