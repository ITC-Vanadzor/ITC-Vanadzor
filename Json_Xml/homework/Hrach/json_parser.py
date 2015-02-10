#!usr/bin/python

import sys
import argparse
parser = argparse.ArgumentParser()
parser.add_argument('st', nargs='?',type=str, help='TODO')
argument=parser.parse_args()
st=argument.st
st=st.split('.')
st1=st[len(st)-1].split(':')

import json
jsObj=open("json.json", "r")
js=json.load(jsObj)

if len(st1)==1:
	for i in range(len(st)):
		try:
			js=js[st[i]]
		except KeyError:
			sys.exit(st[i]+" not valid")
	if isinstance(js, list):
		print(st[len(st)-1]+" is array, use : for array")
	else:
		print(js)
elif len(st1)==2:
	for i in range(len(st)-1):
		try:
			js=js[st[i]]
		except KeyError:
			sys.exit(st[i]+" not valid")
	for j in range(2):
		try:
			js=js[st1[j]]
		except KeyError:
			 sys.exit(st1[j]+" not valid")
	if isinstance(js, dict):
		print(st1[1]+" is object, use . for object")
	elif isinstance(js, list):
		print(js)
	else:
		print(st1[1]+" is text, use . for txt")
else:
	print("not valid format")
jsObj.close()
