package spekluent;

// ref. https://en.wikipedia.org/wiki/Coleman%E2%80%93Liau_index
class Cli {
    companion object {
        val L = 0.0588
        val S = 0.296
        val C = 15.8

        inline fun compute(letters: Int = 0, sentences: Int = 0, words: Int = 100) =
            computeCoerced(letters = letters.coerceAtLeast(0), sentences = sentences.coerceAtLeast(0), words = words.coerceAtLeast(0))

        fun computeCoerced(letters: Int = 0, sentences: Int = 0, words: Int = 100) =
            "%.1f".format((L * (letters * (100f / words))) - (S * (sentences * (100f / words))) - C).toFloat()
    }
}

// TODO
fun String.sentences(): Array<String> {
    // match '[\.!?]\+'
    println(""".""".toRegex().matchEntire(this)?.groups?.size)
    println("""[a-zA-Z]\\+""".toRegex().matchEntire(this)?.groups?.size)
    println("""\\w""".toRegex().matchEntire(this)?.groups?.size)
    println("""\\\w""".toRegex().matchEntire(this)?.groups?.size)
    return """[\\.!?]\\+""".toRegex().matchEntire(this)?.groups?.map { it?.value ?: "" } ?.toTypedArray() ?: emptyArray()
}

// TODO
fun String.words(): Array<String> {
    // match '\w\+'
    println("""\\w""".toRegex().matchEntire(this)?.groups?.size)
    return """\\w\\+""".toRegex().matchEntire(this)?.groups?.map { it?.value ?: "" } ?.toTypedArray() ?: emptyArray()
}

// TODO
fun String.letters(): Array<String> {
    // match '\w'
    println("""\\w""".toRegex().matchEntire(this)?.groups?.size)
    return """\\w""".toRegex().matchEntire(this)?.groups?.map { it?.value ?: "" } ?.toTypedArray() ?: emptyArray()
}

fun String.cli() = Cli.compute(letters = this.letters().size, sentences = this.sentences().size, words = this.words().size)
