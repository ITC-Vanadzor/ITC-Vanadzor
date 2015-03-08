#!usr/bin/python

import sys
def args():
	import argparse
	parser = argparse.ArgumentParser()
	parser.add_argument('filename', nargs='?', type=str, help="Json file name")
	parser.add_argument('st', nargs='?',type=str, help='TODO')
	return parser.parse_args()

if __name__ == "__main__":
	argument=args()
	st=argument.st.split('.')
	name=argument.filename
	st1=st[len(st)-1].split(':')
	from js_parse import parser
	js=parser.parse(name)

	if len(st1)==1:
		js=parser.obj_text(js, st)
		if isinstance(js, list):
			print(st[len(st)-1]+" is array, use : for array")
		else:
			print(js)
	elif len(st1)==2:
		js=parser.arr(js, st, st1)
		if isinstance(js, dict):
			print(st1[1]+" is object, use . for object")
		elif isinstance(js, list):
			print(js)
		else:
			print(st1[1]+" is text, use . for txt")
	else:
		print("not valid format")
