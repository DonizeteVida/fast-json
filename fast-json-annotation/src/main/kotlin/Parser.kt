import org.json.JSONObject

interface Parser<T> {
    operator fun invoke(jsonObject: JSONObject): T
    operator fun invoke(json: String) = invoke(JSONObject(json))
}