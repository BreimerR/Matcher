package matcher.sections

import matcher.TestableClass


class ZeroOrManySectionStatic : RepetitiveSectionStatic() {

}


class ZeroOrManySectionClass<Item>(vararg item: TestableClass) : RepetitiveSectionClass(*item, minCount = 0F)