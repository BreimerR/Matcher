package matcher.sections

import matcher.TestableClass


class GroupedSectionStatic : SectionStatic()


class GroupedSectionClass(vararg item: TestableClass, name: String? = null) : SectionClass(*item, name = name)


val GroupedSection = GroupedSectionStatic()