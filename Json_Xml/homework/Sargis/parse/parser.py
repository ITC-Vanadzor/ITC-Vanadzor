#!/usr/bin/python

import json
json_data = open('work.json')

data = json.load(json_data)
json_data.close()

request = raw_input("Input what you need: ")
part = request.replace(":", ".")
words = part.split("." )

def json_p():
    try:
        if len(words) == 1:
            print data[words[0]]
        elif len(words) == 2:
            print data[words[0]][words[1]]
        elif len(words) == 3:
            print data[words[0]][words[1]][words[2]]
        elif len(words) == 4:
            print data[words[0]][words[1]][words[2]][words[3]]
        elif len(words) == 5:
            print data[words[0]][words[1]][words[2]][words[3]][words[4]]
        elif len(words) == 6:
            print data[words[0]][words[1]][words[2]][words[3]][words[4]][words[5]]
    except KeyError:
        print "There is no such element"

if "__main__"==__name__:
    json_p()
