#!/usr/bin/python

import os
import unittest
import xmlparser
 
class negativ_xml_test(unittest.TastCase):
  
    @classmethod
    def setUpClass(self):
       self.xml1=xmlparser.XmlParser()

    def test_1(self):
        path='xmlparser.py'
        self.assertFalse(self.ml1.parse(path), 'File not exists')

    def test_2(self):
        self.assertFalse(not self.xml1.parser.parse(none), 'Input file')

    def test_3(self):
        path='cp.py'
        self.assertFalse(self.xml1.parser.parse(path), 'File not exists')
        self.assertTrue(os.path.exists(path), 'No such file')

    def test_4(self):
        path='/home/marine/Desktop/'
        self.assertFalse(parser.parse(path), 'Input file')
        self.assertTrue(not os.path.isdir(path), 'Not input directory')

    def test_5(self):
        num=int(5)
        self.assertEqual(self.xml1.get_element_count(num), 0, 'Input integer number')

    def test_6(self):
        num='str'
        self.assertEqual(self.xml1.get_element_count(num), 0, 'Input integer number')
        self.assertTrue(num.isdigit(), 'Input integer number')

    def test_7(self):
        self.assertEqual(self.xml1.get_element_count(none), 0, 'Input integer number')

    def test_8(self):
        str1 = '<a> </a>'
        self.assertFalse(self.xml1.is_xml(str1), 'Enter the correct format')

    def test_9(self):
        str1 = int(666)
        self.assertFalse(self.xml1.is_xml(str1), 'Input string')
        self.assertTrue(str1.isalpha(), 'Enter the correct format')

    def test_10(self):
        path='<a> 666'
        self.assertFalse(self.xml1.is_xml(str1), 'Input string')

    def test_11(self):
        str1=''
        self.assertFalse(self.xml1.is_xml(str1), 'Input string')
        self.assertNoEqual(len(str1), 0, 'Input string')
    
    def test_12(self):
        str1 = 'xmlparser.py'
        self.assertFalse(self.xml1.is_xml(str1), 'Input string')
        self.assertFalse(os.path.isdir(str1) or os.path.isfile(str1), 'Intup string')

    def test_13(self):
        str2='abcabc'
        self.assertEqual(self.xml1.get_xml_structure(str2), '<a><b></b><c></c></a>', 'Input text')

    def test_14(self):
        str2=int(123123)
        self.assertEqual(self.xml1.get_xml_structure(str2),  '<a><b></b><c></c></a>', 'Input string')
        self.assertTrue(str2.isalpha(), 'Enter the correct format')
    
    def test_15(self):
        str1 = 'xmlparser.py'
        self.assertFalse(self.xml1.get_xml_structure(str2), 'Input string')
        self.assertFalse(os.path.isdir(str2) or os.path.isfile(str2), 'Intup string')
    
  


















        
