#!/usr/bin/python

aList = [123, 'xyz', 'zara', 'abc']
print aList
aList.sort()
print "List sorted : ", aList
aList.reverse()
print "List reverse : ", aList
aList.remove('xyz')
print "remove 'xyz' in List : ", aList
aList.remove('abc')
print "remove 'abc' in List : ", aList
aList.append( "uppended_arg" )
print "Updated List : ", aList
print "POP thrd second List : ", aList.pop(1)

