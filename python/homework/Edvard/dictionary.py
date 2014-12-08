#!/usr/bin/python
dict1 = {'1': 'one', '2' : 'two', '3': 'three', '4': 'four'}
#tpenq tvyal key-i element@
print dict1 ['1']
#popoxenq key-i element@
dict1 ['1'] = 'OnE'
print dict1
#avelacnenq nor element
dict1 ['5'] = 'five'
print dict1
#tpenq miayn key-er@
print dict1.keys()
#tpenq ciklov
for key, value in dict1.iteritems():
    print key, value
print dict1

print {x: x**2 for x in (2,3,4,5)}
