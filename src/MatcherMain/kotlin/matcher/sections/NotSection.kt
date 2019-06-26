package matcher.sections


import matcher.TestableClass
import matcher.items.ItemsClass

class NotSectionStatic : SectionStatic() {
    override operator fun invoke(vararg items: TestableClass, name: String?): Class {
        return Class(*items, name = name)
    }

    class Class(vararg items: TestableClass, val name: String? = null) : SectionStatic.SectionClass(*items) {
        override val self = AlternativeSection

        override fun test(items: ItemsClass<*>): Boolean {
            // on finding this fail
            if (super.test(items)) return false
            // on not finding this succeed
            return true
        }
    }
}

val NotSection = NotSectionStatic()





