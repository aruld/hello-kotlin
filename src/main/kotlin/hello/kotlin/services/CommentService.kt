package hello.kotlin.services

import hello.kotlin.models.Comment
import io.reactivex.Flowable
import kotlinx.coroutines.flow.Flow
import reactor.core.publisher.Flux
import javax.inject.Singleton

@Singleton
class CommentService(private val blogService: BlogService) {

    fun getCommentsFlow(): Flow<Comment> = blogService.getCommentsFlow()

    fun getCommentsFlowable(): Flowable<Comment> = blogService.getCommentsFlowable()

    fun getCommentsFlux(): Flux<Comment> = blogService.getCommentsFlux()
}