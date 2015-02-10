#!/usr/bin/python
import json
import argparse

#This class searching key value in json file
class Parser:
    def __init__(self,json_file, key ):
        self.json_file = json_file
        self.key = key
    
    def Fineder_key_in_json(self):
        try:
            json_data=open(self.json_file)
            data = json.load(json_data)
        except IOError:
           print "incorrect file"
           return None 
       	json_key=self.key.split(".")
	length_json_key=len(json_key)
	c=json_key[length_json_key-1]
	k=c.split(':')
	json_key[length_json_key-1]=k[0]

	if self.key=="":
	    print "Input json keys"
	else:
      	    b=data
            try:		
                for element in json_key:
   	            b =b[element]
	    except KeyError:
		print  element,"undefined"
		return None
	    k[1]=int(k[1])	
          	
	    if isinstance(b, dict):	
	        print "Input full path"
	    else:
		if k[1]=="":
		    print b
		else:
		    l=0
		    m=len(b)
		    if m>k[1]:
		        for value in b:
			    if l==k[1]:	
		     	        print b[l]
			        break
			    l=l+1
		    else:
			print "Element with this number does not exist"
def parse_command_line_arguments():
    arg_parser = argparse.ArgumentParser(
        description='Command line arguments.')
    arg_parser.add_argument('-f', '--file',
            dest='file_name', help='test file name.')
    return arg_parser.parse_args()

if __name__ == "__main__":
    arguments = parse_command_line_arguments()
    file_name = arguments.file_name
    key_name=raw_input("Input what you need: ")
    obj_parser = Parser(file_name, key_name)
    obj_parser.Fineder_key_in_json()


