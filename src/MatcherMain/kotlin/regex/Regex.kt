package regex

import libs.text.each
import matcher.MatcherClass
import matcher.MatcherStatic
import matcher.TestableClass
import matcher.sections.Section
import libs.collections.array.each
import matcher.sections.SectionClass


infix fun Char.Is(char: Char): Boolean {
    return this == char
}

class RegexClass(vararg items: TestableClass, flags: String = "g") : MatcherClass<MatcherStatic>() {
    override val sections = items

    infix fun test(case: String): Boolean {
        // perform a breaker task
        // breaks the items into relatable items that can be used in a logical test case
        return false
    }


    override val self = Regex

    /*constructor(pattern: String) : this(*Regex.prepItems(pattern))*/

    infix fun match(case: String): MatchedClass = Matched()

    /*fun addSection(vararg item: SectionClass<ItemClass>) = Unit*/

}


class RegexStatic : MatcherStatic() {
    // TODO @pattern = "email=([a-zA-Z0-9_]+)(@)([a-zA-Z0-9]*)(\.)(com|org|[a-zA-Z]{3})"
    operator fun invoke(patternString: String): RegexClass {
        // TODO parse expression string

        return RegexClass()
    }


    fun parsePatternString(string: String) {
        // EXAMPLE :
        // ^<name>abc.*[c-d]!(aaah)(simple|name)\$$
        var char: Char? = null


        string.each(true) { it: Char, index: Int ->
            var i = index

            if (it == '^') {

            }



            i + 1
        }
    }

    operator fun invoke(vararg sections: TestableClass, flags: String = "g"): RegexClass = RegexClass(*sections, flags = flags)

    /*operator fun invoke(patternString: String, flags: String = "g"): RegexClass {

        // TODO Regex takes in a compiled pattern
        // generate pattern from parsing a string
        // The generated pattern class is what is used inside the RegexClass
        @Suppress("UnnecessaryVariable") val reg = RegexClass(patternString)

        // Process flags

        // Add flags to the regular expression parser

        return reg

    }*/
    // should return a section with what defined items
    /**
     * i.e if we have a*
     * this should return a repetitive section with the item a
     * */
    /*fun prepItems(items: String): Array<SectionClass<ItemClass>> {
        return arrayOf(Section(Item('e')))
    }*/


    /**TODO
     *
     * decide on a return type for the parse section
     * */

    fun parseFlags(flags: String) {

    }
}


val Regex = RegexStatic()

