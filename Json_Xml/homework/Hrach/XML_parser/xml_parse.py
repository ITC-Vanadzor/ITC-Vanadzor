#!usr/bin/python

import sys
class parser():
	
	@classmethod
	def pars(self, file_name):
		from xml.dom.minidom import parse
		return parse(file_name)

	@classmethod
	def indexation(self, st, st1, index):
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

	@classmethod
	def text(self, xml, arr, index):
		for i in range(len(arr)):
			try:
				xml = xml.getElementsByTagName(arr[i])[int(index[i])]
			except IndexError:
				sys.exit(arr[i]+"["+str(index[i])+"]"+" not valid")
			except ValueError:
				sys.exit(str(index[i])+" not valid format")
		try:
			xml = xml.childNodes[0].nodeValue
		except IndexError:
			sys.exit(arr[len(st)-1]+"["+index[len(st)-1]+"]"+" is empty")
		return xml

	@classmethod
	def atribut(self, xml, arr1, arr2, index):
		for j in range(len(arr1)-1):
			try:
				xml = xml.getElementsByTagName(arr1[j])[int(index[j])]
			except IndexError:
				sys.exit(arr1[j]+"["+str(index[j])+"]"+" not valid")
			except ValueError:
				sys.exit(str(index[j])+" not valid format")
		try:
			xml = xml.getElementsByTagName(arr2[0])[int(index[len(arr1)-1])]
		except IndexError:
			sys.exit(arr2[1]+"["+str(index[len(arr1)-1])+"]"+" not valid")
		except ValueError:
			sys.exit(str(index[len(arr1)-1])+" not valid format")
		return xml.getAttribute(arr2[1])

