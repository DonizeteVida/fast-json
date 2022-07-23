import org.json.JSONArray
import org.json.JSONObject

interface ListParser<T> {
    fun asList(jsonArray: JSONArray): List<T>
}

inline fun <T> JSONArray.list(
    wrapper: (JSONObject) -> T,
    mapper: JSONArray.(Int) -> JSONObject
): List<T> = list {
    wrapper(mapper(it))
}

inline fun <T> JSONArray.list(
    mapper: JSONArray.(Int) -> T
): List<T> = collect(mapper, ::ArrayList)