object FloatParser : IListParser<Float>, ISetParser<Float>, IMapParser<Float> {
    override fun asArrayList(array: JsonArrayWrapper) = array.list(JsonArrayWrapper::getFloat)

    override fun asHashSet(array: JsonArrayWrapper) = array.set(JsonArrayWrapper::getFloat)

    override fun asMap(obj: JsonObjectWrapper) = obj.map(JsonObjectWrapper::getFloat)

    override fun toJson(list: List<Float>) = list.toJson(JsonArrayWrapper::putFloat)
}