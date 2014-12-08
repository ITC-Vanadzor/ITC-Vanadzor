#!/usr/bin/python
import argparse
def fact1(c):
    if c == 0:
        return 1 
    elif c < 0:
        print "SXAL:Nermucel 1-ic mec tiv"
    else:
        return c * fact1(c - 1)

parser = argparse.ArgumentParser()
parser.add_argument('-n', dest='top',
        action='store', default='0',
        help='number')
args = parser.parse_args();

print fact1(int(args.top))
