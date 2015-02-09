import unittest
import python_parser as python_parser

class testXmlParser(unittest.TestCase):

	def testParser(self):
		parser = python_parser.xmlParser("Karen")
		result = parser.printArgs()
		self.assertEqual(result,"Karen")

if __name__ == "__main__":
	unittest.main()