import org.json.JSONArray
import org.json.JSONObject

interface Parser<T> : ListParser<T> {
    operator fun invoke(json: String) = invoke(JSONObject(json))

    operator fun invoke(jsonObject: JSONObject): T

    fun asList(json: String) = asList(JSONArray(json))

    override fun asList(jsonArray: JSONArray) = jsonArray.map(
        wrapper = ::invoke,
        mapper = JSONArray::getJSONObject
    )
}

interface ListParser<T> {
    fun asList(jsonArray: JSONArray): List<T>
}

inline fun <T> JSONArray.map(
    wrapper: (JSONObject) -> T,
    mapper: JSONArray.(Int) -> JSONObject
): List<T> = map {
    wrapper(this.mapper(it))
}

inline fun <T> JSONArray.map(
    mapper: JSONArray.(Int) -> T
): List<T> {
    val len = length()
    return ArrayList<T>(len).apply {
        for (i in 0 until len) add(this@map.mapper(i))
    }
}

object StringParser : ListParser<String> {
    override fun asList(jsonArray: JSONArray) = jsonArray.map(JSONArray::getString)
}

object IntParser : ListParser<Int> {
    override fun asList(jsonArray: JSONArray) = jsonArray.map(JSONArray::getInt)
}

object LongParser : ListParser<Long> {
    override fun asList(jsonArray: JSONArray) = jsonArray.map(JSONArray::getLong)
}

object FloatParser : ListParser<Float> {
    override fun asList(jsonArray: JSONArray) = jsonArray.map(JSONArray::getFloat)
}

object DoubleParser : ListParser<Double> {
    override fun asList(jsonArray: JSONArray) = jsonArray.map(JSONArray::getDouble)
}