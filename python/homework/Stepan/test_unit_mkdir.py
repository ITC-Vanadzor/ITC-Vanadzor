import unittest
import mkdir
import os

def div(a, b):
    try:
        return a/b
    except TypeError:
        return None
    except ZeroDivisionError:
        return 0

class PositiveTestCase(unittest.TestCase):

    @classmethod
    def setUpClass(self):
        print " ----- setUpClass ------ "
        pass

    def setUp(self):
        print " ----- setUp ------ "
        pass

    def test_2_run(self):
        print " ----- test 2 ------ "
        self.assertEqual(div(4, 2), 2, "TODO")
        pass

    def test_3_run(self):
        print " ----- test 3 ------ "
        self.assertEqual(div(None, None), None, "TODO")

    def test_4_run(self):
        print " ----- test 1 ------ "
        self.assertEqual(div(1, None), None, "TODO")

    def test_5_run(self):
        print " ----- test 1 ------ "
        self.assertEqual(div(None, 1), None, "TODO")

    def test_6_run(self):
        print " ----- test 1 ------ "
        self.assertEqual(div(7, 0), 0, "TODO")

    def test_7_run(self):
        path = "~/Desktop/aaaa/vvvv/ccc/ddd/ffff/nnnn"
        self.assertTrue(my_mkdir(path), "Fail mk_dir is not works")

    def test_8_run(self):
        path = "~/Desktop/aaaa/vvvv/ccc/ddd/ffff/nnnn"
        self.assertTrue(os.path.exists(path), "Fail mk_dir is not works")

