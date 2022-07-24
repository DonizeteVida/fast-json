import org.json.JSONArray
import org.json.JSONObject

interface ListParser<T> {
    fun asArrayList(jsonArray: JSONArray): ArrayList<T>
    fun asMutableList(jsonArray: JSONArray) = asArrayList(jsonArray)
    fun asList(jsonArray: JSONArray) = asArrayList(jsonArray)
}

inline fun <T> JSONArray.list(
    wrapper: (JSONObject) -> T,
    mapper: JSONArray.(Int) -> JSONObject
) = list {
    wrapper(mapper(it))
}

inline fun <T> JSONArray.list(
    mapper: JSONArray.(Int) -> T
) = collect(mapper, ::ArrayList)