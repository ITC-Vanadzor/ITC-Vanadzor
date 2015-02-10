#!usr/bin/python

import sys
from xml.dom.minidom import *
xml = parse('xml.xml')
import argparse
parser = argparse.ArgumentParser()
parser.add_argument('st', nargs='?',type=str, help='TODO')
parser.parse_args()
argument = parser.parse_args()
st = argument.st
st = st.split('.')
st1 = st[len(st)-1].split(':')
index = []

for x in range(len(st)-1):
	res = st[x].split("[")
	if len(res)==1:
		index.append(0)
	elif len(res)==2:
		st[x] = res[0]
		resn = res[1].split("]")
		if len(resn)==2 and resn[1]=="":
			index.append(resn[0])
		else:
			sys.exit("["+res[1]+" not valid format")
	else:
		sys.exit("incorrect number of \"[\" in "+x+" argument")

res = st1[0].split("[")
if len(res)==1:
	index.append(0)
elif len(res)==2:
	if len(st1)==1:
		st[len(st)-1] = res[0]
	else:
		st1[0] = res[0]
	resn = res[1].split("]")
	if len(resn)==2 and resn[1]=="":
		index.append(resn[0])
	else:
		sys.exit("["+res[1]+" not valid format")
else:
	sys.exit("incorrect number of \"[\" in "+str(len(st))+" argument")

if len(st1)==1:
	for i in range(len(st)):
		try:
			xml = xml.getElementsByTagName(st[i])[int(index[i])]
		except IndexError:
			sys.exit(st[i]+"["+str(index[i])+"]"+" not valid")
		except ValueError:
			sys.exit(str(index[i])+" not valid format")
	try:
		xml = xml.childNodes[0].nodeValue
	except IndexError:
		sys.exit(st[len(st)-1]+"["+index[len(st)-1]+"]"+" is empty")
	if xml==None:
		print(st[len(st)-1]+"["+str(index[len(st)-1])+"]"+" is object")
	else:
		print(xml)
elif len(st1)==2:
	for j in range(len(st)-1):
		try:
			xml = xml.getElementsByTagName(st[j])[int(index[j])]
		except IndexError:
			sys.exit(st[j]+"["+str(index[j])+"]"+" not valid")
		except ValueError:
			sys.exit(str(index[j])+" not valid format")
	try:
		xml = xml.getElementsByTagName(st1[0])[int(index[len(st)-1])]
	except IndexError:
		sys.exit(st1[1]+"["+str(index[len(st)-1])+"]"+" not valid")
	except ValueError:
		sys.exit(str(index[len(st)-1])+" not valid format")
	print(xml.getAttribute(st1[1]))
else:
	print("not valid format")
