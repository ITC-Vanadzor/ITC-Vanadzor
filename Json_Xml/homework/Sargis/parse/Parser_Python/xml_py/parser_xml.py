#!/usr/bin/python

#this script will show the content of the json file, that user must input from command line as an argument
#user will input path of xml file elements(separeting them by '.' and ':') and it will print value. After ':' character
# must be attribute name of last tag.
#Script will check if inputed path is valid or not, and print compatible error message.


import sys
import argparse
import xml.etree.ElementTree as ET
import lxml.etree as etree

parser = argparse.ArgumentParser()
parser.add_argument("fileName", type = str, help="positional argument should be xml filename")
args = parser.parse_args()

filename = args.fileName
tree = ET.parse(filename) 
root = tree.getroot() #is root element of xml tree

#prints the file content
def print_content(filename):
    xml_content = etree.parse(args.fileName)
    print etree.tostring(xml_content, pretty_print = True)

print "Here is content of xml file: \n "
print_content(filename)
path = raw_input("Input the path of element, you need: ")

#checks if path's 1st part is indentical to root name
def is_root(root, path_parts):
    if root.tag == path_parts[0]:
        return True
    else:
        return False

#cheks if tag is the child of element before it
def is_child(root, child_elem):
    if not len(root.getchildren()) == 0:
        for i in root.getchildren():
            if i.tag == child_elem:
                return True
        print root.tag," hasn't ",child_elem," child"        
        return False        
    else:
        print root.tag," hasn't any  child tag in this file, next time input correct path"
        return False

#checks if inputed path is valid or not and prints error messages
def check_input(path_parts,root):   
    if is_root(root,path_parts):
        if len(path_parts) == 1:
            return True
        else:
            for i in range(len(path_parts)-1):
                if not is_child(root,path_parts[i+1]):
                    return False
                root = root.find(path_parts[i+1])    
            return True        
    elif path_parts[0] == '' and len(path_parts)==1:
        print "you haven't inserted first element" 
        return False
    else:
        print path_parts[0]," doesn't exist"
        return False


def build_array(path): #from path builds array with element names
    path_parts = path.split('.')
    return path_parts

# deletes 1st part of path and replaces '.' with '/' (is made for using find() function)
def format_path(path):
    path = path.split('.',1)
    if not len(path)==1:
        path = path[1]
    else:
        path = path[0]
    path = path.replace('.','/')
    return path 

#elem_value returns content of tag and prints it. Is executed only if path_array is checked and has returned true
def elem_value(path, root):
    path = format_path(path)
    if root.tag == path:
        elem = root
    else:
        elem = root.find(path)

    if elem.text == None and len(elem.getchildren())==0:
        print path," is empty tag, but it's valid"
        return None
    elif not len(elem.getchildren()) == 0:
        elem
        print ET.tostring(elem)
        return elem
    else:
        print elem.text
        return elem.text


#checks if element has any attribute
def has_attrib(path_array,root):
    path_array.pop(0)
    path = '/'.join(path_array)
    elem = root.find(path)
    elem
    if len(elem.attrib) == 0:
        return False
    else:
        return True



#prints and returns attribute value
def attrib_value(path_array, attrib_name, root):
    path = '/'.join(path_array)
    elem = root.find(path)
    attributes = elem.attrib
    try:
        print attributes[attrib_name]
        return attributes[attrib_name]
    except KeyError:
        print  root.tag+'/'+path," tag doesn't have",attrib_name," attribute. " 
        return None


#main function that will check if inputed path is valid and will return the value of that path, if valid.
#If path ends with element that has subtree, will print subtree.
#
def get_value(path):
    global root
    path_array = build_array(path)
    last_elem = path_array[len(path_array)-1].split(':')
    if len(last_elem) == 1:
        if check_input(path_array,root):
            return elem_value(path,root)
        
    else:
        path_array[len(path_array)-1] = last_elem[0]
        if check_input(path_array,root):
            if has_attrib(path_array,root):
                return attrib_value(path_array,last_elem[1],root)
            else:
                print "tag hasn't such attribute"
                return None


get_value(path)










