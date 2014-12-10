#!/usr/bin/python
#a = int(raw_input("Enter int: "))
def factorial(a):
    if a == 1:
        return 1
    else:
	return a * factorial(a-1)
#print(factorial(a))
import argparse
parser = argparse.ArgumentParser(description='Counting integer factorial.')
parser.add_argument('a', metavar='N', type=int, help='an integer  for count the                     factorial')
parser.add_argument('-n', dest='factorial', action='store_const',                                   const=factorial, help='factorial the integer')

args = parser.parse_args()
print args.factorial(args.a) 
