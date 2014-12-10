#!/usr/bin/python
'''
this program gets arguments from command line: @path positional argument to pass path of the folder, that will be created
 @-p optional argument, will allow us create folders recursively
 @my_mkdir()  function checks if there already exists such folder and if not, creates it

'''
import argparse
import os

parser = argparse.ArgumentParser()
parser.add_argument("path", help ="input the path of folder, to be created")
parser.add_argument("-p", action = "store_true", required = False, 
                      help ="make directory recursively")
args = parser.parse_args()

def my_mkdir():
    if args.path and args.p:
        os.makedirs(args.path)
    elif args.path and not args.p:
        os.mkdir(args.path, 0755)
    else:
        print "no path to create"
my_mkdir()
