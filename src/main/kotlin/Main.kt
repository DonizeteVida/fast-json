import org.json.JSONObject

data class MyType @JsonType constructor(
    @JsonField(name = "data_1")
    val data1: String,
    val data2: Int,
    val data3: Long,
    val data4: Float,
    val data5: Double,
    val nested: MyNestedType,
    val items: List<Int>,
    val names: List<String>,
    @JsonField("more_nesteds")
    val moreNesteds: List<MoreNested>
)

data class MyNestedType @JsonType constructor(
    val name: String,
    @JsonField(name = "more_nested")
    val moreNested: MoreNested
)

data class MoreNested @JsonType constructor(
    val age: Int
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
                "name": "Doni",
                "more_nested": {
                    "age": 23
                }
            },
            "items": [1, 2, 3, 4],
            "names": ["Donizete", "Vida"],
            "more_nesteds": [
                {
                    "age": 23
                },
                {
                    "age": 23
                }
            ]
        }
        """.trimIndent()
    )

    println("Program arguments: $myType")
}