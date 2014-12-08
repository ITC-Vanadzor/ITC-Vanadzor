#!/usr/bin/python

import unittest
import cp
import os

class TestCp(unittest.TestCase):

	def test_method_cp(self):
		file_name = "cp.py"
		copy_name = 'cp_copy.py'
		flag = False
		test = cp.method_cp(file_name, copy_name, flag)
		manual = os.path.isfile(copy_name)
		self.assertEqual(manual, test, 'File(or directory) is not exist.')

if __name__ == '__main__':
	unittest.main()
