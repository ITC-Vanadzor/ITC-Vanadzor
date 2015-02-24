#!/usr/bin/python

def args():
	import argparse
	parser = argparse.ArgumentParser()
	parser.add_argument('n1', nargs='?',type=float, help='First argument, please enter number')
	parser.add_argument('op', choices=['+', '-', 'x', '/'], help='Second argument, please enter + or - or x or /')
	parser.add_argument('n2', nargs='?',type=float, help='Third argument, please enter number')
	return parser.parse_args()

if "__main__" == __name__:
	from mymath import math
	args()
	arguments = args()
	x=arguments.n1
	y=arguments.n2
	op=arguments.op
	if op == '+':
		print(math.gum(x, y))
	elif op == '-':
		print(math.tarb(x, y))
	elif op == 'x':
		print(math.art(x, y))
	elif op == '/':
		print(math.hayt(x, y))
