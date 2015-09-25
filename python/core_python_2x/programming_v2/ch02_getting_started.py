
__author__ = 'jizhen'

## do this in a interactive shell
print "%s is number %d!" % ("Python", 1)

myString = 'Hello World!'
print myString  # call str()    Hello World!
myString        # call repr()  'Hello World!'
#_               # last evaluated expression

5.9/2 ==2.0 # False
5.9//2==2.0 # True

# >>> n=1
# >>> --n
# 1
# >>> n=-1
# >>> ++n
# -1
# >>>

# • int (signed integers)
# • long (long integers)    like BigInteger in Java In Python 3, merged to single integer type, no L needed
# • bool (Boolean values)
# • float (floating point real numbers)
# • complex (complex numbers)


## decimal

# >>> from decimal import *
# >>> getcontext()
# Context(prec=28, rounding=ROUND_HALF_EVEN, Emin=-999999999, Emax=999999999, capitals=1, flags=[], traps=[DivisionByZero, InvalidOperation, Overflow])
# getcontext().prec = 7
# Decimal(1) / Decimal(7)

# more: https://docs.python.org/2/library/decimal.html
