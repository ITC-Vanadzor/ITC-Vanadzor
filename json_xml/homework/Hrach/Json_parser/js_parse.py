#!/usr/bin/python

import sys
class parser():

	@classmethod
	def parse(self, file_name):
		import json
		try:
			jsObj=open(file_name, "r")
		except IOError:
			sys.exit("not valid file")
		except ValueError:
			sys.exit("file is not json")
		return json.load(jsObj)

	@classmethod
	def obj_text(self, js, arr):
		for i in range(len(arr)):
			try:
				js=js[arr[i]]
			except KeyError:
				sys.exit(arr[i]+" not valid")
		return js

	@classmethod
	def arr(self, js, arr1, arr2):
		for i in range(len(arr1)-1):
			try:
				js=js[arr1[i]]
			except KeyError:
				sys.exit(arr1[i]+" not valid")
		for j in range(2):
			try:
				js=js[arr2[j]]
			except KeyError:
				sys.exit(arr2[j]+" not valid")
		return js
