#!/usr/bin/python
import md5
import argparse

class ToMd5:
    def __init__(self, file_path):
        self.file_path = file_path

    def convert_to_md5(self):
        try:
            with open(self.file_path) as f:
                file_content = f.read()
            m = md5.new()
            m.update(file_content)
            return m.hexdigest()
        except AttributeError:
            print "Invalid argument."
            return None
        except IOError:
            print "Invalid file name."
            return None

if __name__ == "__main__":
    arg_parser = argparse.ArgumentParser(description = "Set arguments.")
    arg_parser.add_argument("-f", "--file", dest = "file_path", help = "Full file path and name.")
    arguments = arg_parser.parse_args()

    obj = ToMd5(arguments.file_path)
    print obj.convert_to_md5()
