import unittest
import xml_parser as xml_parser

class testXmlParser(unittest.TestCase):

	def testParser(self):
		parser = xml_parser.xmlParser("Karen")
		result = parser.printArgs()
		self.assertEqual(result,"Karen")

if __name__ == "__main__":
	unittest.main()