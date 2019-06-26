package regex

import matcher.sections.RepetitiveBySection
import matcher.sections.RepetitiveSection
import matcher.sections.Section
import matcher.sections.ZeroOrManySection
import regex.items.Item
import regex.items.Items
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue


@Test
fun main() {
    val sec = Regex(Section(Item('m'), Item('e')))
    assertTrue(sec test Items("me"))

    val rep = Regex(RepetitiveSection(Item('m'), Item('e')))

    assertTrue(rep test Items("meme"))

    val repBy = Regex(RepetitiveBySection(Section(Item('m'), Item('e')), Item(',')))

    assertTrue(repBy test Items("me"))

    assertTrue(repBy test Items("me,me"))

    assertFalse(repBy test Items("me,us"))

    val zero = Regex(ZeroOrManySection(Item('m'), Item('e')))

    assertTrue(zero test Items(""))
    assertTrue(zero test Items("me"))
}
