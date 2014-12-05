#!/usr/bin/python
n=raw_input('Input Your Name: ')
n=n.upper()
n=n.strip()
m=raw_input('Input Your Name: ')
m=m.upper()
m=m.strip()
print '*'.join(n), '*'.join(m)
k='lower() ,upper() ,strip() ,isalpha() ,isdigit() ,isspace() ,startswith(str) ,endswith(str) ,find(str) ,replace(old, new) ,split(delimiter) ,join(list)'
print k.isalpha()
print k.split(',')
for x in k:
    l=k.replace('(','/')
    l=l.replace(')', '/')
print l
print k.find('strip')
   
print k.startswith('low')
print k.endswith('is')

