package hello.kotlin.services

import hello.kotlin.models.KotlinFlowResponse
import io.reactivex.Flowable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Singleton

@Singleton
class KotlinFlowService(private val demoService: DemoService) {

    suspend fun getPosts(): Flow<List<KotlinFlowResponse>> =
            demoService.getPosts()
                    .map { eventList -> eventList.map { KotlinFlowResponse(name = it.title) } }

    fun getPostsFlowable(): Flowable<List<KotlinFlowResponse>> =
            demoService.getPostsFlowable()
                    .map { eventList -> eventList.map { KotlinFlowResponse(name = it.title) } }
}