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
    }
})
