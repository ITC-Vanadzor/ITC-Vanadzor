#!/usr/bin/python

class math():

	@classmethod
	def gum(self, n1, n2):
		return n1 + n2

	@classmethod
	def tarb(self, n1, n2):
		return n1 - n2

	@classmethod
	def art(self, n1, n2):
		return n1 * n2

	@classmethod
	def hayt(self, n1, n2):
		try:
			return n1 / n2
		except ZeroDivisionError:
			print "Division by zero"

