package matcher

import libs.oop.classes.Class
import libs.oop.classes.StaticClass

class ItemClass : Class<ItemStatic>() {
    override val self = Item
}

class ItemStatic : StaticClass() {
    operator fun invoke(): ItemClass {
        TODO("Create Item constructors")
    }
}

val Item = ItemStatic()