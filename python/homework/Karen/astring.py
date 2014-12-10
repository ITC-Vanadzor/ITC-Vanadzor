#!/usr/bin/python

str = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."

upper = str.upper()
print "********Upper******" 
print upper

print "*******Split by 'is', lower*******" 
lower = str.lower()
replaced=lower.replace(".",".\n")
lst = lower.split("a")
print lst

print "*******Join list*******" 
print "-----".join(lst)

dot_pos = lower.find(".",0,len(lower))

