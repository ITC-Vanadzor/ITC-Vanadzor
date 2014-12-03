#!/bin/bash
aa=$(ps -ef | grep chrome |cut -d" " -f4 | head -n1)
kill $aa

