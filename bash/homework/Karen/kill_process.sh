#!/bin/bash
kill $(ps -ef | grep firefox | tr -s " " | head -n 1 | cut -d " " -f2)
