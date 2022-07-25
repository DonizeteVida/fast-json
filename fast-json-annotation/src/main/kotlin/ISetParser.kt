interface ISetParser<T> {
    fun asHashSet(array: JsonArrayWrapper): HashSet<T>
    fun asMutableSet(array: JsonArrayWrapper) = asHashSet(array)
    fun asSet(array: JsonArrayWrapper) = asHashSet(array)
}