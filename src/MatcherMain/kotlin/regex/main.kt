package regex

import matcher.sections.RepetitiveSection
import matcher.sections.Section


fun main() {

    // regex start
    val reg = Regex(Section(Item('n'), Item('a'), Item('m'), Item('e'), name = "username"), flags = "g")

    print(reg test Items("n"))
}
