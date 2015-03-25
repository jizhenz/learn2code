
from time import time

def Timing(func):
    def inner(*args, **kwargs): #1
        now = time()
        results = func(*args, **kwargs) #2
        done = time()
        m_sec = (done-now)*1000
        return results, m_sec
    return inner