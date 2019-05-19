package regex

import matcher.*

class RegexClass(vararg items: ItemClass) : MatcherClass<MatcherStatic>() {
    override val self = Regex

    constructor(pattern: String) : this(*Regex.prepItems(pattern))

}


class RegexStatic : MatcherStatic() {
    // TODO @pattern = "email=([a-zA-Z0-9_]+)(@)([a-zA-Z0-9]*)(\.)(com|org|[a-zA-Z]{3})"
    operator fun invoke(pattern: String): RegexClass {
        return RegexClass(pattern)
    }

    fun prepItems(items: String): Array<ItemClass> {
        return arrayOf(Item())
    }
}


val Regex = RegexStatic()


fun main() {
    val regex = Regex("email=([a-zA-Z0-9_]+)(@)([a-zA-Z0-9]*)\\.(com|org|[a-zA-Z]{3})")
}
