#!/usr/bin/python

import unittest
import copy
import os

class PositiveTestCase(unittest.TestCase):
    @classmethod
    def test_file_copy_run(self):
	path = copy.file_copy(path_file)
	self.assertTrue(file_copy(path_file), "Fail file_copy is not working")

    def test_file_copy1_run(self):
	path = copy.file_copy(to_path_file)
	self.assertTrue(file_copy(to_path_file), "Fail file_copy is not working")

    def test_file_copy2_run(self):
	path = copy.file_copy(recursive_copy)
	self.assertTrue(file_copy(recursive_copy), "Fail file_copy is not working")

if __name__ == '__main__':
    unittest.main()

