package matcher.items

import matcher.TestableClass
import matcher.TestableStatic

abstract class ItemClass<T>(vararg value: T) : TestableClass() {

}

abstract class ItemStatic : TestableStatic()
