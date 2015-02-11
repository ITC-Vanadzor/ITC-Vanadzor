import argparse
import xml.etree.ElementTree as ET

class xmlParser:
	def __init__(self, element_tree):
		self.element_tree = element_tree
		self.tree = ET.parse('data/xml.xml')
		self.root = self.tree.getroot()

	def getArrayTree(self):
		arrayTree = self.element_tree.split('.')
		return arrayTree

	def printArgs(self):		
		aaa = self.getArrayTree()
		self.isExistTree()
		return self.element_tree

	def isExistTree(self):
		arrayTree = self.getArrayTree()
		mytree = ""
		
		for element in arrayTree:
			for e in self.root.iter(element):
				if e.tag is not None:
					mytree += "."+e.tag
					print e.tag+"------------exist"
					#self.root = self.tree._setroot(element)
				else:
					print "------NOT------exist"
		print "Tree = "+mytree

	def testParser(self):
		tree = ET.parse('data/xml.xml')
		root = tree.getroot()
		#for tags in root.findall('glossary'):
		#	title = tags.find('title')
		#	print title
		#print childs
		for child in root:
			print child.tag, child.attrib
			root = tree._setroot(child)
			break
		for child in root:
			print child.tag, child.attrib
		#get  attribute
		#for GlossEntry in root.iter('GlossEntry'):
		#	print GlossEntry.attrib
		#get  value
		#for element in root.iter(self.element_tree):
		#	print element.attrib

if __name__ == "__main__":
	parser = argparse.ArgumentParser(description = "Parse xml,json file")
	parser.add_argument('-t','--tree',help="Set tree", dest="element_tree")
	args = parser.parse_args()

	obj = xmlParser(args.element_tree)
	obj.printArgs()
	obj.testParser()
