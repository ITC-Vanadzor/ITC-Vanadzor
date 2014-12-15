#usr/bin/python

import os
import unittest
import xmlparser
 
class TestxmlNegativ(unittest.TestCase):
  
    @classmethod
    def setUpClass(self):
        self._xml_parser=xmlparser.XmlParser()

    def test_1(self):
        path='xmlparser.py'
        self.assertTrue(os.path.exists(path), 'TODO')
        self.assertFalse(self._xml_parser.parse(path), 'TODO')

    def test_2(self):
        self.assertFalse(self._xml_parser.parser.parse(None), 'TODO')

    def test_3(self):
        path='/home'
        self.assertFalse(self._xml_parser.parse(path), 'TODO')

    def test_4(self):
        self.assertEqual(self._xml_parser.get_element_count(), 0, 'TODO')

    def test_5(self):
        self.assertFalse(self._xml_parser.is_xml(12), 'TODO')

    def test_6(self):
        self.assertFalse(self._xml_parser.is_xml('<a> '), 'TODO')

    def test_7(self):
        self.assertFalse(self._xml_parser.is_xml(['a', 'b', 'c']), 'TODO')
    
    def test_8(self):
        self.assertFalse(self._xml_parser.is_xml({1: 'a', 2: 'b', 3: 'c'}), 
            'TODO')
    def test_9(self):
        string=''
        self.assertFalse(self._xml_parser.is_xml(string), 'TODO')
    
    def test_10(self):
        string= 'xmlparser.py'
        self.assertFalse(os.path.isfile(string, 'TODO')
        self.assertFalse(self._xml_parser.is_xml(string), 'TODO')

    def test_11(self):
        string= '/home'
        self.assertFalse(os.path.isdir(string), 'TODO')
        self.assertFalse(self._xml_parser.is_xml(string), 'Input string')
    
    def test_13(self):
        self.assertEqual(self._xml_parser.get_xml_structure(), 'TODO')

if __name__='__main__':
    unittest.main()
