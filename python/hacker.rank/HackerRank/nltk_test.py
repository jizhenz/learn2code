__author__ = 'jizhen'

import nltk
import json

def gen_pos():
    line = 'How old are you?'
    line = line.strip()
    tokens = nltk.word_tokenize(line)
    print tokens
    tagged = nltk.pos_tag(tokens)
    print tagged
    tagged_json = json.dumps(tagged)
    print tagged_json
    tagged = json.loads(tagged_json)
    words = []
    poss = []
    for word in tagged:
        words.append(word[0])
        poss.append(word[1][0])
    print words
    print poss
#nltk.download()
gen_pos()
