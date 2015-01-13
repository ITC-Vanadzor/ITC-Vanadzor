#!/usr/bin/python

import argparse

def fact(x):
    if x == 0:
        return 1
    elif x < 0:
        print 'Error'
    else: 
        return x*fact(x-1)

parser = argparse.ArgumentParser()
parser.add_argument('-n',required=True,type=int, nargs=1,  help='number')
args = parser.parse_args();

print("fact: {}".format(fact(args.n[0])))
