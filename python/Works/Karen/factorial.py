#!/usr/bin/python
def factorial(a):
   if a < 2: 
      return 1	
   else:
      return a*factorial(a-1)
                                
print factorial(5)
