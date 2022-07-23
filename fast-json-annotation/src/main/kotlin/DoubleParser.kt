import org.json.JSONArray
import org.json.JSONObject

object DoubleParser : ListParser<Double>, SetParser<Double>, MapParser<Double> {
    override fun asList(jsonArray: JSONArray) = jsonArray.list(JSONArray::getDouble)

    override fun asSet(jsonArray: JSONArray) = jsonArray.set(JSONArray::getDouble)

    override fun asMap(jsonObject: JSONObject) = jsonObject.map(JSONObject::getDouble)
}