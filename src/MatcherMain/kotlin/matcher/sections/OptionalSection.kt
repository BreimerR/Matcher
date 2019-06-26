package matcher.sections

import matcher.TestableClass
import matcher.items.ItemsClass

class OptionalSectionStatic : SectionStatic() {
    override operator fun invoke(vararg items: TestableClass, name: String?): Class {
        return Class(Section(*items), name = name)
    }

    class Class(section: TestableClass, name: String? = null) : SectionStatic.SectionClass(section, name = name) {
        override fun test(items: ItemsClass<*>): Boolean {
            val i = items.i

            if (!super.test(items)) items.i = i

            return true
        }
    }


}

val OptionalSection = OptionalSectionStatic()