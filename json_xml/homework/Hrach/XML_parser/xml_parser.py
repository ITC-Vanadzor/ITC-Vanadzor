#!usr/bin/python

import sys
def args():
	import argparse
	parser = argparse.ArgumentParser()
	parser.add_argument('filename', nargs='?', type=str, help="Xml file name")
	parser.add_argument('st', nargs='?',type=str, help='TODO')
	return parser.parse_args()

if __name__ == "__main__":
	args()
	argument = args()
	st = argument.st.split('.')
	name=argument.filename
	st1 = st[len(st)-1].split(':')
	index = []
	from xml_parse import parser
	try:
		xml=parser.pars(name)
	except IOError:
		sys.exit("not valid file")
	except xml.parsers.expat.ExpatError:
		sys.exit("file is not xml")
	parser.indexation(st, st1, index)

	if len(st1)==1:
		xml=parser.text(xml, st, index)
		if xml==None:
			print(st[len(st)-1]+"["+str(index[len(st)-1])+"]"+" is object")
		else:
			print(xml)
	elif len(st1)==2:
		xml=parser.atribut(xml, st, st1, index)
		print(xml)
	else:
		print("not valid format")
