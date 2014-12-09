#!/usr/bin/python

"""
Name: Copy Programm
Version: 1.0
Relise: 1.2
Author: Gor
Creating Date: 09.12.2014
Desc: This programm wil be copping files and directories
@-p optional argument, will allow us create folders recursively
@my_mkdir() function checks if there already exists such folder and if not, creates it
"""

import unittest
import copy
import os

class PositiveTestCase(unittest.TestCase):
    @classmethod
    def test_file_copy_run(self):
	path = file_copy(path_file)
	self.assertTrue(file_copy(path_file), "Fail file_copy is not working")

    def test_file_copy1_run(self):
	path = file_copy(to_path_file)
	self.assertTrue(file_copy(to_path_file), "Fail file_copy is not working")

    def test_file_copy2_run(self):
	path = file_copy(recursive_copy)
	self.assertTrue(file_copy(recursive_copy), "Fail file_copy is not working")

if __name__ == '__main__':
    unittest.main()

