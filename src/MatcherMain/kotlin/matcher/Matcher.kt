package matcher

import libs.oop.classes.Class
import libs.oop.classes.StaticClass
import regex.Regex


abstract class MatcherStatic : StaticClass()

abstract class MatcherClass<Self : MatcherStatic> : Class<Self>()
