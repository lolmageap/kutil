package cherhy.batch.settlement.util.extension

fun <T> Iterable<T>.isNotContains(
    value: T
) =
    !this.contains(value)