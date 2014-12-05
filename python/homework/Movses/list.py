#!/usr/bin/python

a=['e',1,4,'r','t',3,1]
a.append(['r','r'])
print (a)
'kavelacni verjic qarakusi pakagcerov' 

b=['e',1,4,'r','t',3,1]
b.extend(['r','r'])
print(b) 
'kavelacni verjic aranc qarakusi pakagceri'

c=[1,'k','3','tux']
c.insert(2,'ITC')
print(c)
'erkrord indexic heto kavelacni ITC'

d=['true','false',543,]
d.index( 543 )
print(d)
'petq e tpi 543-i indexy bayc chi tpum... patchary chgitem'


e=['for','while','for']
e.remove('while')
print(e)
'while clean'


f=[67,32,2,54,1,766]
f.sort()
print(f)
'kdasavori achman kargov'

m=[12,'polo','manko','gosh'] 
m.reverse()
print(m)
'tars ktpi'

x=[24,'polo','manko'] 
x.pop(2)
print(x)
'mankon kjnji'

