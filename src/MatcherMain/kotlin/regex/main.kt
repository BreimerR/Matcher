package regex

import regex.items.Item
import regex.items.Items
import regex.sections.*

fun main() {

    val alphabets = arrayOf(
            Item('a'),
            Item('b'),
            Item('c'),
            Item('d'),
            Item('e'),
            Item('f'),
            Item('g'),
            Item('h'),
            Item('i'),
            Item('j'),
            Item('k'),
            Item('l'),
            Item('m'),
            Item('n'),
            Item('o'),
            Item('p'),
            Item('q'),
            Item('r'),
            Item('s'),
            Item('t'),
            Item('u'),
            Item('v'),
            Item('w'),
            Item('x'),
            Item('y'),
            Item('z')
    )


    val reg = Regex(NotSection(*alphabets))

    print(reg test Items(readLine() as String))

}