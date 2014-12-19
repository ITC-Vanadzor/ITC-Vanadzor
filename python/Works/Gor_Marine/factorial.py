#!/usr/bin/python


'''
    Factorial function 
'''

def factorial (n):
    if n == 0:
        return 1
    else:
        return n * factorial(n-1)

n= raw_input('Your Number :')
n= int(n)
print factorial(n)
