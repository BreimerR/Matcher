package matcher.sections

import matcher.TestableClass


/** @Class_Description
 * This is for cases where we have a......z but we want to get all alphabets that are not z
 * anything else but the provided item
 * */
class NotSectionStatic : SectionStatic()

class NotSectionCalss(val sectionItem: TestableClass) : SectionClass(sectionItem)

val NotSection = NotSectionStatic()