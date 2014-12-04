#!/bin/bash
begin=$(grep "[0-2][0-9]:[0-5][0-9]:[0-5][0-9]" < log | head -n 1 | sed 's/[A-Z a-z ,]//g')
end=$(grep "[0-2][0-9]:[0-5][0-9]:[0-5][0-9]" < log | tail -n 1 | sed 's/[A-Z a-z ,]//g')
name=$begin"_"$end".tar.gz"
tar cvzf name.tar.gz ./log
mv name.tar.gz $name
