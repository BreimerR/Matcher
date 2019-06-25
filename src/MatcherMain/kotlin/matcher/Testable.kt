package matcher

import libs.oop.classes.Class
import libs.oop.classes.StaticClass
import matcher.items.ItemClass
import matcher.items.ItemsClass

// should be typed as a testable for char is not a
// testable for string or any other type of object
abstract class TestableClass : Class<TestableStatic>() {
    abstract infix fun <T> test(items: ItemsClass<T>): Boolean
}

abstract class TestableStatic : StaticClass()