package regex.items


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
    override fun test(items: matcher.items.ItemsClass<*>): Boolean {

        return false
    }







    override val self = Items
    override var items = arrayOf<ItemClass>()

    init {
        testCase.each { it: Char ->
            items += Item(it)
        }


    }

}

val Items = ItemsStatic()