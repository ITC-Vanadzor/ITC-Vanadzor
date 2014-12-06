#!/usr/bin/python

var_l = ['Hi', 'Instigate', 'Training', 'Center']
print var_l
var_l.append('students')
print "after append()",var_l
var_l.insert(4,'and')
print "after insert()",var_l
var_l2 = ['from', 'Vanadzor']
var_l.extend(var_l2)
print "after extend()",var_l
print "index(2nd elem)",var_l.index('Instigate')
var_l.remove('from')
print "after remove('from')",var_l
var_l.sort()
print "after sort()",var_l
var_l.reverse()
print "after reverse()",var_l
var_l.pop(2)
print "after pop(2)",var_l

