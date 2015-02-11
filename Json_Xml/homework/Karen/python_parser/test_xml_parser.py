import unittest
import xml_parser as xml_parser

class testXmlParserPositive(unittest.TestCase):

	@classmethod
	def setUpClass(self):
		self.parser = xml_parser.xmlParser("a.b.c")		

	def testParser(self):
		result = self.parser.getArrayTree()
		self.assertEqual(result,["a","b","c"])

	def testElement(self):
		result = self.parser.findElement(["glossary"])
		self.assertEqual(result, [True,"glossary",self.parser.root,False]) 

	def testPrint1(self):
		result = self.parser.printResult([True,"glossary",self.parser.root,False])
		self.assertTrue(result)

	def testPrint2(self):
		testObj = xml_parser.xmlParser("glossary.title")
		testArr = testObj.getArrayTree()
		result = testObj.findElement(testArr)
		self.assertTrue(testObj.printResult(result))

	def testPrint3(self):
		testObj = xml_parser.xmlParser("glossary.GlossDiv.GlossList.GlossEntry:ID")
		testArr = testObj.getArrayTree()
		result = testObj.findElement(testArr)
		self.assertTrue(testObj.printResult(result))

class testXmlParserNegative(unittest.TestCase):

	def testPrint1(self):
		testObj = xml_parser.xmlParser("invalid.value")
		testArr = testObj.getArrayTree()
		result = testObj.findElement(testArr)
		self.assertFalse(testObj.printResult(result))

if __name__ == "__main__":
	unittest.main()