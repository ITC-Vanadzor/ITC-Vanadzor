#!/usr/bin/python
#from xml.dom.minidom import parse
import xml.dom.minidom
#from xml.etree import ElementTree
from xml.dom import minidom
#from xml.etree.ElementTree import tostring
import argparse
import string
import xml.etree.ElementTree as ET

parser = argparse.ArgumentParser(description='Process some XML file.')
parser.add_argument('file_url', type=str, help='a file to load')

args = parser.parse_args()
filename = args.file_url
#Open XML document
DOMTree = xml.dom.minidom.parse(filename)
root = DOMTree.documentElement
#tree = ET.parse(filename)
#root = tree.getroot()
print root.toprettyxml(indent = '  ',newl="")
while True:
    input_path = str(raw_input("Enter the path: "))
    input_array = string.split(input_path, ".")
    last_elem = input_array[-1]
    if ( last_elem.find(':') != -1 ):
        last_array = string.split(last_elem, ":")
        if (len(last_array) == 2):
            attrib = last_array[1]
            input_array[-1] = last_array[0]
            break
        else:
            print "Incorrect input,try again..."
    else:
        break
#Check if the input is valid
#def is_path(path):
#    for elem in path:
#        print elem.tagName
#is_path(root)



#check if the element has such attribute    
#def is_attrib(path, attrib):
# 
#
#def get_value(path):
#
#def error_message(path):
#    
#if is_path(path):
#    print get_value(path)
#else:
#    error_message(path)
