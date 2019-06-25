package matcher

import libs.oop.classes.Class
import libs.oop.classes.StaticClass
import matcher.items.ItemsClass

// A standard way to results for a particular search
// Searches must be type sensitive i.e regex searcher can not be used to generate
// tokens parser
abstract class MatcherStatic : StaticClass() {

}

abstract class MatcherClass<Self : MatcherStatic> : Class<Self>() {
    abstract val sections: Array<out TestableClass>

    infix fun <T> test(items: ItemsClass<T>): Boolean {
        // if any test fails return an false similar to a cumulative boolean
        for (section in sections) if (items.hasRemItems) return section test items
        return true
    }
}
