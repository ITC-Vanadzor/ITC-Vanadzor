#!usr/bin/python

import unittest
from xml_parse import parser

class Testsxml(unittest.TestCase):

	def test_pars(self):
		self.assertEqual ((parser.pars('xml.xml').getElementsByTagName('title')[0].childNodes[0].nodeValue), 'example glossary')

	def test_pars1(self):
		self.assertRaises (IOError, parser.pars, 'aaa')

	def test_text(self):
		xml=parser.pars('xml.xml')
		arr=['glossary', 'title']
		index=[0, 0]
		self.assertEqual (parser.text(xml, arr, index), 'example glossary')

	def test_atribut(self):
		xml=parser.pars('xml.xml')
		arr1=['glossary', 'GlossDiv', 'GlossList', 'GlossEntry', 'GlossDef']
		arr2=['GlossSeeAlso', 'OtherTerm']
		index=[0, 0, 0, 0, 0, 0]
		self.assertEqual (parser.atribut(xml, arr1, arr2, index), 'GML')

	def test_atribut1(self):
		xml=parser.pars('xml.xml')
		arr1=['glossary', 'GlossDiv', 'GlossList', 'GlossEntry', 'GlossDef', 'GlossSeeAlso:OtherTerm']
		arr2=['GlossSeeAlso', 'OtherTerm']
		index=[0, 0, 0, 0, 0, 1]
		self.assertEqual (parser.atribut(xml, arr1, arr2, index), 'XML')
