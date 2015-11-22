__author__ = 'jizhen'

temp = """
def get_%s(data): return data[%s:%s+%s]
"""

def foo(n,o,l): exec temp % (n,o,o,l) in globals()

print foo('a',4,4)

f = open('c:/1.txt', 'raw')