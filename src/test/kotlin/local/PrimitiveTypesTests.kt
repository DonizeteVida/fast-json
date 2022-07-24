package local

import dummy.ListPrimitiveObject
import dummy.ListPrimitiveObjectParser
import dummy.PrimitiveObject
import dummy.PrimitiveObjectParser
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PrimitiveTypesTests {

    @Test
    fun shouldBeAbleToParsePrimitiveObject() {
        val json = """
            {
                "string": "STRING",
                "int": 1234,
                "long": 1231231232131313231,
                "float": 1.4,
                "double": 1.2312312312123124E100
            }
        """.trimIndent()

        val primitiveObject: PrimitiveObject = PrimitiveObjectParser.fromJson(json)

        assertEquals(primitiveObject.string, "STRING")
        assertEquals(primitiveObject.int, 1234)
        assertEquals(primitiveObject.long, 1231231232131313231)
        assertEquals(primitiveObject.float, 1.4F)
        assertEquals(primitiveObject.double, 1.2312312312123124E100)
    }

    @Test
    fun shouldBeAbleToParseListPrimitiveObject() {
        val json = """
            {
                "string": ["S", "T", "R", "I", "N", "G"],
                "int": [1, 2, 3, 4],
                "long": [1231231232131313231, 1231231232131313231, 1231231232131313231, 1231231232131313231],
                "float": [1.4, 1.4, 1.4, 1.4],
                "double": [1.2312312312123124E100, 1.2312312312123124E100, 1.2312312312123124E100]
            }
        """.trimIndent()

        val listPrimitiveObject: ListPrimitiveObject = ListPrimitiveObjectParser.fromJson(json)

        assertEquals(listPrimitiveObject.string, arrayListOf("S", "T", "R", "I", "N", "G"))
        assertEquals(listPrimitiveObject.int, arrayListOf(1, 2, 3, 4))
        assertEquals(
            listPrimitiveObject.long,
            arrayListOf(1231231232131313231, 1231231232131313231, 1231231232131313231, 1231231232131313231)
        )
        assertEquals(listPrimitiveObject.float, arrayListOf(1.4F, 1.4F, 1.4F, 1.4F))
        assertEquals(
            listPrimitiveObject.double,
            arrayListOf(1.2312312312123124E100, 1.2312312312123124E100, 1.2312312312123124E100)
        )
    }
}