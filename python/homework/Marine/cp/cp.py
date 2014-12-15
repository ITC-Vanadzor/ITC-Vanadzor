#!/usr/bin/python

import os
import argparse
import shutil
import errno

def flags():
    parser = argparse.ArgumentParser(description = 'copy')
    parser.add_argument('path', help='copy')
    parser.add_argument('path1', help='copy')
    parser.add_argument('-r', action='store_true', dest = 'rec', help = 'copy rec')
    return parser.parse_args()
  
def copy_r(path, path1, rec):
    if not check_path(path):
        print 'No such file or directory'
        return False

    try:        
        if rec:
            shutil.copytree(path, path1)
        elif not os.path.isdir(path):
            shutil.copy(path, path1)
        else:
            print "Input correct format"
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
    rec = args.rec
    copy_r(path, path1, rec)

