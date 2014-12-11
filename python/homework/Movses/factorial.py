#!/usr/bin/python

import argparse

def factorial(x):
    if x == 0:
        return 1
    elif x < 0:
        print 'Error'
    else: 
        return x * factorial(x - 1)

parser = argparse.ArgumentParser()
parser.add_argument('-n', dest='top',
        action='store', default='0',
        help='number')
args = parser.parse_args();

print factorial(int(args.top))
