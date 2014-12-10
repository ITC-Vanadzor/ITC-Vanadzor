#!/usr/bin/python

My_list = ['vahan', 'saqo', 'edvard', 'hrach'];
list_2 = ['aaa', 'sss', 13251];
print My_list;
My_list.append('movses');
print "Appending movses"
print "Updated List: ", My_list;
My_list.insert(3, 'karen')
print My_list;
print "extend My_list and list_2";
My_list.extend(list_2);
print My_list;
print "Index for saqo: ", My_list.index('saqo');
print "Index for sss: ", My_list.index('sss');
My_list.remove('sss')
print "Removing sss from list...", My_list;
My_list.sort()
print "Sorting my list...", My_list;
My_list.reverse();
print "Reversing my list ...", My_list;
print "using pop: ", My_list.pop();

