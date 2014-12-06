#!/usr/bin/python

		  
def factorial(x):
    if x == 1:
        return 1
    else:
        return x*factorial(x-1)
#n = int(raw_input("Enter int: "))
#print factorial(x)
	
import argparse

parser = argparse.ArgumentParser(description='counting the factorial of given number')
parser.add_argument('x', metavar='N', type=int, help='display factorial of a gtven number')
parser.add_argument('-n', dest='factorial', action='store_const', const=factorial, help='factorial')
args=parser.parse_args()
print args.factorial(args.x)
