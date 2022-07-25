object IntParser : IListParser<Int>, ISetParser<Int>, IMapParser<Int> {
    override fun asArrayList(array: JsonArrayWrapper) = array.list(JsonArrayWrapper::getInt)

    override fun asHashSet(array: JsonArrayWrapper) = array.set(JsonArrayWrapper::getInt)

    override fun asMap(obj: JsonObjectWrapper) = obj.map(JsonObjectWrapper::getInt)

    override fun toJson(list: List<Int>) = list.toJson(JsonArrayWrapper::putInt)
}