package matcher.sections

import matcher.TestableClass
import platform.posix.INFINITY


open class RepetitiveSectionClass(vararg sectionItem: TestableClass, val minCount: Float = 0F, val maxCount: Float = INFINITY) : SectionClass(*sectionItem) {


}

open class RepetitiveSectionStatic : SectionStatic()

val RepetitiveSection = RepetitiveSectionStatic()