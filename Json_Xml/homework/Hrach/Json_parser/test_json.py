#!usr/bin/python

import unittest
from js_parse import parser

class TestsJson(unittest.TestCase):

	def test_parse(self):
		self.assertEqual (parser.parse('json.json')['glossary']['title'], 'example glossary')

	def test_text(self):
		js=parser.parse('json.json')
		arr=['glossary', 'title']
		self.assertEqual (parser.obj_text(js, arr), 'example glossary')

	def test_array(self):
		js=parser.parse('json.json')
		arr1=['glossary', 'GlossDiv', 'GlossList', 'GlossEntry', 'GlossDef:GlossSeeAlso']
		arr2=['GlossDef', 'GlossSeeAlso']
		arr=['GML', 'XML']
		self.assertEqual (parser.arr(js, arr1, arr2), arr)
