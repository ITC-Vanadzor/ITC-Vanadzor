#!/usr/bin/python
import argparse
parser = argparse.ArgumentParser()
parser.add_argument('-n', dest='n',
        action='store', default='0',
        help='number')
args = parser.parse_args();
k=int(args.n)
def factorial(k):
    if k==0:
        return 1
    else:
        return k * factorial(k-1)
print factorial(k)
