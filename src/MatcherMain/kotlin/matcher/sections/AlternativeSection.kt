package matcher.sections


import matcher.TestableClass
import matcher.items.ItemsClass

class AlternativeSectionStatic : SectionStatic() {
    override operator fun invoke(vararg items: TestableClass, name: String?): Class {
        return Class(*items, name = name)
    }


    class Class(vararg items: TestableClass, val name: String? = null) : SectionStatic.SectionClass(*items) {
        override val self = AlternativeSection

        // we dont want to find the first match but the best case match
        override infix fun test(items: ItemsClass<*>): Boolean {
            return test(items, sections)
        }

        private fun test(items: ItemsClass<*>, sections: Array<out TestableClass>): Boolean {
            val i = items.i

            var w = 0

            var fI = i

            for (section in sections) {
                val test = section test items
                fI = items.i
                if (test) {
                    if (w < items.i) w = items.i
                }

                items.i = i
            }


            return when {
                w == 0 -> {
                    items.i = fI
                    false
                }
                w > 0 -> {
                    items.i = w
                    true
                }
                else -> false
            }
        }


    }
}

val AlternativeSection = AlternativeSectionStatic()





