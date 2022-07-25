interface IListParser<T> {
    fun asArrayList(array: JsonArrayWrapper): ArrayList<T>
    fun asMutableList(array: JsonArrayWrapper) = asArrayList(array)
    fun asList(array: JsonArrayWrapper) = asArrayList(array)
    fun toJson(list: List<T>): JsonArrayWrapper
}

fun <T> List<T>.toJson(
    wrapper: JsonArrayWrapper.(T) -> Unit,
) = JsonArrayWrapper().apply {
    forEach {
        wrapper(it)
    }
}

fun <T> List<T>.toJson(
    wrapper: (T) -> Unit,
) = JsonArrayWrapper().apply {
    forEach {
        wrapper(it)
    }
}