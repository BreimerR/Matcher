package matcher.items

import libs.collections.array.length
import matcher.TestableClass
import matcher.TestableStatic

abstract class ItemsStatic<T> : TestableStatic()

abstract class ItemsClass<T> : TestableClass() {
    abstract val items: Array<out ItemClass<T>>


    var i = 0

    val nextItem: ItemClass<T>?
        get() {
            if (hasRemItems) {
                val res = items[i]
                i += 1
                return res
            }

            return null
        }

    val hasRemItems: Boolean
        get () {
            return i < items.length
        }

}


