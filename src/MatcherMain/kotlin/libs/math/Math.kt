package libs.math

import libs.oop.classes.Class
import libs.oop.classes.StaticClass

val kotlin.Int.isEven: Boolean
    get() {
        return this % 2 == 0
    }


val kotlin.Int.charVal: Char
    get() = this.toChar()


val kotlin.Int.long: Long get () = this.toLong()

val kotlin.Int.asBool: Boolean get () = this > 0

class MathStatic : StaticClass()


class MatchClass : Class<MathStatic>() {
    override val self: MathStatic = Math
}


val Math = MathStatic()