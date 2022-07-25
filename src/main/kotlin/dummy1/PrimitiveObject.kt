package dummy1

import JsonType

data class PrimitiveObject @JsonType constructor(
    val string: String,
    val int: Int,
    val long: Long,
    val float: Float,
    val double: Double
)