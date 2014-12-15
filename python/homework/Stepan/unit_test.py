#!usr/bin/python

import unittest 
import xmlparser

class xmlparserTestCase(unittest.TestCase):

    def test_parse(self):
        testparse = xmlParser.parse(file)    
        self.assertTrue(testparse)
        return True	
 
    def test_is_xml(self):
        test_is_xml = is_xml(string)
        self.assertTrue(test_is_xml)
	return True	
 
if __name__ == '__main__':
    unittest.main()
 
