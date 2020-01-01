package hello.kotlin.models

class Post {
    var id: Int = 0
    var title: String? = null

    constructor()

    constructor(id: Int, title: String) {
        this.id = id
        this.title = title
    }
}