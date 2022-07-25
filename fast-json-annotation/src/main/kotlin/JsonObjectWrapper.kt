import org.json.JSONObject

class JsonObjectWrapper(
    val obj: JSONObject
) {
    constructor(json: String) : this(JSONObject(json))

    constructor() : this(JSONObject())

    private fun put(key: String, value: Any) {
        obj.put(key, value)
    }

    private inline fun <T> get(key: String, getter: JSONObject.(String) -> T) = getter(obj, key)

    fun putString(key: String, value: String) = put(key, value)

    fun putInt(key: String, value: Int) = put(key, value)

    fun putLong(key: String, value: Long) = put(key, value)

    fun putFloat(key: String, value: Float) = put(key, value)

    fun putDouble(key: String, value: Double) = put(key, value)

    fun putArray(key: String, value: JsonArrayWrapper) = put(key, value.array)

    fun putObject(key: String, value: JsonObjectWrapper) = put(key, value.obj)

    fun getString(key: String) = get(key, JSONObject::getString)

    fun getInt(key: String) = get(key, JSONObject::getInt)

    fun getLong(key: String) = get(key, JSONObject::getLong)

    fun getFloat(key: String) = get(key, JSONObject::getFloat)

    fun getDouble(key: String) = get(key, JSONObject::getDouble)

    fun getArray(key: String) = get(key, JSONObject::getJSONArray).let(::JsonArrayWrapper)

    fun getObject(key: String) = get(key, JSONObject::getJSONObject).let(::JsonObjectWrapper)

    fun keySet(): Set<String> = obj.keySet()

    inline fun <A, B> map(
        mapper1: JsonObjectWrapper.(String) -> A,
        mapper2: (A) -> B
    ) = map {
        mapper2(mapper1(it))
    }

    inline fun <T> map(mapper: JsonObjectWrapper.(String) -> T) = run {
        val keySet = keySet()
        val len = keySet.size
        HashMap<String, T>(len).apply {
            for (key in keySet) put(key, mapper(key))
        }
    }
}

inline fun <T> JsonObjectWrapper.map(
    wrapper: (JsonObjectWrapper) -> T,
    mapper: JsonObjectWrapper.(String) -> JsonObjectWrapper
) = map {
    wrapper(mapper(it))
}