package matcher.sections

import matcher.TestableClass

class OneOrManySectionStatic(minCount: Int = 1) : RepetitiveSectionStatic(minCount = minCount) {

    override fun invoke(vararg items: TestableClass, name: String?): Class = Class(Section(*items), name, maxCount = this.maxCount)

    fun invoke(item: TestableClass, name: String?, maxCount: Int = this.maxCount): Class = Class(item, name, maxCount = this.maxCount)


    open class Class(section: TestableClass, name: String?, override val maxCount: Int) :
            RepetitiveSectionStatic.Class(section, name, OneOrManySection.minCount, maxCount) {
        override val self = OneOrManySection
    }
}


val OneOrManySection = OneOrManySectionStatic()