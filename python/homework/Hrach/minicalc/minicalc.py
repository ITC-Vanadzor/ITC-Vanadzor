#!/usr/bin/python

A1 = 'a'
A2 = 'a'
A3 = 'a'
if '__main__' == __name__:
	while True:
		if isinstance( A1, int ) or isinstance( A1, float ):
			break
		else:
			A1 = input( 'input number1: ' )
	while True:
		if A2 != '+' and A2 != '-' and A2 != '*' and A2 !='/':
			A2 = raw_input( 'input + or - or * or / : ' )
		else: 
			break
	while True:
		if A3 == 0:
			print "integer division or modulo by zero"
			A3 = input( 'input number2: ' )
		elif isinstance( A3, int ) or isinstance( A3, float ):
			break
		else:
			A3 = input( 'input number2: ' )

def gum():
	global A
	A=A1+A3
	return A
def tarb():
	global A
	A=A1-A3
	return A
def art():
	global A
	A=A1*A3
	return A
def hayt():
	global A
	A=A1/A3
	return A

if '__main__' == __name__:
	if A2 == '+':
		gum()
	elif A2 == '-':
		tarb()
	elif A2 == '*':
		art()
	elif A2 == '/':
		hayt()
	print A
