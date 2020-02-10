package hello.kotlin.controllers

import hello.kotlin.models.Post
import hello.kotlin.services.PostService
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.reactivex.Single
import org.slf4j.LoggerFactory
import reactor.core.publisher.Mono

@Controller
class PostController(private val postService: PostService) {

    private val logger = LoggerFactory.getLogger(PostController::class.java)

    @Get("/posts", produces = [MediaType.APPLICATION_JSON])
    suspend fun getPosts(): List<Post> {
        logger.info("Getting posts (Kotlin Coroutines) from demo service ... ")
        return postService.getPosts()
    }

    @Get("/postsSingle", produces = [MediaType.APPLICATION_JSON])
    fun getPostsSingle(): Single<List<Post>> {
        logger.info("Getting posts (RxJava) from demo service ... ")
        return postService.getPostsSingle()
    }

    @Get("/postsMono", produces = [MediaType.APPLICATION_JSON])
    fun getPostsMono(): Mono<List<Post>> {
        logger.info("Getting posts (Reactor Flux) from demo service ... ")
        return postService.getPostsMono()
    }

}