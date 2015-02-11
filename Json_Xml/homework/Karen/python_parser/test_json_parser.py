import unittest
import json_parser as json_parser

class testJsonParser(unittest.TestCase):

	def testValue(self):
		parser = json_parser.jsonParser("tree")
		printArgs = [True,"test.tree","test value",False]
		result = parser.printResult(printArgs)
		self.assertEqual(result,"test value")

	def testValueArray(self):
		parser = json_parser.jsonParser("tree")
		testValue = ['a','b','c']
		printArgs = [True,"test.tree",testValue,1]
		result = parser.printResult(printArgs)
		self.assertEqual(result,"b")

if __name__ == "__main__":
	unittest.main()