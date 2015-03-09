import unittest
import module.json_parser as json_parser
import random


class TestJsonParser(unittest.TestCase):
    #This is positive test case for json_parser
    def test_parse(self):
        parser = json_parser.Parser("resources/json_file", "key_1")
        key = parser.Fineder_key_in_json()
        self.assertEqual(key, "value_1", "in the json_file file no surch key_1 key")
   

if __name__ == '__main__':
    unittest.main()
