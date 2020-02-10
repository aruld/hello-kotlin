package hello.kotlin.services

import hello.kotlin.models.Post
import io.reactivex.Single
import reactor.core.publisher.Mono
import javax.inject.Singleton

@Singleton
class PostService(private val blogService: BlogService) {

    suspend fun getPosts(): List<Post> = blogService.getPosts()

    fun getPostsSingle(): Single<List<Post>> = blogService.getPostsSingle()

    fun getPostsMono(): Mono<List<Post>> = blogService.getPostsMono()

}