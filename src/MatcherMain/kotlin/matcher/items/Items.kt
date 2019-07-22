package matcher.items

import libs.collections.array.length
import libs.oop.classes.Class as SClass
import libs.oop.classes.StaticClass


abstract class ItemsStatic<T> : StaticClass() {

    abstract class Class<T>(open val items: Array<out ItemClass<T>>) : SClass<ItemsStatic<T>>() {

        var i = 0


        var currentItem: ItemClass<T>? = null

        val nextItem: ItemClass<T>?
            get() {
                if (hasRemItems) {
                    val res = items[i]
                    i += 1

                    currentItem = res

                    return res
                }

                return null
            }

        val hasRemItems: Boolean
            get () {
                return items.length != 0 && i < items.length
            }


        operator fun get(index: Int): ItemClass<T> = items[index]


    }

}


