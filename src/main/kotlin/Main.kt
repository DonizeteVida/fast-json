data class MyType @JsonType constructor(
    val data1: String,
    val data2: Int,
    val data3: Long,
    val data4: Float,
    val data5: Double
)

fun main(args: Array<String>) {
    println("Hello World!")

    val myType: MyType = MyTypeParser(
        """
        {"data1":"John", "data2": 2, "data3": 12312312, "data4": 4.4444, "data5": 5.5555}
        """.trimIndent()
    )

    println("Program arguments: $myType")
}