package matcher.sections

import matcher.TestableClass

open class RepetitiveBySectionStatic : SectionStatic() {
}

open class RepetitiveBySectionClass(vararg sectionItem: TestableClass) : SectionClass(*sectionItem) {
    /**TODO
     *
     * sItem = Section(sectionItem)
     * section = [
     *      sItem,
     *      ZeroOrMany(
     *          repeater,
     *          sItem
     *      )
     * ]
     * */
}

val RepetitiveBySection = RepetitiveBySectionStatic()