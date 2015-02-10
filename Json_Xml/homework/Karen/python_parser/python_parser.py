import argparse
import xml.etree.ElementTree as ET

class xmlParser:
	def __init__(self, element_tree):
		self.element_tree = element_tree

	def printArgs(self):		
		array = self.element_tree.split('.')
		print len(array)
		return self.element_tree

	def testParser(self):
		tree = ET.parse('data/xml.xml')
		root = tree.getroot()
		#for tags in root.findall('glossary'):
		#	title = tags.find('title')
		#	print title
		#print childs
		#for child in root:
		#	print child.tag, child.attrib
		#get  attribute
		#for GlossEntry in root.iter('GlossEntry'):
		#	print GlossEntry.attrib
		#get  value
		for para in root.iter('para'):
			print para.text

if __name__ == "__main__":
	parser = argparse.ArgumentParser(description = "Parse xml,json file")
	parser.add_argument('-t','--tree',help="Set tree", dest="element_tree")
	args = parser.parse_args()

	obj = xmlParser(args.element_tree)
	obj.printArgs()
	obj.testParser()
