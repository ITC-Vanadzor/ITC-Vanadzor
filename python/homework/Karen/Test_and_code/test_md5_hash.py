#!/usr/bin/python

import unittest
import md5_hash as md5_hash

class TestMyScript(unittest.TestCase):

    def test_parser(self):
        parser = md5_hash.ToMd5("text_file.txt")
        md5_code = parser.convert_to_md5()
        md5_length = len(md5_code)
        self.assertEqual(32, md5_length)

if __name__ == '__main__':
    unittest.main()
