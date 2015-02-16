#!/usr/bin/python

class my_parser():

    #returns root element of xml tree
    @classmethod
    def parse_to_el(self, filename):
        import xml.etree.ElementTree as ET
        tree = ET.parse(filename) 
        root = tree.getroot()
        return root

    #prints the file content 
    @classmethod
    def print_content(self, filename):
        import lxml.etree as etree
        xml_content = etree.parse(filename)
        print etree.tostring(xml_content, pretty_print = True)
        return etree.tostring(xml_content, pretty_print = True)


    #checks if path's 1st part is indentical to root name
    @classmethod
    def is_root(self, root, path_parts):
        if root.tag == path_parts[0]:
            return True
        else:
            return False

    #checks if tag is the child of element before it
    @classmethod
    def is_child(self, root, child_elem):
        if not len(root.getchildren()) == 0:
            for i in root.getchildren():
                if i.tag == child_elem:
                    return True
            print root.tag," hasn't ",child_elem," child"        
            return False        
        else:
            print root.tag," hasn't any  child tag in this file, next time input correct path"
            return False

    #checks if inputed path is valid or not and prints error messages, if neccesary
    @classmethod
    def check_inputs_errors(self, path_parts,root):   
        if self.is_root(root,path_parts):
            if len(path_parts) == 1:
                return True
            else:
                for i in range(len(path_parts)-1):
                    if not self.is_child(root,path_parts[i+1]):
                        return False
                    root = root.find(path_parts[i+1])    
                return True        
        elif path_parts[0] == '' and len(path_parts)==1:
            print "you haven't inserted first element" 
            return False
        else:
            print path_parts[0]," doesn't exist"
            return False


    # deletes 1st part of path and replaces '.' with '/' (is made for using find() function)
    @classmethod
    def format_path(self, path):
        path = path.split('.',1)
        if not len(path)==1:
            path = path[1]
        else:
            path = path[0]
        path = path.replace('.','/')
        return path 

    #elem_value returns content of tag and prints it. Is executed only if path_array is checked and has returned true
    @classmethod
    def elem_value(self, path, root):
        import xml.etree.ElementTree as ET
        path = self.format_path(path)
        if root.tag == path:
            elem = root
        else:
            elem = root.find(path)

        if elem.text == None and len(elem.getchildren())==0:
            print path," is empty tag, but it's valid"
            return None
        elif not len(elem.getchildren()) == 0:
            print ET.tostring(elem)
            return elem
        else:
            print elem.text
            return elem.text


    #checks if element has any attribute
    @classmethod
    def has_attrib(self, path_array,root):
        path_array.pop(0)
        path = '/'.join(path_array)
        elem = root.find(path)
        elem
        if len(elem.attrib) == 0:
            return False
        else:
            return True
    
    #prints and returns attribute value
    @classmethod
    def attrib_value(self, path_array, attrib_name, root):
        path = '/'.join(path_array)
        elem = root.find(path)
        attributes = elem.attrib
        try:
            print attributes[attrib_name]
            return attributes[attrib_name]
        except KeyError:
            print  root.tag+'/'+path," tag doesn't have",attrib_name," attribute. " 
            return None

