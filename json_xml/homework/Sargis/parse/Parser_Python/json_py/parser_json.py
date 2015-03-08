#!/usr/bin/python

#this script will show the content of the json file, that user must input from command line as an argument
#user will input path of json file elements(separeting them by '.' and ':') and it will print value. After ':' character
# must be index of list( ':' can separate  any parts of path, not only last element)
#Script will check if inputed path is valid or not, and print compatible error message.

import json
import sys
import argparse

parser = argparse.ArgumentParser()
parser.add_argument("fileName", type=str, help="argument should be json file name")
args = parser.parse_args()

json_data = open(args.fileName)

data = json.load(json_data)
json_data.close()

print "here is our json file's content :",json.dumps(data, indent=4)

path = raw_input("Input the path of the element you need: ") #users' input

path = path.replace(":",".")
path_parts = path.split("." ) #seperate input by '.' and get array
dict_key = '' # will contain keys for 'data' dictionary
def is_valid(dict_key, key_part): # checks if inputed path part is valid in given json file
    global path
    try:
        test = 'data'+dict_key
        test = eval(test)
        #json.dumps(test)
        return True
    except KeyError:
        if  path_parts[0] == key_part:
            print key_part+"  is not valid element name"
        else:
            temp = path_parts.index(key_part)
            temp_list = path_parts[:temp]
            print "In your input "+path+"\n "+key_part+" element  doesn't exist, but the elements:",temp_list," are valid "
        return False
    except IndexError:
        print key_part,"  is not valid index"
        return False

# build_key() function will build keys for 'data' dictionary, using the string that user has inputed
#and will check  if the key part is valid
def build_key():
    global dict_key
    for key_part in path_parts:
        if key_part.isdigit():
            key_part = int(key_part)
            dict_key += '['+`key_part`+']'
        else:
            dict_key +='["'+key_part+'"]'
        if not is_valid(dict_key, key_part):
            sys.exit()
#print_answer() function will be executed after build_key() and will print 'data' dictionary with valid keys
def print_answer():
    global dict_key
    print dict_key
    dict_key = 'data'+dict_key
    json_data= eval(dict_key)
    print json.dumps(json_data, indent=4) 

build_key()
print_answer()
