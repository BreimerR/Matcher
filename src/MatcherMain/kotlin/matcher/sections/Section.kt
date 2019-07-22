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
import matcher.TestableStatic
import matcher.items.ItemClass
import matcher.items.ItemsStatic
import matcher.items.ItemsStatic.Class as ItemsClass


abstract class SectionStatic<T> : TestableStatic() {

    abstract operator fun invoke(vararg items: TestableStatic.Class<T>, name: String? = null): Class<T>

    abstract class Class<T>(vararg sectionItems: TestableStatic.Class<T>, open val name: String? = null, override val self: SectionStatic<T>) : TestableStatic.Class<T>() {

        lateinit var items: ItemsClass<T>

        var sI = 0

        var eI: Int? = null

        open var results = arrayOf<ItemClass<T>>()

        protected val sections = sectionItems

        override infix fun test(items: ItemsClass<T>): Boolean {
            this.items = items

            this.sI = items.i

            for (section in sections) {
                if (!test(section, items)) return false
            }

            this.eI = items.i

            return true
        }

        inline fun test(test: TestableStatic.Class<T>, case: ItemsStatic.Class<T>): Boolean {
            return test test case
        }
    }
}

/**@description
 * @param sectionItems  this are the haystacks that want to get from an item order
 * @param name:String? = null this is the name that we can use to infer a specific
 * section of a pattern from the matched items
 * */