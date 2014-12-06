#!/usr/bin/python
'''
working with python's string methods

'''
var = "Hello ITC team"
print "lower",var.lower()
print "upper()", var.upper()
print "isalpha()", var.isalpha()
var2 ="Hello"
print "isalpha()",var2.isalpha() 
print "isdigit()",var.isdigit()
var3 = "111"
print "isdigit()",var3.isdigit()
print "isspace()",var2.isspace()
var4 = "    "
print "isspace()",var4.isspace()
print "startswith()",var.startswith('Hello')
print "startswith()",var.startswith('ddd')
print "endswith()",var.endswith( 'team' )
print "replace()",var.replace('ITC', 'ITC Vanadzor')
print "split(delimeter)",var.split(' ')
var4 = "hii"
print "join(list)",var.join(var4)
