package jp.co.pluswing.mysqlsample.sample

import org.springframework.boot.autoconfigure.SpringBootApplication
import kotlin.jvm.JvmStatic
import org.springframework.boot.SpringApplication

@SpringBootApplication
open class SampleApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(SampleApplication::class.java, *args)
        }
    }
}

/*
@SpringBootApplication
open class SampleApplication

fun main(args: Array<String>) {
    SpringApplication.run(SampleApplication::class.java, *args)
}
*/
