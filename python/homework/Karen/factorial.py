#!user/bin/python
def factorial(n):
	if n < 2:
		return 1
	else:
		return n*factorial(n-1)

import argparse
parser = argparse.ArgumentParser(description="Get factorial")
parser.add_argument('-n',type=int, nargs=1, required=True, help='Please input number')
args = parser.parse_args()
 
print("Factorial: {}".format(factorial(args.n[0])))
