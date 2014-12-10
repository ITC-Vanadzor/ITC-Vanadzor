
import unittest
import new_cp

class PositiveTestCase(unittest.TestCase):
    
    @classmethod
    def setUpClass(self):
        pass
    def setUp(self):
        pass
    def test_1_run(self):
        path1 = "/home/sargis/Desktop/ff"
        path2 = "/home/sargis/ff"
        self.assertTrue(new_cp.my_cp_f(path1, path2), "laaav chiiiii, hech lav chi!!!")
    def test_2_run(self):
        path1 = "/home/sargis/Desktop"
        path2 = "/home/sargis/desktop2"
        self.assertTrue(new_cp.my_cp_dir(path1, path2), "laaav chiiiii, hech lav chi!!!")
        
