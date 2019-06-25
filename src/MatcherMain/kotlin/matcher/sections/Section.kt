package matcher.sections

/**TODO
 * define sections
 * one or many denoted by +
 * zero or many section *
 * alternative sections |
 * range section -  Item-Item this is dependant of the pattern class i.e regex a-z or 0-9 and other pattern matchers that
 * could be out there
 * repetitive section one or many should extend here and also zero or many should extend from here
 * */

import matcher.TestableClass
import matcher.TestableStatic
import matcher.items.ItemClass
import matcher.items.ItemsClass
import matcher.items.ItemsStatic

open class SectionStatic : TestableStatic() {
    open operator fun invoke(vararg items: TestableClass, name: String? = null): TestableClass {
        return SectionClass(*items, name = name)
    }
}

/**@description
 * @param sectionItems  this are the haystacks that want to get from an item order
 * @param name:String? = null this is the name that we can use to infer a specific
 * section of a pattern from the matched items
 *
 * */
open class SectionClass(vararg sectionItems: TestableClass, name: String? = null) : TestableClass() {

    protected val sections = sectionItems

    override infix fun test(items: ItemsClass<*>): Boolean {
        for (section in sections) if (!(section test items)) return false
        return true
    }


    override val self = Section
}

val Section = SectionStatic()