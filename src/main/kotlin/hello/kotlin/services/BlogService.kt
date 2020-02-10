package hello.kotlin.services

import hello.kotlin.models.Comment
import hello.kotlin.models.Post
import io.reactivex.Flowable
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asPublisher
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toFlux
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BlogService {
    @Inject
    lateinit var postClient: PostClient

    @Inject
    lateinit var commentClient: CommentClient

    suspend fun getPosts(): List<Post> = postClient.posts()

    fun getPostsSingle(): Single<List<Post>> = postClient.postsSingle()

    fun getPostsMono(): Mono<List<Post>> = postClient.postsMono()

    fun getCommentsFlow(): Flow<Comment> = commentClient.commentsFlow()

    fun getCommentsFlowable(): Flowable<Comment> = Flowable.fromPublisher(commentClient.commentsFlow().asPublisher())

    fun getCommentsFlux(): Flux<Comment> = commentClient.commentsFlow().asPublisher().toFlux()

}