'''
Name: MD5 codding script
Author : Gor J.
Created: 4.12.2014
'''


#!/usr/bin/pythone

import os
import zipfile

dirname = raw_input("Enter directory or file path_: ");
filename = raw_input("Enter zip name_: ");

zf = zipfile.ZipFile(filename+".zip", "w", zipfile.ZIP_DEFLATED)
for dirname, subdirs, files in os.walk("dirname"):
    zf.write(dirname)
    for filename in files:
        zf.write(os.path.join(dirname, filename))
zf.close()
