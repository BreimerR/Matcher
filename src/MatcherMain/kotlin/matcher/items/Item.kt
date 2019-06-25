package matcher.items

import matcher.TestableClass
import matcher.TestableStatic

abstract class ItemClass<T>(open val value: T) : TestableClass() {
    override fun test(items: ItemsClass<*>): Boolean {
        if (items.hasRemItems) return this compare (items.nextItem as ItemClass<*>).value
        return false
    }

    abstract infix fun compare(value: Any?): Boolean
}

abstract class ItemStatic : TestableStatic()
