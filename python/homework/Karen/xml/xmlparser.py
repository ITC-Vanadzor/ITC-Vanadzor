#!/usr/bin/python

import xml.sax

class XmlParser:
	def parse(self, file):
		return False

	def is_xml(self, string):
		return False

	def get_element_count(self):
		return 0

	def get_xml_structure(self):
		return '<a><b></b><c></c></a>'

class MyXmlContentHandler(xml.sax.ContentHandler):
    def __init__(self):
        self.current_data = ""
        self.name = ""
        self.age = ""

    def startElement(self, tag, attr):
        self.current_data = tag
        if self.current_data == "student":
            print "----------student---------", self.current_data

    def characters(self, cont):
        if self.current_data == "name":
            self.name = cont
        if self.current_data == "age":
            self.age = cont

    def endElement(self, tag):
        if self.current_data == "name":
            print "Name: ", self.name
        if self.current_data == "age":
            print "Age: ", self.age
        self.current_data = ""

if __name__ == "__main__":
    parser = xml.sax.make_parser()
    handler = MyXmlContentHandler()
    parser.setContentHandler(handler)

    parser.parse("students.xml")

