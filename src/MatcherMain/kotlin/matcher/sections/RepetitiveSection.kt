package matcher.sections


import matcher.TestableStatic
import matcher.items.ItemsStatic.Class as ItemsClass

abstract class RepetitiveSectionStatic<T>(open val minCount: Int = 0, open val maxCount: Int = 10000000) : SectionStatic<T>() {
    abstract operator fun invoke(item: TestableStatic.Class<T>, name: String? = null, minCount: Int = 0, maxCount: Int = this.maxCount): Class<T>

    abstract operator fun invoke(vararg item: TestableStatic.Class<T>, name: String? = null, minCount: Int = this.minCount, maxCount: Int = this.maxCount): Class<T>

    abstract override operator fun invoke(vararg items: TestableStatic.Class<T>, name: String?): Class<T>

    abstract class Class<I>(
            section: TestableStatic.Class<I>,
            name: String?, open val minCount: Int,
            open val maxCount: Int, self: RepetitiveSectionStatic<I>) :
            SectionStatic.Class<I>(section, name = name, self = self) {

        var tCounts = 0
        var mCounts = 0

        private inline val testable
            get() = mCounts < maxCount

        private inline val minSuccess: Boolean
            get() = tCounts >= minCount

        // TODO get this done this sucks
        override infix fun test(items: ItemsClass<I>): Boolean {
            var iI = items.i

            while (testable && super.test(items)) {
                iI = items.i
                mCounts += 1
                tCounts += 1
            }


            return if (minSuccess) {
                items.i = iI
                true
            } else false
        }

    }

}

/*
AnySection.kt
GroupedSection.kt
NotSection.kt

*/