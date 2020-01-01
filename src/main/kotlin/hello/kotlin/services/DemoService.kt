package hello.kotlin.services

import hello.kotlin.models.Post
import io.micronaut.core.type.Argument
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.reactivex.Flowable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import reactor.core.publisher.Flux
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DemoService {
    @field:Client("\${demoservice.url}")
    @Inject
    lateinit var webClient: RxHttpClient

    fun getPosts(): Flow<List<Post>> =
            flow {
                webClient.retrieve(HttpRequest.GET<Any>("/"), Argument.listOf(Post::class.java))
            }

    fun getPostsFlowable(): Flowable<List<Post>> =
            webClient.retrieve(HttpRequest.GET<Any>("/"), Argument.listOf(Post::class.java))

    fun getPostsFlux(): Flux<List<Post>> =
            Flux.from(webClient.retrieve(HttpRequest.GET<Any>("/"), Argument.listOf(Post::class.java)))

}