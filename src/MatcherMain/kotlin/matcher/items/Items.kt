package matcher.items

import libs.collections.array.length
import libs.oop.classes.Class
import libs.oop.classes.StaticClass


abstract class ItemsStatic<T> : StaticClass()

abstract class ItemsClass<T> : Class<ItemsStatic<T>>() {
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


