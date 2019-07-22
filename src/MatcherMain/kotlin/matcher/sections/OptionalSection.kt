package matcher.sections

import matcher.TestableStatic
import matcher.items.ItemsStatic.Class as ItemsClass

abstract class OptionalSectionStatic<T> : SectionStatic<T>() {
    abstract override operator fun invoke(vararg items: TestableStatic.Class<T>, name: String?): Class<T>
    /*{
        return Class(Section(*items), name = name)
    }*/

    abstract class Class<T>(section: TestableStatic.Class<T>, name: String? = null, self: OptionalSectionStatic<T>) :
            SectionStatic.Class<T>(section, name = name, self = self) {
        override fun test(items: ItemsClass<T>): Boolean {
            val i = items.i

            if (!super.test(items)) items.i = i

            return true
        }
    }
}