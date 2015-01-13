#usr/bin/python

import unittest
import xmlparser
import os

class NegativeTestCase(unittest.TestCase)

    def SetUp(self):
       self.xml=xmlparser.Xmlparser()

    def test1(self):
        path='/home'
        self=assertFalse(self.xml.parse(path), "Todo")

    def test2(self):
        path='./orinak'
        self.assertFalse(self.xml.parse(path), "Todo")

    def test3(self):
        self.assertFalse(self.xml.parser.parse(None), "Todo")

    def test4(self):
         self.assertFalse(self.xml.is_xml(12), 'Todo')

    def test5(self):
        self.assertFalse(self.xml.is_xml('<a> '), 'Todo')
        
    def test6(self):
        self.assertFalse(self.xml.is_xml(['a', 'b', 'c']), 'Todo')
                                     
    def test7(self):
        self.assertFalse(self.xml.is_xml({1: 'a', 2: 'b', 3: 'c'}), 'Todo')

    def test8(self):
        string=''
        self.assertFalse(self.xml.is_xml(string), 'Todo')

    def test10(self):
        self.assertEqual(self.xml.get_element_count(), 0, Todo)

    def test11(self):
        self.assertNotEqual(self.xml.get_element_count(), 2.5, 'Todo')

    def test12(self):
        self.assertNotEqual(self.get_element_count(), [1,2], 'Todo')


    def test13(self):
        string='<a><b></b><c></c></a>'
        self.assertNotEqual(self.xml.get_xml_structure(), string, 'Todo')

    def test14(self):
        self.assertNotEqual(self.xml.get_xml_structure(), None, 'Todo')

    def test15(self):
        self.assertNotIsInstance(self.xml.get_xml_structure(), int, 'Todo')

    def test16(self):
        self.assertNotIsInstance(self.xml.get_xml_structure(), dict, 'Todo')

    def test17(self):
        self.assertNotIsInstance(self.xml.get_xml_structure(), list, 'Todo')

    def test18(self):
        self.assertNotIsInstance(self.xml.get_xml_structure(), tuple, 'Todo')

    def test19(self):
        self.assertNotIsInstance(self.xml.get_xml_structure(), float, 'Todo')
     
if __name__='__main__':
    unittest.main()  
