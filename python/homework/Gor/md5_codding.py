'''
Name: MD5 codding script
Author : Gor J.
Created: 4.12.2014
'''

#!/usr/bin/python
# -*- coding: utf-8 -*-

import hashlib
import colorsys

yc = raw_input("Please insert your code here..: ");

def md5hash():

  m = hashlib.md5()
  m.update(yc)
  return m.hexdigest()
print
print('\033[31m' + '------------------------ GENERETIN WITH MD5 HASH ----------------------')
print '\033[34mYOUR CODE IS > "{}"\033[1;m'.format(yc)
print '\033[32mNOW LOOK YOUR CODE IN MD5 HASH  >  "{}"\033[1;m'.format(md5hash())
print('\033[31m' + '--------------------------- THANKS! GOOD JOB --------------------------')
print('\033[0m')





        
   
