import dev.fritz2.dom.html.render
import dev.fritz2.dom.mount

fun main() {
    render {
        p {
            +("Hello World!")
        }
    }.mount("target")
}