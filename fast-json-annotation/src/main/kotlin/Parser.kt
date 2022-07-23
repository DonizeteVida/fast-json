import org.json.JSONArray
import org.json.JSONObject

interface Parser<T> : ListParser<T>, SetParser<T>, MapParser<T> {
    operator fun invoke(json: String) = invoke(JSONObject(json))

    operator fun invoke(jsonObject: JSONObject): T

    fun asList(json: String) = asList(JSONArray(json))

    override fun asList(jsonArray: JSONArray) = jsonArray.list(
        wrapper = ::invoke,
        mapper = JSONArray::getJSONObject
    )

    fun asSet(json: String) = asSet(JSONArray(json))

    override fun asSet(jsonArray: JSONArray): Set<T> = jsonArray.set(
        wrapper = ::invoke,
        mapper = JSONArray::getJSONObject
    )

    fun asMap(json: String) = asMap(JSONObject(json))

    override fun asMap(jsonObject: JSONObject) = jsonObject.map(
        wrapper = ::invoke,
        mapper = JSONObject::getJSONObject
    )
}

inline fun <T, C : MutableCollection<T>> JSONArray.collect(
    mapper: JSONArray.(Int) -> T,
    collection: (Int) -> C
) = run {
    val len = length()
    collection(len).apply {
        for (i in 0 until len) add(mapper(i))
    }
}

inline fun <T, C : MutableMap<String, T>> JSONObject.collect(
    mapper: JSONObject.(String) -> T,
    collection: (Int) -> C
) = run {
    val keySet = keySet()
    val len = keySet.size
    collection(len).apply {
        for (key in keySet) put(key, mapper(key))
    }
}