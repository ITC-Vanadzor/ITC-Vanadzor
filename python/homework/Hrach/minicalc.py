#!/usr/bin/python
A1 = 'a'
A2 = 'a'
A3 = 'a'
while True:
	if isinstance( A1, int ) or isinstance( A1, float ):
		break
	else:
		A1 = input( 'input number: ' )
while True:
	if A2 != '+' and A2 != '-' and A2 != '*' and A2 !='/':
		A2 = raw_input( 'input + or - or * or / : ' )
	else: 
		break
while True:
	if isinstance( A3, int ) or isinstance( A3, int ):
		break
	else:
		A3 = input( 'input number: ' )

def gum():
	A=A1+A3
	print A
def tarb():
	A=A1-A3
	print A
def art():
	A=A1*A3
	print A
def hayt():
	A=A1/A3
	print A

if A2 == '+':
	gum()
elif A2 == '-':
	tarb()
elif A2 == '*':
	art()
elif A2 == '/':
	hayt()
