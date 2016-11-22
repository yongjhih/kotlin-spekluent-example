package spekluent;

import org.amshove.kluent.`should equal`
import org.jetbrains.spek.api.Spek

class MainSpec: Spek ({
    describe("Coleman–Liau index") {
        it("should be equal that result of wiki example") {
            Cli.compute(sentences = 5, letters = 639, words = 119) `should equal` 14.5f
        }
        it("should be equal that with default value") {
            Cli.compute(sentences = 5, letters = 639) `should equal` 20.3f
        }

        // TODO
        it("should be equal that sentences") {
            "Hi! How are you, Andrew?".sentences().size // `should equal`  1 + 1
        }
        // TODO
        it("should be equal that words") {
            "Hi! How are you, Andrew?".words().size // `should equal`  1 + 3 + 1
        }
        // TODO
        it("should be equal that letters") {
            "Hi! How are you, Andrew?".letters().size // `should equal`  2 + 3 + 3 + 3 + 6
        }
        // TODO
        it("should be equal that with default value") {
            "Hi! How are you, Andrew?".cli()
        }
        // TODO
        it ("should be equal that with abstract paper") {
            """
            |Existing computer programs that measure readability are based largely upon subroutines which estimate number of syllables,
            |usually by counting vowels.
            |The shortcoming in estimating syllables is that it necessitates keypunching the prose into the computer.
            |There is no need to estimate syllables since word length in letters is a better predictor of readability than word length in syllables.
            |Therefore,
            |a new readability formula was computed that has for its predictors letters per 100 words and sentences per 100 words.
            |Both predictors can be counted by an optical scanning device,
            |and thus the formula makes it economically feasible for an organization such as the U.S.
            |Office of Education to calibrate the readability of all textbooks for the public school system.
            """.cli() // `should equal` 20.3f
        }
    }
})
