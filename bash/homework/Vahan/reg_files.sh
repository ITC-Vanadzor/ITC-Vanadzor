#!/bin/bash
ls -lt | sed 's/\s\+/ /g' | cut -d" " -f6-9 | sort -M
