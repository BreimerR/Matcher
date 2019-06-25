package matcher.sections

import matcher.TestableClass


class OneOrManySectionStatic : RepetitiveSectionStatic() {
    operator fun <Item : TestableClass> invoke(vararg item: Item): OneOrManySectionClass {
        return OneOrManySectionClass(*item)
    }
}

class OneOrManySectionClass(vararg sectionItems: TestableClass) : RepetitiveSectionClass(*sectionItems, minCount = 1F) {
    override val self = OneOrManySection
}

var OneOrManySection = OneOrManySectionStatic()