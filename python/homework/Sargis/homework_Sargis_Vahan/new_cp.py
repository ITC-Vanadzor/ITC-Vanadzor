#!/usr/bin/python

import os 
import argparse
import shutil

def my_parse_args():
    parser = argparse.ArgumentParser()
    parser.add_argument("source", help = "intup source path, that will be copied ")
    parser.add_argument("target", help = "input target file path")
    parser.add_argument('-r', action = "store_true",
                         help = "copy file recursively")
    return parser.parse_args()

def has_parent(target):
    return os.path.exists(os.path.abspath(os.path.join(target, os.pardir)))
    
def my_cp_dir(source, target):
    try:
        shutil.copytree(source, target)
        return True
    except OSError, e:
        print "something went wrong, Error is",str(e) 

def my_cp_f(source, target):
    try:
        shutil.copyfile(source, target)
        return True
    except OSError, e:          
        print "something went wrong, Error is",str(e) 

if "__main__" == __name__:
    args = my_parse_args()
    print args
    if os.path.exists(args.source) and has_parent(args.target):          
        if os.path.isdir(args.source) and args.r:
            my_cp_dir(args.source, args.target)
        else:
            my_cp_f(args.source, args.target)
       
