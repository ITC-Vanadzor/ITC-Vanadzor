#!/usr/bin/python

#this script will show the content of the json file, that user must input from command line as an argument
#user will input path of xml file elements(separeting them by '.' and ':') and it will print value. After ':' character
# must be attribute name of last tag.
#Script will check if inputed path is valid or not, and print compatible error message.
import sys
import argparse

def arg_parse():
    parser = argparse.ArgumentParser()
    parser.add_argument("fileName", type = str, help="positional argument should be xml filename")
    args = parser.parse_args()
    return args

def insert_path():
    print "Above is content of xml file: \n "
    path = raw_input("Input the path of element, you need: ")
    return path

def check_file(name):
    import xml.etree.ElementTree as ET
    try:
        ET.parse(name)
    except IOError:
        sys.exit("there is no such file")
    except ET.ParseError:
        sys.exit("the file doesn't match to XML standards")

if __name__=="__main__":
    from xml_prs import my_parser
    args = arg_parse()
    filename = args.fileName
    check_file(filename)
    root = my_parser.parse_to_el(filename)
    my_parser.print_content(filename)
    path = insert_path()
    path_array = path.split('.')
    last_elem = path_array[len(path_array)-1].split(':')
    if len(last_elem) == 1:
        if my_parser.check_inputs_errors(path_array,root):
            my_parser.elem_value(path,root)
    else:
        path_array[len(path_array)-1] = last_elem[0]
        if my_parser.check_inputs_errors(path_array,root):
            if my_parser.has_attrib(path_array,root):
                my_parser.attrib_value(path_array,last_elem[1],root)
            else:
                print "tag hasn't such attribute"
