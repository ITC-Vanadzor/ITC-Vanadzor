#!/usr/bin/python

a="LOWER"
print(a.lower())


b="upper"
print(b.upper())


c="       c        "
print(c.strip()) 


d="tar-->false"
print(d.isalpha()) 
'ktpi false qani vor tarer en'


e="123"
print(e.isdigit()) 
'ktpi true qani vor tver en'


f="     "
print(f.isspace()) 
'ktpi true qani vor bacatner e'


g="this is my homework..."
print(g.startswith('this')) 
'ktpi true qani vor araji barn e'


h="This is my homework"
print(h.endswith('homework')) 
'ktpi true qani vor verji barn e'


i="This is my homework"
print(i.find('my'))
'ktpi vorerror simvoln e'

j="This is my homework" 
print(j.replace('homework' , 'work'))
'kpoxi ev ktpi'


k="This is my homework" 
print(k.split()) 
'ktpi listi nman'

l="tux python"
print(l.join('_')) 
'kpoxi "_" nshanov'


