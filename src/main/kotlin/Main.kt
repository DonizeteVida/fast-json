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
    val moreNesteds: List<MoreNested>,

    @JsonField("as_set")
    val asSet: Set<String>,

    @JsonField("map_integer")
    val mapInteger: Map<String, Int>,


    @JsonField("map_object")
    val mapObject: Map<String, MoreNested>
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
            ],
            "as_set": ["A", "B", "C"],
            "map_integer": {
                "1": 1,
                "2": 2,
                "3": 4
            },
            "map_object": {
                "1": { "age": 123 },
                "2": { "age": 1234 }
            }
        }
        """.trimIndent()
    )

    println("Program arguments: $myType")
}