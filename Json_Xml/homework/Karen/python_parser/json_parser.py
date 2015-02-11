import argparse
import json

class jsonParser:
	def __init__(self, element_tree):
		self.element_tree = element_tree
		self.data = json.loads(open("data/data.json").read())

	def getArrayTree(self):
		return self.element_tree.split('.')

	def findElement(self,arrayTree):
		treeStr = ""
		key = False
		for element in arrayTree:
			flag = False			
			if ":" in element:
				pos = element.index(":")
				key = int(element[pos+1:])
				element = element[:pos]
			for tag, value in self.data.items():
				if element == tag:
					self.data = value
					flag = True
					treeStr += "." + tag
					break
			if flag is not True:
				return [False,treeStr[1:],element,key]
		return [True,treeStr[1:],value,key]

	def errorNotExist(self,obj,element):
		print "Error:In object '" + obj +"' '"+ str(element) + "' is not exist!"

	def printResult(self,result):
		flag			 = result[0]
		inputedKey	 	 = result[1]
		expectedValue	 = result[2]
		arrayKey 		 = result[3]
		try:
			if flag:
				if arrayKey != False:
					if isinstance(expectedValue,list):
						listResult = expectedValue 
						if str(listResult[arrayKey]) != "":
							expectedValue = listResult[arrayKey]
							inputedKey = inputedKey + ":" + str(arrayKey)
					else:
						print "Error:'" + inputedKey + "' is not Array!"
						return False
				print "You input '" + inputedKey + "'. See result below:"
				print json.dumps(expectedValue,indent=3)
				return True						
			else:
				self.errorNotExist(inputedKey,inputedKey)
		except IndexError:
			self.errorNotExist(inputedKey,arrayKey)

if __name__ == "__main__":
	parser = argparse.ArgumentParser(description = "Parse json file")
	parser.add_argument('-t','--tree',help="Set tree",required=True, dest="element_tree")
	args = parser.parse_args()
	try:
		obj = jsonParser(args.element_tree)
		arrayTree = obj.getArrayTree()
		result = obj.findElement(arrayTree)
		obj.printResult(result)
	except TypeError,e:
		print 'FunctionArgumentError:',e
	except NameError,e:
		print "InvalidVariableError:",e
	except ValueError,e:
		print "KeyError:",e,"should be integer!"