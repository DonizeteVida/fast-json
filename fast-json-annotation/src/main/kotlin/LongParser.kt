object LongParser : IListParser<Long>, ISetParser<Long>, IMapParser<Long> {
    override fun asArrayList(array: JsonArrayWrapper) = array.list(JsonArrayWrapper::getLong)

    override fun asHashSet(array: JsonArrayWrapper) = array.set(JsonArrayWrapper::getLong)

    override fun asMap(obj: JsonObjectWrapper) = obj.map(JsonObjectWrapper::getLong)

    override fun toJson(list: List<Long>) = list.toJson(JsonArrayWrapper::putLong)
}