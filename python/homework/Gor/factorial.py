#!/usr/bin/pythone

def factorial(n):
    m=raw_input("Plyse Insert Your Number..: ");
    num = 1
    while n >= 1:
        num = num * n
        n = n - 1
    return num

print factorial(m)
