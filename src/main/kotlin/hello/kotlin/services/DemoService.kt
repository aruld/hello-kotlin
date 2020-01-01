package hello.kotlin.services

import hello.kotlin.models.Post
import io.reactivex.Flowable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import reactor.core.publisher.Flux
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DemoService {
    @Inject
    lateinit var webClient: DemoClient

    fun getPosts(): Flow<List<Post>> =
            flow {
                webClient.posts()
            }

    fun getPostsFlowable(): Flowable<List<Post>> =
            webClient.posts()

    fun getPostsFlux(): Flux<List<Post>> =
            Flux.from(webClient.posts())
}