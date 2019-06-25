package matcher.sections

import matcher.TestableClass

class RepetitiveSectionStatic : SectionStatic() {
    override fun invoke(vararg items: TestableClass, name: String?): RepetitiveSectionClass {
        return RepetitiveSectionClass(*items, name = name)
    }
}


class RepetitiveSectionClass(vararg sections: TestableClass, name: String? = null) : SectionClass(*sections, name = name) {
    override val self = RepetitiveSection


}

val RepetitiveSection = RepetitiveSectionStatic()