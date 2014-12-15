#!/usr/bin/python

import unittest
import xmlparser

class NegativeTestXmlParser(unittest.TestCase):

	@classmethod
	def setUpClass(self):
		self.xml_parser = xmlparser.XmlParser()

	#False paramerters(None) for function parse()
	def test_1_xml_parser(self):
		self.assertTrue(not self.xml_parser.parse(), 'Set 1 argument for function parse()')

	#False paramerters(None) for function is_xml()
	def test_2_xml_parser(self):
		self.assertTrue(not self.xml_parser.is_xml(), 'Set 1 argument for function is_xml()')

	#Invalid file name for function parse()
	def test_3_xml_parser(self):
		self.assertTrue(not self.xml_parser.parse('invalid_file_name'), 'File not found.')
	
	#False count for function args.
	def test_4_xml_parser(self):
		self.assertTrue(self.xml_parser.parse('file_path','extra_arg'), 'Wrong arguments count!!!') 
	
	#False count for function args.
	def test_5_xml_parser(self):
		self.assertTrue(self.xml_parser.is_xml('string','extra_arg'), 'Wrong arguments count!!!') 
	
	#False count for function args.
	def test_6_xml_parser(self):
		self.assertTrue(not self.xml_parser.get_element_count('extra_arg'), 'Wrong arguments count!!!')
	
	#False count for function args.
	def test_7_xml_parser(self):
		self.assertTrue(not self.xml_parser.get_xml_structure('extra_arg'), 'Wrong arguments count!!!')

	#Invalid argument name for function parse()
	def test_8_xml_parser(self):
		self.assertTrue(not self.xml_parser.is_xml(stack = [3, 4, 5]), 'Set str argument for function is_xml()')
