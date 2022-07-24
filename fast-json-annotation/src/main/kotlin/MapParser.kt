import org.json.JSONObject

interface MapParser<T> {
    fun asMap(jsonObject: JSONObject): Map<String, T>
}

inline fun <T> JSONObject.map(
    wrapper: (JSONObject) -> T,
    mapper: JSONObject.(String) -> JSONObject
) = map {
    wrapper(mapper(it))
}

inline fun <T> JSONObject.map(
    mapper: JSONObject.(String) -> T
) = collect(mapper, ::HashMap)