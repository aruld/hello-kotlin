package hello.kotlin.models

class Comment {
    var id: Int = 0
    var text: String? = null

    constructor()

    constructor(id: Int, text: String) {
        this.id = id
        this.text = text
    }
}