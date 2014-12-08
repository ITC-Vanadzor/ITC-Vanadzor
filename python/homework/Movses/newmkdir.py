#!/usr/bin/python

import os
import argparse

parser = argparse.ArgumentParser()
parser.add_argument('-p',help="TODO")
parser.add_argument('path',help="TODO")
args = parser.parse_args()
path = args.path

if path and args.p:
    try:
        os.makedirs(path)
    except Exception:
        print 'error' 

if path:
    os.mkdir(path, 0755)





