import org.json.JSONArray
import org.json.JSONObject

object IntParser : ListParser<Int>, SetParser<Int>, MapParser<Int> {
    override fun asArrayList(jsonArray: JSONArray) = jsonArray.list(JSONArray::getInt)

    override fun asHashSet(jsonArray: JSONArray) = jsonArray.set(JSONArray::getInt)

    override fun asMap(jsonObject: JSONObject) = jsonObject.map(JSONObject::getInt)
}