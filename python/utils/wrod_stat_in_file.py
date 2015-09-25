__author__ = 'jizhen'

import mmap
from collections import Counter
import sys

def word_count(file_name):
    print(sys.getdefaultencoding())
    with open(file_name, "r+b") as f:
        # memory-map the file, size 0 means whole file
        mm = mmap.mmap(f.fileno(), 0)
        all_content = mm[:]
        all_content = all_content.decode('unicode_escape', 'ignore')
        wordcount = Counter(all_content.split())

        for item in wordcount.items():
            print("{}\t{}".format(*item))
        print(len(wordcount))

        # close the map
        mm.close()

def word_count_normal(file_name):
    with open(file_name, "r") as f:
        wordcount = Counter(f.read().split())

        for item in wordcount.items():
            print("{}\t{}".format(*item))
        print(len(wordcount))

if __name__ == "__main__":
    word_count('C:/Users/jizhen/Documents/_Jizhen/_Projects/R/ling/Coursera-SwiftKey/final/en_US/en_US.news.txt')