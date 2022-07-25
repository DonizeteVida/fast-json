interface IMapParser<T> {
    fun asMap(obj: JsonObjectWrapper): Map<String, T>
}