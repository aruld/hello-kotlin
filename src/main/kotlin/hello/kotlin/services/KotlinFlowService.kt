package hello.kotlin.services

import hello.kotlin.models.Post
import io.reactivex.Flowable
import kotlinx.coroutines.flow.Flow
import reactor.core.publisher.Flux
import javax.inject.Singleton

@Singleton
class KotlinFlowService(private val demoService: DemoService) {

    suspend fun getPosts(): Flow<List<Post>> = demoService.getPosts()

    fun getPostsFlowable(): Flowable<List<Post>> = demoService.getPostsFlowable()

    fun getPostsFlux(): Flux<List<Post>> = demoService.getPostsFlux()
}