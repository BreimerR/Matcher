package matcher.sections

import matcher.TestableClass

class AnySectionStatic : SectionStatic() {
    // any of the specified items just like the alternative basically
    // i.e [a-z] =  (a|b|c|d|e|f|g...)
    override operator fun invoke(vararg item: TestableClass, name: String?) = AnySectionClass(*item, name = name)
}


class AnySectionClass(vararg item: TestableClass, name: String?) : SectionClass(*item, name = name) {


}