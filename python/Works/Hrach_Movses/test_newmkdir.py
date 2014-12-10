import unittest
import os
import mkdir

class PositiveTestCase(unittest.TestCase):
    
    def test_run2(self):
        path = "sasasas/is/created"
        mkdir.my_mkdir(path)
        self.assertFalse(os.path.exists(path), 'TODO')
    
    def test_run1(self):
        path = "aaaaa/is/created"
        self.assertFalse(os.path.exists(path), 'TODO')

    def test_run4(self):
        path = "aaa/bbb/ccc"
        mkdir.create_dir_rec(path)
        self.assertTrue(os.path.exists(path), 'TODO')


class NegativeTestCase(unittest.TestCase)
    
    def test_tun5(self):
        path = None
        mkdir.my_mkdir(path)
        self.assertTrue(mkdir.my_mkdir(path), "None path")


if __name__ == '__main__':
    unittest.main()
