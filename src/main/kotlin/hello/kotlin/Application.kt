package hello.kotlin

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("hello.kotlin")
                .mainClass(Application.javaClass)
                .start()
    }
}