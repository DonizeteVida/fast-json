object StringParser : IListParser<String>, ISetParser<String>, IMapParser<String> {
    override fun asArrayList(array: JsonArrayWrapper) = array.list(JsonArrayWrapper::getString)

    override fun asHashSet(array: JsonArrayWrapper) = array.set(JsonArrayWrapper::getString)

    override fun asMap(obj: JsonObjectWrapper) = obj.map(JsonObjectWrapper::getString)

    override fun toJson(list: List<String>) = list.toJson(JsonArrayWrapper::putString)
}