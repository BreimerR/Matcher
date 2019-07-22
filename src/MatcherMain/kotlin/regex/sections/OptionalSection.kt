package regex.sections

import matcher.TestableStatic

class OptionalSectionStatic : matcher.sections.OptionalSectionStatic<Char>() {
    override fun invoke(vararg items: TestableStatic.Class<Char>, name: String?): Class {
        return Class(Section(*items), name)
    }

    class Class(section: TestableStatic.Class<Char>, name: String? = null) :
            matcher.sections.OptionalSectionStatic.Class<Char>(section = section, name = name, self = OptionalSection)


}

val OptionalSection = OptionalSectionStatic()