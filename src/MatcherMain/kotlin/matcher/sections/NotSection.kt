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
            val test = super.test(items)

            if (test) {
                println(test)
                println("about to return false")
                return false
            }
            // on not finding this succeed
            return true
        }
    }
}

val NotSection = NotSectionStatic()





