#!/usr/bin/python

import os
import argparse

def my_parse_args():
    parser = argparse.ArgumentParser()
    parser.add_argument('path', help="TODO")
    parser.add_argument('-p', action='store_true', help="TODO")
    return parser.parse_args()

def my_parse_args1():
    parser = argparse.ArgumentParser()
    parser.add_argument('-p', required=True,  action='store_true', help="TODO")
    return parser.parse_args()

def echo(string):
    print string

def echo_name():
    echo(__name__)

def create_dir_rec(poxos):
    # TODO check path is dir
    # TODO check is dir valid
    # TODO arg
    
    karen = os.path.abspath(os.path.join(poxos, os.pardir))
    my_list = []
    my_list.append(poxos)
    my_list.append(karen)
    while(not os.path.exists(karen)):
        karen = os.path.abspath(os.path.join(karen, os.pardir))
        my_list.append(karen)

    my_list.pop()
    my_list.reverse()

    for item in my_list:
        my_mkdir(item)
    

def my_mkdir(poxos):
    # TODO check path is dir
    # TODO check is dir valid
    
    parent = os.path.abspath(os.path.join(poxos, os.pardir))
    if not os.path.exists(parent):
        return False
    try:
        os.mkdir(poxos)
    except OSError, e:
        echo("something wrong, Error is " + str(e))
    return True

if "__main__" == __name__:
    args = my_parse_args()
    is_created = my_mkdir(args.path)
    if not is_created and args.p:
        create_dir_rec(args.path)
    elif not is_created and not args.p:
        my_parse_args1()
         
    echo_name()
