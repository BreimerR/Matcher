package regex

import matcher.sections.*
import regex.items.Item
import regex.items.Items
import kotlin.math.min


fun main() {
    println("test url or many expect true")
    val http = Section(Item('h'), Item('t'), Item('t'), Item('p'), Item(':'), Item('/'), Item('/'))
    val ww = RepetitiveSection(Item('w'), maxCount = 3, minCount = 3)
    val dot = Item('.')
    val www = OptionalSection(ww, dot)
    val a_z = arrayOf(Item('a'), Item('b'), Item('c'), Item('d'), Item('e'), Item('f'), Item('g'), Item('h'), Item('i'), Item('j'), Item('k'), Item('l'), Item('m'), Item('n'), Item('o'), Item('p'), Item('q'), Item('r'), Item('s'), Item('t'), Item('u'), Item('v'), Item('w'), Item('x'), Item('y'), Item('z'))
    val domain = Section(www, RepetitiveSection(AlternativeSection(*a_z)), Item('.'), RepetitiveSection(AlternativeSection(*a_z), maxCount = 3))
    val url = Regex(http, domain)

    println("Expect true")
    println(url test Items(readLine() as String))
}

