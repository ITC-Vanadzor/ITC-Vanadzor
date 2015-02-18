#!/usr/bin/python

import json
from pprint import pprint
json_data=open('json.json')

data = json.load(json_data)
json_data.close()

value = raw_input("Please enter your request: ")
part = value.replace(":",".")
res = part.split(".");
n = data[res[0]]
for i in xrange(1,len(res)):
    n = n[res[i]] 

print n

def main():
    pass

if "__main__"==__name__:
    main()
