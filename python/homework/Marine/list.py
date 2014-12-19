#!/usr/bin/python

c=['1', 'b', '2', 'd', '3', 'f']
d=['4', 'k', '5', 'j', '6', 'l']
g=c+d
l=[]
print g
for x in g:
    if x.isdigit():
        l.append(x)
    else:
        g.remove(x)
l=l.sort()
print l.reverse()
