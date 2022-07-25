import org.json.JSONArray

class JsonArrayWrapper(
    val array: JSONArray
) {
    constructor(json: String) : this(JSONArray(json))

    constructor() : this(JSONArray())

    private fun put(value: Any) {
        array.put(value)
    }

    private inline fun <T> get(index: Int, getter: JSONArray.(Int) -> T) = getter(array, index)

    fun putString(value: String) = put(value)

    fun putInt(value: Int) = put(value)

    fun putLong(value: Long) = put(value)

    fun putFloat(value: Float) = put(value)

    fun putDouble(value: Double) = put(value)

    fun putObject(value: JsonObjectWrapper) = put(value.obj)

    fun getString(index: Int) = get(index, JSONArray::getString)

    fun getInt(index: Int) = get(index, JSONArray::getInt)

    fun getLong(index: Int) = get(index, JSONArray::getLong)

    fun getFloat(index: Int) = get(index, JSONArray::getFloat)

    fun getDouble(index: Int) = get(index, JSONArray::getDouble)

    fun getObject(index: Int) = get(index, JSONArray::getJSONObject).let(::JsonObjectWrapper)

    fun length() = array.length()

    inline fun <A, B> list(
        mapper1: JsonArrayWrapper.(Int) -> A,
        mapper2: (A) -> B
    ) = list {
        mapper2(mapper1(it))
    }

    inline fun <T> list(mapper: JsonArrayWrapper.(Int) -> T) =
        collect(::ArrayList, mapper)

    inline fun <A, B> set(
        mapper1: JsonArrayWrapper.(Int) -> A,
        mapper2: (A) -> B
    ) = set {
        mapper2(mapper1(it))
    }

    inline fun <T> set(mapper: JsonArrayWrapper.(Int) -> T) =
        collect(::HashSet, mapper)

    inline fun <T, P : MutableCollection<T>> collect(
        producer: (Int) -> P,
        mapper: JsonArrayWrapper.(Int) -> T
    ) = run {
        val len = length()
        producer(len).apply {
            for (i in 0 until len) add(mapper(i))
        }
    }
}