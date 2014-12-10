#!/usr/bin/pythone
print "---------------------------1--------------------------- "
print "**insert | 3 elem 'ITC', 'Vanadzor', '2014' | in the list with function- | list = ['ITC', 'Vanadzor', '2014'] |**"
list = ['ITC', 'Vanadzor', '2014']
print list
print "---------------------------2--------------------------- "
print "**insert elem | 'Hello' | at index 0 of the list with function- | list.insert(0, 'Hello') |**"
list.insert(0, 'Hello')        
print list
print "---------------------------3---------------------------  "
print "**append elem | 'good' | at end of the list with function- | list.append('good') |**"
list.append('good')         
print list
print "---------------------------4--------------------------- "
print "**add list of elems | 'training' & 'everyone' | at end of the list with function- | list.extend(['training', 'everyone']) |**"
list.extend(['training', 'everyone'])
print list
print "---------------------------5--------------------------- "
print "**show index of elem | 'Vanadzor'| from the list with function- | print list.index('Vanadzor') |**"
print list.index('Vanadzor')
print "---------------------------6--------------------------- "
print "**search & remove elem | '2014' | from the list with function- | list.remove('2014') |**"
list.remove('2014')
print list
print "---------------------------7--------------------------- "
print "**sort elems in ascending order in the list with function- | list.sort() |**"
list.sort()
print list
print "---------------------------8--------------------------- "
print "**revers elems in the list with function- | list.reverse() |**"
list.reverse();
print list
print "---------------------------9--------------------------- "
print "**removes and returns elem in the list with function- | list.pop(0) |**"
print list.pop(0)
