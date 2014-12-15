
import unittest
import new_cp

class PositiveTestCase(unittest.TestCase):
    
    def test_1_run(self):
        path1 = "/home/sargis/Desktop/ff"
        path2 = "/home/sargis/ff"
        self.assertFalse(new_cp.my_cp_f(path1, path2), 
                "laaav chiiiii, hech lav chi!!!")

    def test_2_run(self):
        path1 = "/home/sargis/Desktop"
        path2 = "/home/sargis/desktop2"
        self.assertTrue(new_cp.my_cp_dir(path1, path2), 
                "laaav chiiiii, hech lav chi!!!")

    def test_3_run(self):
        path3 = "/"
        self.assertEqual(new_cp.has_parent(path3), os.path.exists(os.path.abspath(os.path.join(path3, os.pardir))), "chuni tsnox!")
        self.assertTrue(new_cp.has_parent(path3)), "chuni tsnox!")

    def test_4_run(self):
        path1="/home/student/Desktop"
        path2="/home/student/Deskop/"
        self.assertTrue(new_cp.my_cp_dir(path1, path2),
                "no such file or directory")
        
