import argparse
import xml.etree.ElementTree as ET

class Parser:
	def __init__(self,tag_name):
		self.tag_name=tag_name
		self.tree = ET.parse('xml.xml')
		self.root = self.tree.getroot()
	def Xml_Parser(self):
		if self.tag_name!="":
			xml_tag=self.tag_name.split(".")
			return xml_tag
	def aa(self):
		xml_tag_arr=self.Xml_Parser()
		try:
			length=len(xml_tag_arr)
		except TypeError:
			print "Input tags names"
			return None
		c=xml_tag_arr[length-1]
		k=c.split(":")
		xml_tag_arr[length-1]=k[0]
		cc=""
		jj=0
		for elem in xml_tag_arr: 
			for el in self.root.iter(elem):
				cc=cc+"."+el.tag
				if cc.startswith("."+self.tag_name):
					if jj==length:
						print el.text
						continue
				jj=jj+1
					
if __name__ == "__main__":
	tag_name=raw_input("Input what you need: ")
	obj_parser = Parser(tag_name)
	obj_parser.aa()
