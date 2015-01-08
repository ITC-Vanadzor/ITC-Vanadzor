#!usr/bin/python

import unittest
import minicalc

class TestsCalc(unittest.TestCase):
	def test_gum1(self):
		minicalc.A1=1
		minicalc.A3=4
		self.assertEqual (minicalc.gum(), 5)
	def test_tarb1(self):
		minicalc.A1=1
		minicalc.A3=4
		self.assertEqual (minicalc.tarb(), -3)
	def test_art1(self):
		minicalc.A1=1
		minicalc.A3=4
		self.assertEqual (minicalc.art(), 4)
	def test_hayt1(self):
		minicalc.A1=1
		minicalc.A3=4
		self.assertEqual (minicalc.hayt(), 0)
	def test_gum2(self):
		minicalc.A1=3.0
		minicalc.A3=6
		self.assertEqual (minicalc.gum(), 9.0)
	def test_tarb2(self):
		minicalc.A1=3.0
		minicalc.A3=6
		self.assertEqual (minicalc.tarb(), -3.0)
	def test_art2(self):
		minicalc.A1=3.0
		minicalc.A3=6
		self.assertEqual (minicalc.art(), 18.0)
	def test_hayt2(self):
		minicalc.A1=3.0
		minicalc.A3=6
		self.assertEqual (minicalc.hayt(), 0.5)
	def test_gum3(self):
		minicalc.A1=5
		minicalc.A3=2.0
		self.assertEqual (minicalc.gum(), 7.0)
	def test_tarb3(self):
		minicalc.A1=5
		minicalc.A3=2.0
		self.assertEqual (minicalc.tarb(), 3.0)
	def test_art3(self):
		minicalc.A1=5
		minicalc.A3=2.0
		self.assertEqual (minicalc.art(), 10.0)
	def test_hayt3(self):
		minicalc.A1=5
		minicalc.A3=2.0
		self.assertEqual (minicalc.hayt(), 2.5)
	def test_art4(self):
		minicalc.A1=-3
		minicalc.A3=2.0
		self.assertEqual (minicalc.art(), -6.0)
	def test_hayt4(self):
		minicalc.A1=-3
		minicalc.A3=2.0
		self.assertEqual (minicalc.hayt(), -1.5)
	def test_art5(self):
		minicalc.A1=6
		minicalc.A3=-12.0
		self.assertEqual (minicalc.art(), -72.0)
	def test_hayt5(self):
		minicalc.A1=6
		minicalc.A3=-12.0
		self.assertEqual (minicalc.hayt(), -0.5)
	def test_art6(self):
		minicalc.A1=-5
		minicalc.A3=-5.0
		self.assertEqual (minicalc.art(), 25.0)
	def test_hayt6(self):
		minicalc.A1=-5
		minicalc.A3=-5.0
		self.assertEqual (minicalc.hayt(), 1.0)
