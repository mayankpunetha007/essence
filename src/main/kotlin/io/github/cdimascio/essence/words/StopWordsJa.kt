package io.github.cdimascio.essence.words

import org.atilika.kuromoji.Tokenizer


class StopWordsJa(private val stopWords: List<String>) : StopWords(stopWords) {

    override fun statistics(content: String): StopWordsStatistics {
        val tokenizer: Tokenizer = Tokenizer.builder().build()
        val data = tokenizer.tokenize(content);
        val candidates = data.map { m-> m.baseForm }
        val stopWordsInContent = candidates.filter { word -> stopWords.contains(word) }
        return StopWordsStatistics(
            wordCount = candidates.size,
            stopWords = stopWordsInContent
        )
    }
}
