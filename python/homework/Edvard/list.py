#!/usr/bin/bash
str1 = ['zero', 'one', 'two', 'three']
str2 = [0, 1, 2, 3]
# avelacnenq verjic 'four'
str1.append('four')
print str1
#avelacnenq erord dirqic ...
str1.insert(3, '2.5')
print str1
#avelacnenq str2 list@...
str1.extend(str2)
print str1
#tpenq trvac('two') elementi index@
b = str1.index('two')
print b
#jnjel trvac element@
str1.remove('2.5')
print str1
#dasavorel @st achman ev aybenakan kargov
str1.sort()
print str1
#shrjel dasavorvacutyun@
str1.reverse()
print str1
#jnjel arajin element@
str1.pop(1)
print str1
