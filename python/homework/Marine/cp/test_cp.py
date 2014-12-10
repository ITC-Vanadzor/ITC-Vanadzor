#!/usr/bin/python

import os
import unittest
import cp

class Test_copy(unittest.TestCase):
    def test_cp1(self):
        path = "/home/marine/Documents"
        path1 = "/home/marine/Desktop"
        cp_dir = cp.copy_r(path,path1)
        cp_dir2=os.path.isdir(path)
        self.assertEqual(cp_dir, cp_dir1, 'Please input directory')
def test_cp2(self):
        path = "/home/marine/cp.py"
        path1 = "/home/marine/Desktop"
        cp_dir = cp.copy_r(path,path1)
        cp_dir2=os.path.isfile(path)
        self.assertEqual(cp_dir, cp_dir1, 'Please input file')


if __name__=='__main__':
    unittest.main()
