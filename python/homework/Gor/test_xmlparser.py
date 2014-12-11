import unittest
import xmlparser
import os

class TestXmlParser(unittest.TestCase):
    def test_get_element_count(self):
        xml_parser = XmlParser()
        self.assertEqual(self.xml_parser.get_element_count() "Element error")
        assert False

    def test_get_xml_structure(self):
        xml_parser = XmlParser()
        self.assertEqual(self.xml_parser.get_xml_structure() "XML structure error")
        assert False

    def test_is_xml(self):
        xml_parser = XmlParser()
        self.assertEqual(self.xml_parser.is_xml() "String error")
        self.assert False

    def test_parse(self):
        xml_parser = XmlParser()
        self.assertEqual(self.xml_parser.parse() "File error")
        assert False 
  
  def test_cp3(self):
        get_xml_structure = "None"
        self.assertTrue(xmlparser.cXmlParser(get_xml_structure), "Error")

if __name__ == '__main__':
    unittest.main()
