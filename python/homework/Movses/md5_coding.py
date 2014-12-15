#!/usr/bin/python

import hashlib

filename = raw_input("Please enter your text: ") 

def md5hash():
    m = hashlib.md5()
    m.update(filename)
    return m.hexdigest()

print format(md5hash())
      


