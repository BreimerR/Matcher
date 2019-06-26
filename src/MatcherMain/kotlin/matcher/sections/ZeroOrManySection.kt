package matcher.sections

import matcher.TestableClass
import matcher.items.ItemsClass

class ZeroOrManySectionStatic : RepetitiveSectionStatic() {

    fun invoke(vararg items: TestableClass, name: String?, maxCount: Int = this.maxCount): Class = Class(Section(*items), name, maxCount = maxCount)

    override fun invoke(vararg items: TestableClass, name: String?): Class = Class(Section(*items), name, maxCount = maxCount)

    fun invoke(item: TestableClass, name: String?, maxCount: Int = this.maxCount): Class = Class(item, name, maxCount = maxCount)

    override operator fun invoke(item: TestableClass, name: String?, minCount: Int, maxCount: Int): Class {
        return Class(item, name, maxCount)
    }

    override operator fun invoke(vararg item: TestableClass, name: String?, minCount: Int, maxCount: Int): Class {
        return Class(Section(*item), name, maxCount = maxCount)
    }


    open class Class(section: TestableClass, name: String?, override val maxCount: Int) :
            RepetitiveSectionStatic.Class(section, name, ZeroOrManySection.minCount, maxCount) {
        override val self = ZeroOrManySection

        override fun test(items: ItemsClass<*>): Boolean {
            val i = items.i

            if (!super.test(items)) items.i = i

            return true
        }
    }
}

val ZeroOrManySection = ZeroOrManySectionStatic()