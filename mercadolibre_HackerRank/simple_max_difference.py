#!/usr/bin/env python3


def maxDifference(px):
  """Complete the 'maxDifference' function below.
    The function is expected to return an INTEGER.
    The function accepts INTEGER_ARRAY px as parameter.
  """
  max_num = px[0]
  min_num = px[0]
  for i in range(0, len(px) - 1):
    max_num = max(max_num, px[i])
    min_num = min(min_num, px[i])
  return (max_num - min_num)
  

if __name__ == "__main__":
  px = [2, 3, 10, 2, 4, 8, 1]
  max_dif = maxDifference(px)
  print(max_dif)


  