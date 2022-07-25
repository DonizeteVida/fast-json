package dummy2

import JsonField
import JsonType
import dummy1.PrimitiveObject

data class ComplexObject @JsonType constructor(
    val name: String,
    val age: Int,
    @JsonField("primitive_object")
    val primitiveObject: PrimitiveObject
)