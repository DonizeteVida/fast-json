import org.json.JSONArray
import org.json.JSONObject

interface SetParser<T> {
    fun asHashSet(jsonArray: JSONArray): HashSet<T>
    fun asMutableSet(jsonArray: JSONArray) = asHashSet(jsonArray)
    fun asSet(jsonArray: JSONArray) = asHashSet(jsonArray)
}

inline fun <T> JSONArray.set(
    wrapper: (JSONObject) -> T,
    mapper: JSONArray.(Int) -> JSONObject
) = set {
    wrapper(mapper(it))
}

inline fun <T> JSONArray.set(
    mapper: JSONArray.(Int) -> T
) = collect(mapper, ::HashSet)