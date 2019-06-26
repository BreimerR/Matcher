package regex

import matcher.sections.*
import regex.items.Item
import regex.items.Items

fun main() {
    val reg = Regex("^.*$")

    print("Expect res should be true  res = ")
    println(reg test "breimer")
}

