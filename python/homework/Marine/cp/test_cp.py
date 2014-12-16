#!/usr/bin/python

import os
import unittest
import cp

class PositivTest_copy(unittest.TestCase):
    def test_cp1(self):
        path = "/home/employee/Documents"
        path1 ="/home/employee/Desktop/ut"
        rec = True
        self.assertTrue(cp.copy_r(path, path1, rec), "TODO")
        self.assertTrue(os.path.isdir(path1), 'Please input directory')
                                            
    def test_cp2(self):
        path = "cp.py"
        path1 = "/home/employee/Desktop/12"
        rec = False
        self.assertTrue(cp.copy_r(path, path1, rec), "TODO")
        self.assertTrue(os.path.isfile(path1), 'Please input directory')
 
class NegativTest_copy(unittest.TestCase):

    def test_cp3(self):
        path1 ="/home/employee/Desktop/ut"
        rec = True
        self.assertTrue(cp.copy_r(None, path1, rec), "TODO")


    def test_cp4(self):
        path = "/home/student/dd"
        rec = True
        self.assertFalse(os.path.exists(path), 'No directory')
        self.assertTrue(cp.copy_r(path, None, rec), "TODO")


    def test_cp5(self):
        path = "/home/student/dd"
        path1 = "/home/employee/Desktop/ut"
        rec = False
        self.assertFalse(os.path.exists(path), 'No directory')
        self.assertTrue(cp.copy_r(path, path, rec), "TODO")
