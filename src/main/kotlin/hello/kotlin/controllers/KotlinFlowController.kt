package hello.kotlin.controllers

import hello.kotlin.models.Headline
import hello.kotlin.models.Post
import hello.kotlin.services.KotlinFlowService
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Status
import io.reactivex.Flowable
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.slf4j.LoggerFactory
import reactor.core.publisher.Flux
import java.time.ZonedDateTime

@Controller("/")
class KotlinFlowController(private val kotlinFlowService: KotlinFlowService) {

    private val logger = LoggerFactory.getLogger(KotlinFlowController::class.java)

    @Get("/simple")
    suspend fun simple(): String {
        return "Hello"
    }

    @Get("/delayed")
    suspend fun delayed(): String {
        delay(10000)
        return "Delayed"
    }

    @Status(HttpStatus.CREATED)
    @Get("/status")
    suspend fun status(): Unit {
    }

    @Status(HttpStatus.CREATED)
    @Get("/statusDelayed")
    suspend fun statusDelayed(): Unit {
        delay(1)
    }

    @Get(value = "/headlinesWithFlow", processes = [MediaType.APPLICATION_JSON_STREAM])
    internal fun streamHeadlinesWithFlow(): Flow<Headline> =
            flow {
                repeat(100) {
                    with(Headline()) {
                        title = "Latest Headline at " + ZonedDateTime.now()
                        emit(this)
                        delay(1_000)
                    }
                }
            }

    @Get("/posts", produces = [MediaType.APPLICATION_JSON])
    suspend fun getPosts(): Flow<List<Post>> {
        logger.info("Getting posts (Kotlin Flow) from demo service ... ")
        return kotlinFlowService.getPosts()
    }

    @Get("/postsFlowable", produces = [MediaType.APPLICATION_JSON])
    fun getPostsFlowable(): Flowable<List<Post>> {
        logger.info("Getting posts (RxJava) from demo service ... ")
        return kotlinFlowService.getPostsFlowable()
    }

    @Get("/postsFlux", produces = [MediaType.APPLICATION_JSON])
    fun getPostsFlux(): Flux<List<Post>> {
        logger.info("Getting posts (Reactor Flux) from demo service ... ")
        return kotlinFlowService.getPostsFlux()
    }
}