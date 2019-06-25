package libs.cli

import libs.collections.array.invoke
import libs.math.isEven
import libs.oop.classes.Class
import libs.oop.classes.StaticClass


class CLIArgumentsStatic : StaticClass() {
    operator fun invoke(arguments: Array<String>): CLIArgumentsClass = CLIArgumentsClass(arguments)
}


class CLIArgumentsClass(arguments: Array<String>) : Class<CLIArgumentsStatic>() {
    override val self = CLIArguments

    var args = mapOf<String, String>()

    init {
        if (arguments.size.isEven) {
            arguments(step = 2) { i: Int, key: String ->
                args += Pair(key, arguments[i + 1])
            }
        }

    }

    operator fun get(key: String): String {
        return args[key] ?: throw Error("Argument $key is not defined")
    }
}

val CLIArguments = CLIArgumentsStatic()