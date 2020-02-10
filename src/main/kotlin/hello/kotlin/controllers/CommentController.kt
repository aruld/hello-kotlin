package hello.kotlin.controllers

import hello.kotlin.models.Comment
import hello.kotlin.services.CommentService
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.reactivex.Flowable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.slf4j.LoggerFactory
import reactor.core.publisher.Flux

@Controller
class CommentController(private val commentService: CommentService) {

    private val logger = LoggerFactory.getLogger(CommentController::class.java)

    @Get("/comments", processes = [MediaType.APPLICATION_JSON_STREAM])
    internal fun getPosts(): Flow<Comment> = flow {
        logger.info("Getting comments (Kotlin Flow) from comment service ... ")
        commentService.getCommentsFlow()
    }

    @Get("/commentsFlowable", processes = [MediaType.APPLICATION_JSON_STREAM])
    internal fun getPostsSingle(): Flowable<Comment> {
        logger.info("Getting comments (RxJava Flowable) from comment service ... ")
        return commentService.getCommentsFlowable()
    }

    @Get("/commentsFlux", processes = [MediaType.APPLICATION_JSON_STREAM])
    internal fun getPostsMono(): Flux<Comment> {
        logger.info("Getting comments (Reactor Flux) from comment service ... ")
        return commentService.getCommentsFlux()
    }
}