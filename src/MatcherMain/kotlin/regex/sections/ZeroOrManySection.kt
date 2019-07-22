package regex.sections


import matcher.TestableStatic
import matcher.items.ItemsStatic
import matcher.items.ItemsStatic.Class as ItemsClass
import matcher.sections.ZeroOrManySectionStatic as LZeroOrManySectionStatic

class ZeroOrManySectionStatic : LZeroOrManySectionStatic<Char>() {
    override fun invoke(vararg items: TestableStatic.Class<Char>, name: String?, maxCount: Int): Class {
        return Class(Section(*items), name, maxCount)
    }

    override fun invoke(vararg items: TestableStatic.Class<Char>, name: String?): Class {
        return Class(Section(*items), name, maxCount)
    }

    override fun invoke(item: TestableStatic.Class<Char>, name: String?, maxCount: Int): Class {
        return Class(item, name, maxCount)
    }

    override fun invoke(item: TestableStatic.Class<Char>, name: String?, minCount: Int, maxCount: Int): Class {
        return Class(item, name, maxCount)
    }

    override fun invoke(vararg item: TestableStatic.Class<Char>, name: String?, minCount: Int, maxCount: Int): Class {
        return Class(Section(*item), name, maxCount)
    }

    class Class(section: TestableStatic.Class<Char>, name: String?, maxCount: Int) :
            LZeroOrManySectionStatic.Class<Char>(section, name, maxCount, ZeroOrManySection) {
        override fun test(items: ItemsStatic.Class<Char>): Boolean {
            val test = super.test(items)

            println(test)

            return test
        }
    }

}

val ZeroOrManySection = ZeroOrManySectionStatic()