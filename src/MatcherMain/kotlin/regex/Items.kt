package regex

import libs.collections.array.each
import libs.text.each
import matcher.TestableClass
import matcher.items.ItemsStatic as LItemsStatic
import matcher.items.ItemsClass as LItemsClass


class ItemsStatic : LItemsStatic<Char>() {
    operator fun invoke(testCase: String): ItemsClass {
        return ItemsClass(testCase)
    }
}

class ItemsClass(val testCase: String) : LItemsClass<Char>() {

    override val self = Items
    override var items = arrayOf<ItemClass>()

    init {
        testCase.each { it: Char ->
            items += Item(it)
        }


    }

    override fun test(items: TestableClass): Boolean {
        return true
    }


}

val Items = ItemsStatic()