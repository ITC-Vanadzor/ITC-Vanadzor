#!/bin/bash
#creates the doublicat of the file and reverse its content.
tac $0 > double.txt
cat double.txt |rev > vise_versa2.txt
rm -f double.txt
