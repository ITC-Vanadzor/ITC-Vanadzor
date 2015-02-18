import unittest
import json_parser as json_parser

class testJsonParserPositive(unittest.TestCase):

	@classmethod
	def setUpClass(self):
		self.parser = json_parser.jsonParser("a.b.c")		
	
	def testParser(self):
		result = self.parser.getArrayTree()
		self.assertEqual(result,["a","b","c"])

	def testElement(self):
		testObj = json_parser.jsonParser("glossary.title")
		testArr = testObj.getArrayTree()
		result = testObj.findElement(testArr)
		self.assertTrue(testObj.printResult(result))

	def testElementList(self):
		testObj = json_parser.jsonParser("glossary.GlossDiv.GlossList.GlossEntry.GlossDef.GlossSeeAlso:1")
		testArr = testObj.getArrayTree()
		result = testObj.findElement(testArr)
		self.assertTrue(testObj.printResult(result))
	
class testJsonParserNegative(unittest.TestCase):

	def testPrint1(self):
		testObj = json_parser.jsonParser("invalid.value")
		testArr = testObj.getArrayTree()
		result = testObj.findElement(testArr)
		self.assertFalse(testObj.printResult(result))

if __name__ == "__main__":
	unittest.main()