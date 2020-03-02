"""
Zemberek: Turkish Tokenization Example
Java Code Example: https://bit.ly/2PsLOkj
"""
import random as random
from soupsieve.util import lower
from Sentence import Sentence

def average_weight_calculator(objects):
    v_weight = 0
    v_count = 0
    n_weight = 0
    n_count = 0
    adj_weight = 0
    adj_count = 0
    conj_weight = 0
    conj_count = 0
    post_p_weight = 0
    post_p_count = 0

    for obj in objects:
        if (obj.tag == 'Verb'):
            v_weight += obj.weight
            v_count += 1
        elif (obj.tag == 'Noun'):
            n_weight += obj.weight
            n_count += 1
        elif (obj.tag == 'Adjective'):
            adj_weight += obj.weight
            adj_count += 1
        elif (obj.tag == 'Conjunction'):
            conj_weight += obj.weight
            conj_count += 1
        elif (obj.tag == 'PostPositive'):
            post_p_weight += obj.weight
            post_p_count += 1
        else:
            continue

    print('Average weight of: \n Verbs = ', v_weight / v_count, '\n Nouns = ', n_weight / n_count,
          '\n Adjectives = ', adj_weight / adj_count, '\n Conjunctions = ', conj_weight / conj_count,
          '\n PostPositives = ', post_p_weight / post_p_count)


def get_weight(string):
    weight = 0
    letterValue = {'a': 1, 'b': 2, 'c': 3, 'ç': 4, 'd': 5, 'e': 6, 'f': 7, 'g': 8, 'ğ': 9, 'h': 10, 'ı': 11,
                   'i': 12, 'j': 13, 'k': 14, 'l': 15, 'm': 16, 'n': 17, 'o': 18, 'ö': 19, 'p': 20, 'r': 21,
                   's': 22, 'ş': 23, 't': 24, 'u': 25, 'ü': 26, 'v': 27, 'y': 28, 'z': 29}
    lowerString = lower(string)
    for i in lowerString:
        if i in letterValue:
            weight += letterValue[i]
    return weight


def generate_weighted_words(word_list, weight, count):
    ct = 0
    word_object = []
    for i in word_list:
        matching = [s for s in word_object if i.name in s]
        if (i.weight == weight):
            if (matching):
                continue
            word_object.append(i)
            ct += 1
        if (count == ct):
            break
    return word_object
def generate_random_weighted_words(word_list, weight, count):
    ct = 0
    word_object = []
    t = 0
    while t < count:
        ct += 1
        i = random.choice(word_list)
        matching = [s for s in word_object if i.name in s.name]
        if (i.weight == weight):
            if (matching):
                continue
            word_object.append(i)
            t += 1
        if t == count:
            break
        if ct == 10000:
            break
    return word_object

def choose_word_in_range(down, upper, list):
    counter = 0
    noun = random.choice(list)
    while True:
        counter += 1
        noun = random.choice(list)
        if (down < noun.weight < upper):
            break
        if (counter > 5000):
            break
    return noun


def generate_sentences(weight, iteration_count, noun_l, verb_l, adj_l, conj_l, p_pones_l):
    sentences = []
    strings = []
    for i in range(0, iteration_count):
        if (weight < 151):
            str  = ""
            limit = weight
            word = []
            s = Sentence(0, 0, word)
            x = weight / 5
            y = weight / 1.5
            noun = choose_word_in_range(x, y, noun_l)
            limit -= noun.weight
            verb = choose_word_in_range(x, y, verb_l)
            limit -= verb.weight
            conj = choose_word_in_range(limit - 1, limit + 1, conj_l)
            s.words.append(noun)
            s.words.append(conj)
            s.words.append(verb)
            # To check if we already added it
            str = noun.name
            str+= conj.name
            str+= verb.name


            if (s.lentgth_of_sentence() == weight):
                matching = [s for s in strings if str in s]
                if(matching):
                    continue
                sentences.append(s)
                strings.append(str)

        if (150 < weight < 251):
            limit = weight
            word = []
            s = Sentence(0, 0, word)
            x = weight / 5
            y = weight / 2
            noun = choose_word_in_range(x, y, noun_l)
            limit -= noun.weight
            verb = choose_word_in_range(x, y, verb_l)
            limit -= verb.weight

            s.words.append(noun)
            while True:
                if (limit >= 80):
                    x = choose_word_in_range(30, 50, adj_l)
                    limit -= x.weight
                    s.words.append(x)
                else:
                    break
            if (limit > 10):
                p_pone = choose_word_in_range(limit - 1, limit + 1, conj_l)
                s.words.append(p_pone)
            s.words.append(verb)

            if (s.lentgth_of_sentence() == weight):
                sentences.append(s)

        if (250 < weight):
            limit = weight
            word = []
            s = Sentence(0, 0, word)
            x = weight / 25
            y = weight / 5
            noun = choose_word_in_range(x, y, noun_l)
            limit -= noun.weight
            verb = choose_word_in_range(x, y, verb_l)
            limit -= verb.weight

            s.words.append(noun)
            while True:
                if (limit >= 80):
                    x = choose_word_in_range(30, 50, noun_l)
                    limit -= x.weight
                    s.words.append(x)
                else:
                    break
            if (limit > 10):
                conj = choose_word_in_range(limit - 1, limit + 1, noun_l)
                s.words.append(conj)
            s.words.append(verb)
            if (s.lentgth_of_sentence() == weight):
                sentences.append(s)

    return sentences
