#!/bin/python3

import sys


def greenplum(arr, line):
  """function that checks series of events
  to be correct before processing them"""
  n = len(arr)
  n_max = max(arr)

  if n != n_max:
    print("FAILURE => RECEIVED: {}, EXPECTED: {}".format(n, n_max))
  else:
    count = 0
    flag = False
    for i in range(n):
      for event in arr:
        if i == event:
          count += 1
      if count > 1:
        print("FAILURE => WRONG INPUT (LINE {})".format(line))
        flag = True
      count = 0
    
    if flag == False:
      print("SUCCESS => RECEIVED: {}".format(n))

def arr_str_to_arr_int(arr):
  """function that casts from string to int an
  array of elements received through stdin"""
  list_of_lists = []
  for i in arr:
    list_of_lists.append(i.split(" "))

  list2 = []
  count_line = 1
  for i in list_of_lists:
    count_line += 1
    try:
      list2.append(list(map(int, i)))
    except:
      print("FAILURE => WRONG INPUT (LINE {})".format(count_line))

  return list2


if __name__ == "__main__":
  number = input()
  try:
    N = int(number)
    arr = []
    for i in range (0, N):
      arr.append(input())
    list_of_lists = arr_str_to_arr_int(arr)
    
    count_line = 1
    for element in list_of_lists:
      count_line += 1
      greenplum(element, count_line)
  except:
    print("FAILURE => WRONG INPUT (LINE 1)")
