package hello.kotlin.controllers

import hello.kotlin.models.Comment
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.ZonedDateTime

@Controller("/streaming")
class StreamingController {

    @Get(value = "/commentsWithFlow", processes = [MediaType.APPLICATION_JSON_STREAM])
    internal fun streamCommentsWithFlow(): Flow<Comment> =
            flow {
                var curDelay = 1000L
                var counter = 0
                repeat(5) {
                    with(Comment()) {
                        counter = counter.inc()
                        id = counter
                        text = "Latest Comment at " + ZonedDateTime.now()
                        emit(this)
                        delay(curDelay)
                        curDelay = (curDelay * 2).coerceAtMost(600L)
                    }
                }
            }
}