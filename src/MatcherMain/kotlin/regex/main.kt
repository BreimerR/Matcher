package regex

import matcher.sections.*
import regex.items.Item
import regex.items.Items

/*fun main() {
    val reg = Regex("^.*$")

    print("Expect res should be true  res = ")
    println(reg test "breimer")
}*/


// test not section
fun main() {
    //
    val alter = AlternativeSection(Item('a'), Item('b'), Item('c'), Item('m'))
    val reg = Regex(NotSection(alter))

    print(reg test Items("m"))

}

