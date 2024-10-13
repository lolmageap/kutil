import cherhy.batch.settlement.util.extension.toCamelCase
import cherhy.batch.settlement.util.extension.toKebabCase
import cherhy.batch.settlement.util.extension.toPascalCase
import cherhy.batch.settlement.util.extension.toSnakeCase
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringTest: StringSpec({
    "toSnakeCase" {
        "hello_world".toSnakeCase() shouldBe "hello_world"
        "hello-world".toSnakeCase() shouldBe "hello_world"
        "helloWorld".toSnakeCase() shouldBe "hello_world"
        "HelloWorld".toSnakeCase() shouldBe "hello_world"
    }

    "toCamelCase" {
        "hello_world".toCamelCase() shouldBe "helloWorld"
        "hello-world".toCamelCase() shouldBe "helloWorld"
        "helloWorld".toCamelCase() shouldBe "helloWorld"
        "HelloWorld".toCamelCase() shouldBe "helloWorld"
    }

    "toPascalCase" {
        "hello_world".toPascalCase() shouldBe "HelloWorld"
        "hello-world".toPascalCase() shouldBe "HelloWorld"
        "helloWorld".toPascalCase() shouldBe "HelloWorld"
        "HelloWorld".toPascalCase() shouldBe "HelloWorld"
    }

    "toKebabCase" {
        "hello_world".toKebabCase() shouldBe "hello-world"
        "hello-world".toKebabCase() shouldBe "hello-world"
        "helloWorld".toKebabCase() shouldBe "hello-world"
        "HelloWorld".toKebabCase() shouldBe "hello-world"
    }
})