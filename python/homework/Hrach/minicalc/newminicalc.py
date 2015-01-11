#!/usr/bin/python

"""

Calculator
==========

This program is designed for simple mathematical operations
-----------------------------------------------------------

A1 variable that stores the first number
A2 variable that stores the operation(+, -, *, /)
A3 variable that stores the second number

"""

A1 = 'a'
A3 = 'a'

"""
while the program the user enters the first number, the second number and selects an operation, and the program returns the resulting number
available mathematical functions +, -, *, /
"""

import argparse
parser = argparse.ArgumentParser()
parser.add_argument('op', choices=['+', '-', 'x', '/'], help='TODO')
parser.parse_args()

while True:
	if isinstance( A1, int ) or isinstance( A1, float ):
		break
	else:
		try:
			A1 = input( 'input number1: ' )
		except NameError:
			print "it's not number"
while True:
	if isinstance( A3, int ) or isinstance( A3, float ):
		break
	else:
		try:
			A3 = input( 'input number2: ' )
		except NameError:
			print "its not nuber"

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

if parser.parse_args().op == '+':
	math.gum(A1, A3)
elif parser.parse_args().op == '-':
	math.tarb(A1, A3)
elif parser.parse_args().op == 'x':
	math.art(A1, A3)
elif parser.parse_args().op == '/':
	math.hayt(A1, A3)
