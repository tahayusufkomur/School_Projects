import errno
import glob
from os.path import join
from typing import List
from jpype import JClass, getDefaultJVMPath, shutdownJVM, startJVM, java
import Generator as gnr
from Word import Word

path = '1150haber/*.txt'
files = glob.glob(path)

if __name__ == '__main__':

    ZEMBEREK_PATH: str = join("bin/zemberek-full.jar")

    startJVM(
        getDefaultJVMPath(),
        '-ea',
        f'-Djava.class.path={ZEMBEREK_PATH}',
        convertStrings=False
    )

    TurkishSentenceExtractor: JClass = JClass(
        'zemberek.tokenization.TurkishSentenceExtractor'
    )

    extractor: TurkishSentenceExtractor = TurkishSentenceExtractor.DEFAULT

    TurkishMorphology: JClass = JClass('zemberek.morphology.TurkishMorphology')

    morphology: TurkishMorphology = TurkishMorphology.createWithDefaults()

Nouns = []
Adjectives = []
Verbs = []
Conjunctions = []
PostPositives = []
all_words = []

"""""
We reading all files here and distributing them to 5 different lists depends on their pos'es
"""""
for name in files:
    try:
        with open(name) as f:
            sentences = extractor.fromParagraph(f.read())
            for i, word in enumerate(sentences):
                x = f'{word}'
                sentence: str = x
                analysis: java.util.ArrayList = (
                    morphology.analyzeAndDisambiguate(sentence).bestAnalysis()
                )
                pos: List[str] = []

                for i, analysis in enumerate(analysis, start=1):
                    if f'{analysis.getPos()}' != "Punctuation":
                        x = f'{analysis}'
                        p = x.find(':')  # cleaning data
                        x = x[1:p]  # cleaning data
                        all_words.append(Word(x, gnr.get_weight(x), f'{analysis.getPos()}'))  # all_words
                        if f'{analysis.getPos()}' == 'Noun':
                            Nouns.append(Word(x, gnr.get_weight(x), f'{analysis.getPos()}'))  # Nouns
                        if f'{analysis.getPos()}' == 'Verb':
                            Verbs.append(Word(x, gnr.get_weight(x), f'{analysis.getPos()}'))  # Verbs
                        if f'{analysis.getPos()}' == 'Conjunction':
                            Conjunctions.append(Word(x, gnr.get_weight(x), f'{analysis.getPos()}'))  # Conjunctions
                        if f'{analysis.getPos()}' == 'PostPositive':
                            PostPositives.append(Word(x, gnr.get_weight(x), f'{analysis.getPos()}'))  # PostPositives
                        if f'{analysis.getPos()}' == 'Adjective':
                            Adjectives.append(Word(x, gnr.get_weight(x), f'{analysis.getPos()}'))  # Adjectives
                        else:
                            continue
    except IOError as exc:
        if exc.errno != errno.EISDIR:
            raise

w_sentences = gnr.generate_sentences(300, 1000, Nouns, Verbs, Adjectives, Conjunctions, PostPositives)
for i in w_sentences:
    print('weight -> ', i.lentgth_of_sentence(), ' ', end='')
    w = i.words
    for t in w:
        print(t.name, ' ', end='')
    print('')

w_words = gnr.generate_random_weighted_words(all_words, 25, 100)
for i in w_words:
    print(i.name, ' ', i.weight)

shutdownJVM()
