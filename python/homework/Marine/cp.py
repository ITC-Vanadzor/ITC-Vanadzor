#!/usr/bin/python

import os
import argparse
import shutil
import errno

parser = argparse.ArgumentParser(description='copy')
parser.add_argument('path',help='copy')
parser.add_argument('path1',help='copy')
parser.add_argument('-r',dest='rec',help='copy rec')
args = parser.parse_args()

    
def copy_r(src, des):
    if os.path.isdir(src):
        if args.rec:
            shutil.copytree(src, des)
        else:
            print 'not -r'
    else:
        if not args.rec:   
            shutil.copy(src, des)
        else:
            print args.rec[help]  

copy_r(args.path, args.path1)







