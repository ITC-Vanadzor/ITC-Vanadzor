#!/usr/bin/python

import json
with open("work.json") as json_file:
    json_data = json.load(json_file)
    decoded = json.loads(json_file) 
request = raw_input("Input what you need:")
words = []
def parse_input(str):
    words = str.split("." )
    print(words)


def my_json_parser():
    print(json_data["glossary"])
   
def json_p():
    data = json.dumps(decoded, sort_keys=True, indent=1)
    print data
if "__main__"==__name__:
    json_p()
