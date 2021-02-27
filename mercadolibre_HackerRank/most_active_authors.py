#!/usr/bin/env python3

import random
import requests

def getUsernames(threshold):
  """The function is expected to return a STRING_ARRAY.
     The function accepts INTEGER threshold as parameter.
  """
  users = []
  for page in range(1, 3):
    response = requests.get('https://jsonmock.hackerrank.com/api/article_users?page=' + str(page))
    response.json()["data"]
    for i in response.json()["data"]:
      if i["submitted"] > threshold:
        users.append(i["username"])

  return users

  
  

if __name__ == "__main__":
  threshold = 10
  users = getUsernames(threshold)
  print(users)


  