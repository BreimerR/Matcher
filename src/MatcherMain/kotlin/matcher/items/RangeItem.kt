package matcher.items

import matcher.TestableClass

class RangeItemStatic : ItemStatic() {
    operator fun invoke() {

    }
}

class RangeItemClass<T>(vararg value: T) : ItemClass<T>(*value) {
    override fun test(items: TestableClass): Boolean {
        return false
    }

    override val self = RangeItem
}


val RangeItem = RangeItemStatic()