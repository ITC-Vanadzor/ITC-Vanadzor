#!/usr/bin/python

import unittest
import xmlparser
import os
class Negativetestxmlparser(unittest.TestCase):
    
    def setUp(self):
        self.obj1 = xmlparser.XmlParser()
#check if such file exists 
    def test_1_parse(self):
        fake_path = '/home/sargis/Desktop/fileeee'
        self.assertFalse(self.obj1.parse(fake_path), "nothing to say")
#chek if non xml and  existing file returns false or not
    def test_2_parse(self):
        if os.path.exists('./example'):
            path = './example'
            self.assertFalse(self.obj1.parse(path), "it's xml file")
#check the case when isn't passed any argument
    def test_3_parse(self):
        self.assertFalse(self.obj1.parse(''), "argument is passed")
#check the case when argument isn't valid, for example existing directory
    def test_4_parse(self):
        path = "/home/sargis/Desktop"
        self.assertFalse(self.obj1.parse(path), "non-valid argument passed as valid")

#passing None argument
    def test_5_is_xml(self):
        self.assertFalse(self.obj1.is_xml(None), "None argument  passed as real !!!")
#passing boolean argument
    def test_6_is_xml(self):
        self.assertFalse(self.obj1.is_xml(True), "boolean argument  passed as string !!!")
#passing numeric argument
    def test_7_is_xml(self):
        self.assertFalse(self.obj1.is_xml(4),"   ")               
#passing list as argument
    def test_8_is_xml(self):
        self.assertFalse(self.obj1.is_xml([2,3,4,5]),"list must not be argument  ")
#passing dictionary    
    def test_9_is_xml(self):
        self.assertFalse(self.obj1.is_xml({'hello':3,'itc':5,'students':7}),"dictioanry must not be argument  ")
#passing tuple    
    def test_10_is_xml(self):
        self.assertFalse(self.obj1.is_xml((1,2,3,4,)),"tuple  must not be an argument  ")

#check if get_element_count() result is 0 or other type
    def test_11_get_element_count(self):
        self.assertNotEqual(None, self.obj1.get_element_count(), "booom")#compare None and result
    def test_12_get_element_count(self):
        self.assertNotEqual(1.234, self.obj1.get_element_count(), "booo ")#compare float and result
    def test_13_get_element_count(self):
        self.assertNotEqual([1,2], self.obj1.get_element_count(), "booom boom")#compare list  and result

    def test_14_get_element_count(self):
        self.assertFalse(isinstance(self.obj1.get_element_count(), str), 
                                      "buubuum")#compare string and result
    def test_15_get_element_count(self):
        self.assertFalse(isinstance(self.obj1.get_element_count(), tuple), 
                                      "puuuuy")#compare tuple and result
    def test_16_get_element_count(self):
        self.assertFalse(isinstance(self.obj1.get_element_count(),bool ), 
                                      "puuuuy")#compare bool and result

#check if get_xml_structure() result is not xml string

    def test_17_get_xml_struct(self):
        str1 = '<a><b></b><c></c><a>'
        self.assertNotEqual(str1, self.obj1.get_xml_structure(), "but they aren't the same" )    
    def test_18_get_xml_struct(self):
        self.assertNotEqual(None, self.obj1.get_xml_structure(), "compare None ang result" )    
    def test_19_get_xml_struct(self):
        self.assertNotIsInstance(self.obj1.get_xml_structure(), int,
                                   "compare int and function result" ) 
    
    def test_20_get_xml_struct(self):
        self.assertNotIsInstance(self.obj1.get_xml_structure(), list,
                                    "compare list and function result" )
     
    def test_21_get_xml_struct(self):
        self.assertNotIsInstance(self.obj1.get_xml_structure(), dict,
                                     "compare dict and function result" )

    
    def test_22_get_xml_struct(self):
        self.assertNotIsInstance(self.obj1.get_xml_structure(), tuple,
                                     "compare tuple and function result" ) 

    def test_23_get_xml_struct(self):
        self.assertNotIsInstance(self.obj1.get_xml_structure(), float,
                                      "compare float and function result" ) 


    def test_24_get_xml_struct(self):
        self.assertNotIsInstance(self.obj1.get_xml_structure(), complex,
                                       "compare complex and function result" ) 

suite = unittest.TestLoader().loadTestsFromTestCase(Negativetestxmlparser)
unittest.TextTestRunner(verbosity=2).run(suite)


     
#if __name__ =='__main__':
 #   unittest.main()
