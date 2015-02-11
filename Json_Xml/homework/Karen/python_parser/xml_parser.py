import argparse
import xml.etree.ElementTree as ET

class xmlParser:
	def __init__(self, element_tree):
		self.element_tree = element_tree
		self.tree = ET.parse('data/data.xml')
		self.root = self.tree.getroot()

	def getArrayTree(self):
		arrayTree = self.element_tree.split('.')
		return arrayTree

	def findElement(self,arrayTree):
		if arrayTree[0] == self.root.tag:
			treeStr = arrayTree[0]
		else:
			return [False,"xml",arrayTree[0],False]
		if len(arrayTree) > 1:
			arrayTree.pop(0)
			attr = False
			for element in arrayTree:
				flag = False
				if ":" in element:
					pos = element.index(":")
					attr = element[pos+1:]
					element = element[:pos]
				for child in self.root:
					if element == child.tag:
						self.root = child
						flag = True
						treeStr += "." + child.tag
						break
			if flag is False:
				return [False,treeStr,element,attr]
			return [flag,treeStr,child,attr]		
		else:
			return [True,arrayTree[0],self.root,False]

	def printResult(self,result):
		flag			 = result[0]
		inputedKey	 	 = result[1]
		expectedValue	 = result[2]
		attr 			 = result[3]
		if flag == False:	
			self.errorNotExist(inputedKey,expectedValue)
			return False
		else:
			if attr:
				try:
					inputedKey += ":" + attr
					print "You input '" + inputedKey + "'. See result below:"
					print expectedValue.attrib[attr]
					return True
				except KeyError,e:
					print "AttributeError: in '" + inputedKey + "' " + str(e) + "not exist!"
					return False
			print "You input '" + inputedKey + "'. See result below:"
			ET.dump(expectedValue)
			return True
		
				
	def errorNotExist(self,obj,element):
		print "Error:In object '" + obj + "' '" + str(element) + "' is not exist!"

if __name__ == "__main__":
	parser = argparse.ArgumentParser(description = "Parse xml,json file")
	parser.add_argument('-t','--tree',help="Set tree", dest="element_tree")
	args = parser.parse_args()
	try:
		obj = xmlParser(args.element_tree)
		arrayTree = obj.getArrayTree()
		result = obj.findElement(arrayTree)
		obj.printResult(result)
	except TypeError,e:
		print 'FunctionArgumentError:',e
	except NameError,e:
		print "InvalidVariable:",e	