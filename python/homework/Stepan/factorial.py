#!/usr/bin/python

def factorial(n):
    print "called factorial func"
    print "n = ", n
    if n == 0:
        return 1
    else:
        return n * factorial(n-1)

'''
barev
'''
n=raw_input(" nermuceq n i arjeqy  ")
n=int(n)
print factorial(n)  
