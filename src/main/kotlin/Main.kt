data class MyType @JsonType constructor(
    @JsonField(name = "data_1")
    val data1: String,
    val data2: Int,
    val data3: Long,
    val data4: Float,
    val data5: Double,
    val nested: MyNestedType
)

data class MyNestedType @JsonType constructor(
    val name: String
)

fun main(args: Array<String>) {
    println("Hello World!")

    val myType: MyType = MyTypeParser(
        """
        {
            "data_1":"John", 
            "data2": 2, 
            "data3": 12312312, 
            "data4": 4.4444, 
            "data5": 5.5555, 
            "nested": { 
                "name": "Doni" 
            }
        }
        """.trimIndent()
    )

    println("Program arguments: $myType")
}