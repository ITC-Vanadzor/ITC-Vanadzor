#!/usr/bin/python

import unittest
import cp
import os

class PositiveTestCp(unittest.TestCase):

    @classmethod
    def setUpClass(self):
        pass

    def test_1_cp(self):
        file_name = "cp.py"
        copy_name = 'cp_copy.py'
        self.assertEqual(cp.method_cp(file_name, copy_name ), os.path.isfile(copy_name),  'File(or directory) is not exist.')

class NegativeTestCp(unittest.TestCase):

    @classmethod
    def setUpClass(self):
        pass

    #Invalid file name
    def test_1_cp(self):
        file_name = "invalid_file_name" #File is not exist
        copy_name = 'copy_file_name'
        self.assertTrue(not cp.method_cp(file_name, copy_name ), 'Error! File (or directory) not found.')

    #Flag = False
    def test_2_cp(self):
        file_name = "Test_Dir" #Test_Dir is exist
        copy_name = 'copy_dir_name'
        self.assertTrue(not cp.method_cp(file_name, copy_name ), 'Error! Please set -r flag.')

    #Empty copy name
    def test_3_cp(self):
        file_name = "cp.py" #File(or directory) is exist
        copy_name = ''#Empty copy name
        self.assertTrue(not cp.method_cp(file_name, copy_name ), 'Error! Please set copy name.')
