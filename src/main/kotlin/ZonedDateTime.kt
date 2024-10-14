package cherhy.batch.settlement.util.extension

import java.time.ZoneOffset
import java.time.ZonedDateTime

infix fun ZonedDateTime.isBetween(
    dates: Pair<ZonedDateTime?, ZonedDateTime?>,
) =
    when {
        dates.first == null && dates.second == null -> false
        dates.first == null -> this <= dates.second
        dates.second == null -> this >= dates.first
        else -> this >= dates.first && this <= dates.second
    }

fun ZonedDateTime.toSeoulTime(): ZonedDateTime =
    this.plusHours(9)

fun ZonedDateTime.toSeoulZone(): ZonedDateTime =
    this.withZoneSameInstant(ZoneOffset.ofHours(9))