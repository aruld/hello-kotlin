package hello.kotlin.services

import hello.kotlin.models.Headline
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import kotlinx.coroutines.flow.Flow

@Client("/streaming")
interface HeadlineFlowClient {
    @Get(value = "/headlinesWithFlow", processes = [MediaType.APPLICATION_JSON_STREAM])
    fun streamFlow(): Flow<Headline>
}