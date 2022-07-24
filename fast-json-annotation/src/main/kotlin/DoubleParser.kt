import org.json.JSONArray
import org.json.JSONObject

object DoubleParser : ListParser<Double>, SetParser<Double>, MapParser<Double> {
    override fun asArrayList(jsonArray: JSONArray) = jsonArray.list(JSONArray::getDouble)

    override fun asHashSet(jsonArray: JSONArray) = jsonArray.set(JSONArray::getDouble)

    override fun asMap(jsonObject: JSONObject) = jsonObject.map(JSONObject::getDouble)
}