#!/usr/bin/python

import os
import argparse

parser = argparse.ArgumentParser()
parser.add_argument(‘-p’, help=”TODO”)
parser.add_argument(‘path’, help=”TODO”)

my_args = parser.parse_args()


#if path and args.p:
#    try:
#        makedirs(path)
#    except Exception:
#        print ‘error’
#        if path:
#            mkdir(path, 0755)
