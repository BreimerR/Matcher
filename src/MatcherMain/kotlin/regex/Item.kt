package regex

import matcher.TestableClass
import matcher.items.ItemsClass
import matcher.items.ItemClass as LItemClass
import matcher.items.ItemStatic as LItemStatic


class ItemClass(public val value: Char) : LItemClass<Char>() {

    override infix fun <T> test(items: ItemsClass<T>): Boolean {
        return this.value == (items.nextItem as ItemClass).value
    }


    override val self = Item
}


class ItemStatic : LItemStatic() {
    operator fun invoke(char: Char, name: String = ""): ItemClass = ItemClass(char)

}

val Item = ItemStatic()