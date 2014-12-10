#!/usr/bin/python

"""
Name: Copy Programm
Version: 1.0
Relise: 1.2
Author: Gor
Creating Date: 09.12.2014
Desc: This programm wil copy files and directories
@-r '-r' flag for recursive copy files & directories
@file_copy() function will copy files & directories
@to_path_file new copy file
"""

import os
import argparse
import shutil
import errno

def copy_parse_args():
    parser = argparse.ArgumentParser()
    parser.add_argument('path_file', help="Copy file or directory")
    parser.add_argument('to_path_file', help="New file or directory")
    parser.add_argument('-r', '--recursive_copy', action='store_true', help="For Recursive copy")
    return parser.parse_args()

def file_copy():
    if recursive_copy:
	try:
	    shutil.copytree(path_file, to_path_file)
	    return True
	except OSError:
	    print "   No such file or directory: '{}'".format(path_file)
    else:
	try:
	    shutil.copy(path_file, to_path_file)
	    return True
	except IOError:
            print "    ERROR: For Recursive copy, please paste '-r' flag"

if '__main__' == __name__:
    args = copy_parse_args()
    path_file = args.path_file
    to_path_file = args.to_path_file
    recursive_copy = args.recursive_copy
    file_copy()
