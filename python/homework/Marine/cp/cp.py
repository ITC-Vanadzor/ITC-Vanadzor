#!/usr/bin/python

import os
import argparse
import shutil
import errno

def flags():
    parser = argparse.ArgumentParser(description = 'copy')
    parser.add_argument('path', help = 'copy')
    parser.add_argument('path1', help = 'copy')
    parser.add_argument('-r', action = 'store_true', dest = 'rec', help = 'copy rec')
    args = parser.parse_args()
    return parser.parse.args
  
def copy_r(file_name, copy_file_name, recursive = false):
    if recursive:
        try:        
            shutil.copytree(file_name, copy_file_name)
            return true
        except OSError, e:
            print "something went wrong, Error is",str(e) 
    else:
        try:
            shutil.copy(file_name, copy_file_name)
            return true        
        except OSError, e:
            print "something went wrong, Error is",str(e)     


if __name__=='__main__':
    args = flags()
    file_path=args.path
    copy_file_path=args.path1
    recursive=args.rec
    copy_r(file_path, copy_file_path1, recursive)







