
import unittest
import factorial

class PositiveTestCase(unittest.TestCase)

    def test_run(self):
    res = fact(5)
    self.assertEqual(res, 120)

if __name__=='__main__':
    unittest.main()
