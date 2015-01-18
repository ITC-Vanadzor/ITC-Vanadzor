#!usr/bin/python

import unittest
from newminicalc import math

class TestsCalc(unittest.TestCase):
	def test_gum1(self):
		self.assertEqual (math.gum(1, 4), 5)
	def test_tarb1(self):
		self.assertEqual (math.tarb(1, 4), -3)
	def test_art1(self):
		self.assertEqual (math.art(1, 4), 4)
	def test_hayt1(self):
		self.assertEqual (math.hayt(1, 4), 0)
	def test_hayt2(self):
		self.assertEqual (math.hayt(3, 6.0), 0.5)
	def test_tarb2(self):
		self.assertEqual (math.tarb(5, 2), 3)
	def test_hayt3(self):
		self.assertEqual (math.hayt(5.0, 2), 2.5)
	def test_art2(self):
		self.assertEqual (math.art(-2, 0.3), -0.6)
	def test_hayt4(self):
		self.assertEqual (math.hayt(-3, 2.0), -1.5)
	def test_art3(self):
		self.assertEqual (math.art(2.5, -12), -30)
	def test_hayt5(self):
		self.assertEqual (math.hayt(6.0, -12), -0.5)
	def test_art4(self):
		self.assertEqual (math.art(-5, -5), 25)
	def test_hayt6(self):
		self.assertEqual (math.hayt(-5, -5), 1)
	def test_gum2(self):
		self.assertEqual (math.gum(-5, 4), -1)
	def test_gum3(self):
		self.assertEqual (math.gum(-5, -5), -10)
	def test_gum4(self):
		self.assertEqual (math.gum(5, -5), 0)
	def test_tarb3(self):
		self.assertEqual (math.tarb(-5, 5), -10)
	def test_tarb4(self):
		self.assertEqual (math.tarb(3.3, -5), 8.3)
	def test_tarb5(self):
		self.assertEqual (math.tarb(-6, -6), 0)
	def test_gum5(self):
		self.assertEqual (math.gum(2.3, -5), -2.7)
	def test_tarb6(self):
		self.assertEqual (math.tarb(-5, 3.3), -8.3)
	def test_gum6(self):
		self.assertEqual (math.gum(-5, 1.6), -3.4)
