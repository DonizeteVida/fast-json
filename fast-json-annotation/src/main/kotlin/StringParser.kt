import org.json.JSONArray
import org.json.JSONObject

object StringParser : ListParser<String>, SetParser<String>, MapParser<String> {
    override fun asList(jsonArray: JSONArray) = jsonArray.list(JSONArray::getString)

    override fun asSet(jsonArray: JSONArray) = jsonArray.set(JSONArray::getString)

    override fun asMap(jsonObject: JSONObject) = jsonObject.map(JSONObject::getString)
}