import org.json.JSONArray
import org.json.JSONObject

object LongParser : ListParser<Long>, SetParser<Long>, MapParser<Long> {
    override fun asArrayList(jsonArray: JSONArray) = jsonArray.list(JSONArray::getLong)

    override fun asHashSet(jsonArray: JSONArray) = jsonArray.set(JSONArray::getLong)

    override fun asMap(jsonObject: JSONObject) = jsonObject.map(JSONObject::getLong)
}