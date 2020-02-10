package hello.kotlin.services

import hello.kotlin.models.Comment
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.reactivex.Flowable
import kotlinx.coroutines.flow.Flow
import reactor.core.publisher.Flux

@Client("/streaming")
interface CommentClient {

    @Get(value = "/commentsWithFlow", processes = [MediaType.APPLICATION_JSON_STREAM])
    fun commentsFlow(): Flow<Comment>

//    @Get
//    fun commentsFlowable(): Flowable<Comment>
//
//    @Get
//    fun commentsFlux(): Flux<Comment>
}