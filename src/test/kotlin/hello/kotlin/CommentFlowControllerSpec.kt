package hello.kotlin

import hello.kotlin.services.CommentClient
import io.kotlintest.matchers.string.shouldStartWith
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.StringSpec
import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.RxHttpClient
import io.micronaut.runtime.server.EmbeddedServer
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList

class CommentFlowControllerSpec : StringSpec() {

    val embeddedServer = autoClose(
            ApplicationContext.run(EmbeddedServer::class.java)
    )

    val client = autoClose(
            embeddedServer.applicationContext.createBean(RxHttpClient::class.java, embeddedServer.url)
    )

    init {
        "test client annotation streaming with Flow" {
            val commentClient = embeddedServer
                    .applicationContext
                    .getBean(CommentClient::class.java)

            val comment = commentClient.commentsFlow().take(1).toList().first()

            comment shouldNotBe null
            comment.text shouldStartWith "Latest Comment"
        }
    }
}