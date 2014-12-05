#!user/bin/python
import argparse
def factorial(n):
	if n < 0:
		print "Invalid argument."
	elif n == 0 or n == 1:
		return 1
	else:
		return n*factorial(n-1)

parser = argparse.ArgumentParser(description="Get factorial for N")
parser.add_argument('-n',type=int, nargs=1, required=True, help='Please input number')
args = parser.parse_args()
 
print("Factorial: {}".format(factorial(args.n[0])))
