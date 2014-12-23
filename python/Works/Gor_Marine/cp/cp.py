#!/usr/bin/python

"""
Title:Copy Programm
Desc: This programm for copy files and directoryes
Author: Marine & Gor
Creating date: 08.12.2014
Last Modifed Date: 10.12.2014
Version: 1.3
Relise:1.3

"""




import os
import argparse
import shutil
import errno

def flags():
    parser = argparse.ArgumentParser(description = 'Copy Programm')
    parser.add_argument('path', help='File or Directory to copy')
    parser.add_argument('path1', help='New File or Directory')
    parser.add_argument('-r', action='store_true', dest = 'recursive', help = 'copy rec')
    return parser.parse_args()
  
def copy_r(path, path1, rec):
    if not check_path(path):
        print 'No such file or directory'
        return False

    try:        
        if recursive:
            shutil.copytree(path, path1)
        elif not os.path.isdir(path):
            shutil.copy(path, path1)
        else:
            print "bls bls"
            return False
        return True        
    except OSError, e:
        print "something went wrong, Error is",str(e) 
    except IOError, e:
        print "bla", str(e)
    return False

def check_path(path):
    return os.path.exists(path)

if '__main__' == __name__:
    args = flags()
    path = args.path
    path1 = args.path1
    recursive = args.recursive
    copy_r(path, path1, recursive)

