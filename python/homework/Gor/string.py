#!/usr/bin/pythone

str = raw_input("Add Your text here..: ");



print "1. Your text in lower -  "+ str.lower();
print "2. Your text in upper -  "+ str.upper();
print "3.Your text in strip -  "+ str.strip( ' ' );
if str.isalpha() and len(str) > 0:
    print "4.Your text in isalpha - True"
else:
    print "4.Your text in isalpha - False"
if str.isdigit() and len(str) > 0:
    print "5.Your text in isdigit - True"
else:
    print "5.Your text in isdigit - False"
if str.isspace() and len(str) > 0:
    print "6.Your text in isspace - True"
else:
    print "6.Your text in isspace - False"
print str.startswith(str, 2)


