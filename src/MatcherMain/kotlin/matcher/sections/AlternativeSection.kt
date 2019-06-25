package matcher.sections

import matcher.TestableClass

/**@description
 * This class offers the capability to test cases
 * for existence of either case 1,2 ......n where n is a finite
 * */

class AlternativeSectionStatic : SectionStatic() {
    override operator fun invoke(vararg item: TestableClass, name: String?): AlternativeSectionClass = AlternativeSectionClass(*item, name = name)
}

class AlternativeSectionClass(vararg sectionItem: TestableClass, name: String? = null) : SectionClass(*sectionItem, name = name) {

}

val AlternativeSection = AlternativeSectionStatic()