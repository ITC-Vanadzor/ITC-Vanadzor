#!/usr/bin/python

import os

path = '/home/employee/Desktop/ITC'
file = 'abc'
if not os.path.exists(path):  
    os.mkdir(path)
udir = ['Marine', 'Gor']
for i in udir:
    if not os.path.exists(path + '/' + i):  
        os.mkdir(path + '/' + i )
        path1=(path + '/' + i)
        print "path1 = ", path1
        os.chdir(path1)
        open(i, 'w+')
