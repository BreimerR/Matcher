package matcher

import libs.oop.classes.StaticClass
import matcher.items.ItemClass
import matcher.items.ItemsStatic.Class as ItemsClass
import matcher.sections.SectionStatic
import matcher.TestableStatic.Class as TestableClass

// A standard way to results for a particular search
// Searches must be type sensitive i.e regex searcher can not be used to generate
// tokens parser
abstract class MatcherStatic<in T> : StaticClass() {

    // TODO TestableClass<T>
    // secure comparison requirements of the library.
    abstract class Class<T>(vararg val sections: TestableClass<T>) : libs.oop.classes.Class<MatcherStatic<T>>() {

        open var results = mutableMapOf<String?, Array<ItemClass<T>>>()

        /**
         * {
         *      0:"www",
         *      // named search case
         *      1:["domain_name","smile.com",[// any other separations will be stored here]],
         *      // unnamed search
         *      2:"some mor"
         * }*/


        infix fun test(items: ItemsClass<T>): Boolean {

            val c = 0

            sections.forEach { section ->
                if (section test items) {
                    when (section) {
                        is SectionStatic.Class -> {
                            results[section.name] = section.results
                        }
                    }
                } else return false
            }

            if (items.hasRemItems) {
                return false
            }

            return true
        }


        /* operator fun get(name: String): Array<T> {
              TODO("Implement getter function with named indexes")
          }

          operator fun get(inedx: Int) {
              TODO("Implement getter function with indexes")
          }*/
    }
}


