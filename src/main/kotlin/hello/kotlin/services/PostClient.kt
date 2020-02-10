package hello.kotlin.services

import hello.kotlin.models.Post
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.reactivex.Single
import reactor.core.publisher.Mono

@Client("\${demoservice.url}")
interface PostClient {
    @Get
    suspend fun posts(): List<Post>

    @Get
    fun postsSingle(): Single<List<Post>>

    @Get
    fun postsMono(): Mono<List<Post>>

}