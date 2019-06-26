package matcher.sections


// testableClass is a comparable class
import matcher.TestableClass

open class RepetitiveBySectionStatic : RepetitiveSectionStatic() {
    operator fun invoke(section: TestableClass, by: TestableClass, name: String?, minCount: Int = this.minCount, maxCount: Int = this.maxCount): Class {
        return Class(section, by, name, minCount, maxCount)
    }

    override operator fun invoke(item: TestableClass, name: String?, minCount: Int, maxCount: Int): Class {
        throw Error("required argument by is not defined")
    }

    override operator fun invoke(vararg item: TestableClass, name: String?, minCount: Int, maxCount: Int): Class {
        val l = item.size
        var section = arrayOf<TestableClass>()
        var c = 0
        while (c < l - 1) section += item[c++]
        return Class(Section(*section), item[l - 1], name, minCount = minCount, maxCount = maxCount)
    }

    override operator fun invoke(vararg items: TestableClass, name: String?): Class {
        val l = items.size
        var section = arrayOf<TestableClass>()
        var c = 0
        while (c < l - 1) section += items[c++]
        return Class(Section(*section), items[l - 1], name, minCount = minCount, maxCount = maxCount)
    }

    open class Class(section: TestableClass, by: TestableClass, name: String?, minCount: Int, maxCount: Int)
        : RepetitiveSectionStatic.Class(Section(section, ZeroOrManySection(Section(by, section))), name, minCount, maxCount) {
        override val self = RepetitiveBySection
    }
}


val RepetitiveBySection = RepetitiveBySectionStatic()