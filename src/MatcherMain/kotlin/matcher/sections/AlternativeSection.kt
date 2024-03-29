package matcher.sections


import matcher.TestableClass
import matcher.items.ItemsClass

class AlternativeSectionStatic : SectionStatic() {
    override operator fun invoke(vararg items: TestableClass, name: String?): AlternativeSectionClass {
        return AlternativeSectionClass(*items, name = name)
    }
}

val AlternativeSection = AlternativeSectionStatic()


class AlternativeSectionClass(vararg items: TestableClass, val name: String? = null) : SectionStatic.SectionClass(*items) {
    override val self = AlternativeSection

    // we dont want to find the first match but the best case match
    override infix fun test(items: ItemsClass<*>): Boolean {
        return test(items, sections)
    }

    private fun test(items: ItemsClass<*>, sections: Array<out TestableClass>): Boolean {
        var truths = arrayOf<TestableClass>()

        val i = items.i
        var tI = i
        var w = 0

        for (section in sections) {

            if (section test items) {
                truths += section
                if (w < items.i) w = items.i
            }

            items.i = i
        }


        return when {
            w == 0 -> false
            w > 0 -> {
                items.i = w
                true
            }
            else -> false
        }
    }


}


