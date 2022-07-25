interface Parser<T> : IListParser<T>, ISetParser<T>, IMapParser<T> {
    operator fun invoke(json: String) =
        invoke(JsonObjectWrapper(json))

    operator fun invoke(obj: JsonObjectWrapper): T

    operator fun invoke(obj: T): JsonObjectWrapper

    fun fromJson(json: String) =
        fromJson(JsonObjectWrapper(json))

    fun fromJson(obj: JsonObjectWrapper) =
        invoke(obj)

    fun toJson(obj: T) =
        invoke(obj).toString()

    fun asArrayList(json: String) =
        asList(JsonArrayWrapper(json))

    override fun toJson(list: List<T>) =
        list.toJson(::invoke)

    override fun asArrayList(array: JsonArrayWrapper) =
        array.list(JsonArrayWrapper::getObject, ::invoke)

    fun asHashSet(json: String) =
        asSet(JsonArrayWrapper(json))

    override fun asHashSet(array: JsonArrayWrapper) =
        array.set(JsonArrayWrapper::getObject, ::invoke)

    fun asMap(json: String) =
        asMap(JsonObjectWrapper(json))

    override fun asMap(obj: JsonObjectWrapper) =
        obj.map(JsonObjectWrapper::getObject, ::invoke)
}