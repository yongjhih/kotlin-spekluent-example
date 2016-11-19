package spekluent;

// ref. https://en.wikipedia.org/wiki/Coleman%E2%80%93Liau_index
class Cli {
    companion object {
        val L = 0.0588
        val S = 0.296
        val C = 15.8

        fun compute(letters: Int = 0, sentences: Int = 0, words: Int = 100) =
            "%.1f".format((L * (letters * (100f / words))) - (S * (sentences * (100f / words))) - C).toFloat()
    }
}

