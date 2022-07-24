import org.json.JSONArray
import org.json.JSONObject

object FloatParser : ListParser<Float>, SetParser<Float>, MapParser<Float> {
    override fun asArrayList(jsonArray: JSONArray) = jsonArray.list(JSONArray::getFloat)

    override fun asHashSet(jsonArray: JSONArray) = jsonArray.set(JSONArray::getFloat)

    override fun asMap(jsonObject: JSONObject) = jsonObject.map(JSONObject::getFloat)
}