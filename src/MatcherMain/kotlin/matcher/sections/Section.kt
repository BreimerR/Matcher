package matcher.sections

import libs.oop.classes.Class
import libs.oop.classes.StaticClass

class SectionStatic : StaticClass() {
    operator fun invoke(): SectionClass {
        return SectionClass()
    }
}

class SectionClass : Class<SectionStatic>() {
    override val self = Section
}

val Section = SectionStatic()