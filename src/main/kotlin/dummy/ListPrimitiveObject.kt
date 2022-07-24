package dummy

import JsonType

data class ListPrimitiveObject @JsonType constructor(
    val string: ArrayList<String>,
    val int: MutableList<Int>,
    val long: ArrayList<Long>,
    val float: MutableList<Float>,
    val double: List<Double>
)