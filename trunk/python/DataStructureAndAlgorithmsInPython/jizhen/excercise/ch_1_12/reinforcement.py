__author__ = 'jizhen'

# Reinforcement
# R-1.1	Write a short Python function, is_multiple(n, m), that takes two integer values and
#       returns True if n is a multiple of m, that is, n = mi for some integer i, and False otherwise.
def is_multiple(n, m):
    return n % m == 0

# R-1.2	Write a short Python function, is_even(k), that takes an integer value and returns True if k is even,
# and False otherwise. However, your function cannot use the multiplication, modulo, or division operators.
def is_even(k):
    return int(str(k)[-1]) in (0,2,4,6,8)

# R-1.3	Write a short Python function, minmax(data), that takes a sequence of one or more numbers, and returns the
# smallest and largest numbers, in the form of a tuple of length two. Do not use the built-in functions min or max in
# implementing your solution.
def minmax(data):
    data.sort()
    return data[0], data[-1]

# R-1.4	Write a short Python function that takes a positive integer n and returns the sum of the squares of all the
# positive integers smaller than n.
def sum_squres(n):
    return sum([i*i for i in range(1,n)])

# R-1.5	Give a single command that computes the sum from Exercise R-1.4, relying on Python's comprehension syntax and
# the built-in sum function.

# R-1.6	Write a short Python function that takes a positive integer n and returns the sum of the squares of all the odd
# positive integers smaller than n.
def sum_odd_squres(n):
    return sum([i*i for i in range(1,n, 2)])

# R-1.7	Give a single command that computes the sum from Exercise R-1.6, relying on Python's comprehension syntax and
# the built-in sum function.

# R-1.8	Python allows negative integers to be used as indices into a sequence, such as a string. If string s has length n,
# and expression s[k] is used for index −n ≤ k < 0, what is the equivalent index j ≥ 0 such that s[j] references the
# same element?
def neg_pos_inx(seq, k, j):
    return seq[k] == seq[j]

# R-1.9	What parameters should be sent to the range constructor, to produce a range with values 50, 60, 70, 80?
def get_50_50_70_80():
    return list(range(50,90,10))

# R-1.10	What parameters should be sent to the range constructor, to produce a range with values
# 8, 6, 4, 2, 0, −2, −4, −6, −8?
print(list(range(8, -9, -2)))

# R-1.11	Demonstrate how to use Python's list comprehension syntax to produce the list
# [1, 2, 4, 8, 16, 32, 64, 128, 256].
print([2**i for i in range(0,9)])

# R-1.12	Python's random module includes a function choice(data) that returns a random element from a non-empty
# sequence. The random module includes a more basic function randrange, with parameterization similar to the built-in
# range function, that return a random choice from the given range. Using only the randrange function, implement your
# own version of the choice function.
def choice_by_randrange(seq):
    import random
    print(random.randrange(10))
    print(seq[random.randrange(len(seq))])


if __name__ == '__main__':
    print('9, 3: ', is_multiple(9,3))
    print('8, 3: ', is_multiple(8,3))
    print('2: ', is_even(2))
    print('127: ', is_even(127))
    print('[2.2,-9,17,3.3]: ', minmax([2.2,-9,17,3.3]))
    print('5: ', sum_squres(5))
    print('5: ', sum_odd_squres(5))
    print('-2, len(seq)-2: ', neg_pos_inx((1,2,3,4,5), -2, len((1,2,3,4,5))-2))
    print(get_50_50_70_80())
    choice_by_randrange([1,2,3,4,5,6,7,8,9,10])