package hello.kotlin.services

import hello.kotlin.models.Post
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.reactivex.Flowable

@Client("\${demoservice.url}")
interface DemoClient {
    @Get
    fun posts(): Flowable<List<Post>>
}