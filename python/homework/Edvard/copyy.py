#!/usr/bin/python
import shutil
import argparse
import os
parser = argparse.ArgumentParser(description = 'Copying file')
parser.add_argument('path1', help='wrong path1 name')
parser.add_argument('path2', help='wrong path2 name')
parser.add_argument('-r', '--recursive', action='store_true', help='Its a directory, please insert -r')

args = parser.parse_args()

def copyy(src, dst):
    shutil.copyfile(src, dst)
def copyyy(src, dst):
    shutil.copytree(src, dst, symlinks=False, ignore=None)
if os.path.isdir(args.path1):
	if args.recursive:
		copyyy(args.path1, args.path2)
	else:
		print 'It is directory, please insert -r'
else:
	copyy(args.path1, args.path2)

