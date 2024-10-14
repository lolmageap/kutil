package cherhy.batch.settlement.util.extension

import java.math.BigDecimal

fun Any?.noReturn() = Unit

fun Any.toBigDecimal(): BigDecimal =
    this.toString().toBigDecimalOrNull() ?: BigDecimal.ZERO

fun Any?.toInt(): Int =
    this?.toString()?.toIntOrNull() ?: 0

fun Any?.toLong(): Long =
    this?.toString()?.toLongOrNull() ?: 0