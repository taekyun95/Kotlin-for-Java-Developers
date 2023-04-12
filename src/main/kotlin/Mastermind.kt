fun mastermind(str1: String, str2: String) {
    var letters = 0
    var pos = 0

    val str1Map = mutableMapOf<Char, Int>()
    val str2Map = mutableMapOf<Char, Int>()

    for (i in str1.indices) {
        if (str1[i] == str2[i]) {
            pos++
        } else {
            str1Map[str1[i]] = str1Map.getOrDefault(str1[i], 0) + 1
            str2Map[str2[i]] = str2Map.getOrDefault(str2[i], 0) + 1
        }
    }
    for (entry in str1Map) {
        letters += minOf(entry.value, str2Map.getOrDefault(entry.key, 0))
    }

    print("pos: ${pos}, letters: ${letters}")
}

fun main() {
    val code = "ABCDEF"
    val guess = "AFECDB"
    mastermind(code, guess)
    evaluateGuess(code, guess)
}

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {

    val rightPositions = secret.zip(guess).count { (a, b) -> a == b }

    val commonLetters = "ABCDEF".sumOf { ch ->
        minOf(secret.count { c -> c == ch }, guess.count { c -> c == ch })
    }
    return Evaluation(rightPositions, commonLetters - rightPositions)
}