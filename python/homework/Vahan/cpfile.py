#!/usr/bin/python
import shutil
import argparse

parser = argparse.ArgumentParser(description = 'copy files or directories')
parser.add_argument('path1' , help='the file to be copied')
parser.add_argument('path2', help='destination directory')
parser.add_argument('-r','--recursive', action="store_true", help='copies directories with its folders')


args = parser.parse_args()

def cpp(src, dec):
    shutil.copytree(src, dec)
def cpp_file(src, dec):
    shutil.copyfile(src,dec)
if args.recursive:
    cpp(args.path1, args.path2)
else:
    cpp_file(args.path1, args.path2)
