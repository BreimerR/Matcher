package matcher.sections

import matcher.TestableClass
import matcher.items.ItemsClass

open class RepetitiveSectionStatic(open val minCount: Int = 0, open val maxCount: Int = 10000000) : SectionStatic() {
    open operator fun invoke(item: TestableClass, name: String? = null, minCount: Int = 0, maxCount: Int = this.maxCount): Class {
        return Class(item, name, minCount, maxCount)
    }

    open operator fun invoke(vararg item: TestableClass, name: String? = null, minCount: Int = this.minCount, maxCount: Int = this.maxCount): Class {
        return Class(super.invoke(*item, name = null), name, minCount = minCount, maxCount = maxCount)
    }

    override operator fun invoke(vararg items: TestableClass, name: String?): Class {
        return Class(super.invoke(*items, name = null), name = name, minCount = minCount, maxCount = maxCount)
    }

    open class Class(section: TestableClass, name: String?, open val minCount: Int, open val maxCount: Int) : SectionClass(section, name = name) {
        override val self = RepetitiveSection

        override infix fun test(items: ItemsClass<*>): Boolean {
            var count = 0

            do {
                val test = super.test(items)
                count += 1
            } while (count < maxCount && test)


            if (count < minCount) return false

            return true
        }

    }

}

/*
AnySection.kt
GroupedSection.kt
NotSection.kt

*/


val RepetitiveSection = RepetitiveSectionStatic()