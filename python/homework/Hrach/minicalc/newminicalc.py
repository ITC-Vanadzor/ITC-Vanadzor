#!/usr/bin/python

import argparse
parser = argparse.ArgumentParser()
parser.print_help()
parser.add_argument('n1', nargs='?',type=float, help='First argument, please enter number')
parser.add_argument('op', choices=['+', '-', 'x', '/'], help='Second argument, please enter + or - or x or /')
parser.add_argument('n2', nargs='?',type=float, help='Third argument, please enter number')
parser.parse_args()

class math():
	@classmethod
	def gum(self, n1, n2):
		print n1+n2
		return n1+n2
	@classmethod
	def tarb(self, n1, n2):
		print n1-n2
		return n1-n2
	@classmethod
	def art(self, n1, n2):
		print n1*n2
		return n1*n2
	@classmethod
	def hayt(self, n1, n2):
		print n1/n2
		return n1/n2

x=parser.parse_args().n1
y=parser.parse_args().n2
if parser.parse_args().op == '+':
	math.gum(x, y)
elif parser.parse_args().op == '-':
	math.tarb(x, y)
elif parser.parse_args().op == 'x':
	math.art(x, y)
elif parser.parse_args().op == '/':
	math.hayt(x, y)
