#!/usr/bin/python

import os
import argparse

def my_parse_args():
	parser = argparse.ArgumentParser()
	parser.add_argument('path', help="TODO")
	return parser.parse_args()	

def my_parse_args1():
	parser = argparse.ArgumentParser()
	parser.add_argument('-p', required=True, action='store_true', help="TODO")
	return parser.parse_args()

def create_dir_rec(poxos):

	parent = os.path.abspath(os.path.join(poxos, os.pardir))
	my_list = []
	my_list.append(parent)
	while(not os.path.exists(parent)):
		karen = os.path.abspath(os.path.join(parent, os.pardir))
		my_list.append(parent)

	my_list.pop()
	my_list.reverse()

	for item in my_list:
		my_mkdir(item)

def my_mkdir(poxos):
	parent = os.path.abspath(os.path.join(poxos, os.pardir))
	if not os.path.exists(parent):
		return False
	try:
		os.mkdir(poxos)
	except OSError, e:
		print str(e)
	return True


if "__main__" == __name__:
	args = my_parse_args()
	is_created = my_mkdir(args.path)
	if not is_created and args.p:
		create_dir_rec(args.path)
	elif not is_created and not args.p:
		my_parse_args1()
