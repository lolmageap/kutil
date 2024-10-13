package cherhy.batch.settlement.util.extension

import kotlin.reflect.KProperty

fun KProperty<*>.toSnakeCase() = this.name.toSnakeCase()
fun KProperty<*>.toCamelCase() = this.name.toCamelCase()
fun KProperty<*>.toPascalCase() = this.name.toPascalCase()
fun KProperty<*>.toKebabCase() = this.name.toKebabCase()