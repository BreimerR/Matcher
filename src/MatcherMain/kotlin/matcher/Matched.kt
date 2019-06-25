package matcher

import libs.oop.classes.Class
import libs.oop.classes.StaticClass

abstract class MatchedClass<Type> : Class<MatchedStatic>()


abstract class MatchedStatic : StaticClass()