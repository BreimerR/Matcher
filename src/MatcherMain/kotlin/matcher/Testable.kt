package matcher

import libs.oop.classes.Class as OClass
import libs.oop.classes.StaticClass
import matcher.items.ItemsStatic.Class as ItemsClass

// should be typed as a testable for char is not a
// testable for string or any other type of object

abstract class TestableStatic : StaticClass() {


    abstract class Class<T> : OClass<TestableStatic>() {
        abstract infix fun test(items: ItemsClass<T>): Boolean
    }
}