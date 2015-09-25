__author__ = 'jizhen'

import os

def test_print():
    print('test', 5, [1,2,3])
    print()
    print('a','b','c',sep=':')
    print('a','b','c',sep=':',end='\n\n')
    f = open('data.txt', 'w+') #r, w, a, r+ (b, t)
    print(f.name, type(f))
    print('a','b','c',sep='\n',end='   <---', file=f, flush=True)
    f.seek(0)
    for line in f:
        print(line, sep='', end='')
    f.close()
    os.remove(f.name)

def test_input():
    reply = input('Enter × and y, separated by spaces: ')
    pieces = reply.split( ) # returns a list of strings, as separated by spaces
    x = float(pieces[0])
    y = float(pieces[1])
    print(x, y, sep=', ')

    age = int(input('Enter your age in years: '))
    max_heart_rate = 206.9 - (0.67 * age) # as per Med Sci Sports Exerc.
    target = 0.65 * max_heart_rate
    print('Your target fat-burning heart rate is', target)

if __name__ == "__main__":
    test_print()
    test_input()