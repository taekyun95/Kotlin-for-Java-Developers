package control

fun main() {
    testLoop()
    checkingIdentifier()

    val age = checkAge(-5)
    println("Age: $age")

}

fun testLoop() {
    val map = mapOf(
        1 to "one",
        2 to "two",
        3 to "three",
    )
    for ((key, value) in map) {
        println("$key = $value")
    }
    println()

    val list = listOf("a", "B", "C")
    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }
    println()

    for (c in "abc") print(c)
    println()
    for (c in '0'..'9') print(c)
    println()
    for (c in '0' until '9') print(c)
    println()
    for (c in 9 downTo 1 step 2) print(c)
}

fun checkingIdentifier() {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}

fun isValidIdentifier(s: String): Boolean {
    if (s.isBlank()) return false
    if (s[0] != '_' || s[0].isLetter() || s[0] in 'A'..'Z') return false
    for (c in s) {
        if (!c.isLetterOrDigit() && c != '_') return false
    }
    return true
}

fun checkAge(age: Int): Int {
    return if (age in 0..100) {
        age
    } else {
        throw IllegalArgumentException("Age must be between 0 and 100")
    }
}