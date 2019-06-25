package regex.items

import matcher.TestableClass

import matcher.items.ItemClass as LItemClass
import matcher.items.ItemStatic as LItemStatic


class ItemClass(override val value: Char) : LItemClass<Char>(value) {
    override val self = Item

    override fun compare(value: Any?): Boolean {
        return this.value == value
    }
}


class ItemStatic : LItemStatic() {
    operator fun invoke(char: Char, name: String = ""): ItemClass = ItemClass(char)

}

val Item = ItemStatic()