import org.json.JSONArray
import org.json.JSONObject

interface SetParser<T> {
    fun asSet(jsonArray: JSONArray): Set<T>
}

inline fun <T> JSONArray.set(
    wrapper: (JSONObject) -> T,
    mapper: JSONArray.(Int) -> JSONObject
): Set<T> = set {
    wrapper(mapper(it))
}

inline fun <T> JSONArray.set(
    mapper: JSONArray.(Int) -> T
): Set<T> = collect(mapper, ::HashSet)