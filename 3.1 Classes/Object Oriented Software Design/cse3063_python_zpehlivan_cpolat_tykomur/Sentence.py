class Sentence:
    def __init__(self, positivity, negativity, words):
        self.positivitiy = positivity
        self.negativity = negativity
        self.words = words

    def lentgth_of_sentence(self):
        len = 0
        for i in self.words:
            len+= i.weight
        return len

    def sentence_printer(self):
        print("")
        for i in self.words:
            print(i," ", end='')

