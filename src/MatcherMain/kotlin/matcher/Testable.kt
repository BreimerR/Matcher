package matcher

import libs.oop.classes.Class
import libs.oop.classes.StaticClass
import matcher.items.ItemsClass

// should be typed as a testable for char is not a
// testable for string or any other type of object
abstract class TestableClass : Class<TestableStatic>() {

    abstract infix fun test(items: ItemsClass<*>): Boolean
}

abstract class TestableStatic : StaticClass()