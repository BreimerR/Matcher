package regex

import matcher.sections.AlternativeSection
import matcher.sections.Section
import platform.posix.read
import regex.items.Item
import regex.items.Items
import kotlin.text.Regex

fun main() {

    // regex start
    val a = Section(Item('n'), Item('a'), Item('m'), Item('e'), name = "username")
    val b = Section(Item('n'), Item('a'), Item('m'), Item('e'), Item('s'))
    val reg = Regex(AlternativeSection(a, b), flags = "g")

    print(reg test Items(readLine() as String))
}
