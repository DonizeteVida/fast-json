object DoubleParser : IListParser<Double>, ISetParser<Double>, IMapParser<Double> {
    override fun asArrayList(array: JsonArrayWrapper) = array.list(JsonArrayWrapper::getDouble)

    override fun asHashSet(array: JsonArrayWrapper) = array.set(JsonArrayWrapper::getDouble)

    override fun asMap(obj: JsonObjectWrapper) = obj.map(JsonObjectWrapper::getDouble)

    override fun toJson(list: List<Double>) = list.toJson(JsonArrayWrapper::putDouble)
}