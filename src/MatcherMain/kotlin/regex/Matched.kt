package regex


import matcher.MatchedClass as LMatchedClass
import matcher.MatchedStatic as LMatchedStatic

class MatchedClass : LMatchedClass<String>() {
    override val self = Matched
}

class MatchedStatic : LMatchedStatic() {
    operator fun invoke(): MatchedClass = MatchedClass()
}


val Matched = MatchedStatic()