#!/usr/bin/python
d ='1546551'
str =  "HELLO WORLD!!!";
str_1 = "that's great!";
str_2 = "#####In the late 1980s, Van Rossum began work on Python at the National Research Institute for Mathematics and Computer Science in the Netherlands.#########"
print str.lower();
print str_1.upper();
print str_2.strip( '#' );
if str_2.isspace():
    print 'There are spaces in text above.';
else:
    print 'There are no spaces in text above';

if str_2.isalpha():
    print 'the text is alphabetical'
else:
    print 'there are other charachters besides letters!'
print  d;
if d.isdigit():
    print 'it is digit';

str_3 = "Python 2.0 was released on 16 October 2000"
print str_3;
print str_3.startswith('Python');
print str_3.endswith('October');
print str_2;
print "Van Rossum is the"
print str_2.find('Van Rossum')
print "th word in the text above";
str_4 = "I love my baby.My baby is awesome.baby baby boo."
print str_4.replace("baby", "Sofia",3)
print str_4.split(' ', 3);
str_5 = str_4.split();
dash = "-";
print dash.join(str_5);
