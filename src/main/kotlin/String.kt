package cherhy.batch.settlement.util.extension

import java.time.LocalDate
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*

fun String.toSnakeCase(): String {
    val value =
        if (this.contains("-")) return this.replace("-", "_", true)
        else this
    return value.replace(Regex("([a-z])([A-Z]+)"), "$1_$2").lowercase(Locale.getDefault())
}

fun String.toKebabCase(): String {
    val value =
        if (this.contains("_")) return this.replace("_", "-", true)
        else this
    return value.replace(Regex("([a-z])([A-Z]+)"), "$1-$2").lowercase(Locale.getDefault())
}

fun String.toCamelCase(): String {
    val value = this.replace(Regex("([a-z])([A-Z]+)"), "$1_$2").lowercase(Locale.getDefault())
    val characters = value.split("_", "-")
    val firstWord = characters.first().lowercase(Locale.getDefault())
    val camelCase =
        characters.drop(1)
            .joinToString("") { word ->
                word.replaceFirstChar { it.uppercaseChar() }
            }
    return firstWord + camelCase
}

fun String.toPascalCase(): String {
    val value = this.replace(Regex("([a-z])([A-Z]+)"), "$1_$2").lowercase(Locale.getDefault())
    val characters = value.split("_", "-")
    val firstWord = characters.first().replaceFirstChar { it.uppercaseChar() }
    val pascalCase =
        characters.drop(1)
            .joinToString("") { word ->
                word.replaceFirstChar { it.titlecase(Locale.getDefault()) }
            }
    return firstWord + pascalCase
}

fun String.toLocalDate(): LocalDate {
    val data = this.replace("-", "").substring(0, 8)
    return LocalDate.parse(data, DateTimeFormatter.ofPattern("yyyyMMdd"))
}

fun String.isNumber() =
    this.matches(Regex("^[0-9]*\$"))

fun String.toZonedDateTime(): ZonedDateTime {
    val year = if (this.length >= 4) this.substring(0, 4).toInt() else 0
    val month = if (this.length >= 6) this.substring(4, 6).toInt() else 0
    val day = if (this.length >= 8) this.substring(6, 8).toInt() else 0
    val hour = if (this.length >= 10) this.substring(8, 10).toInt() else 0
    val minute = if (this.length >= 12) this.substring(10, 12).toInt() else 0
    val second = if (this.length >= 14) this.substring(12, 14).toInt() else 0
    val nanoSecond = if (this.length >= 17) this.substring(14, 17).toInt() * 1000000 else 0

    return ZonedDateTime.of(year, month, day, hour, minute, second, nanoSecond, ZoneOffset.UTC)
}