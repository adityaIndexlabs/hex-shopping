/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package hex.shopping.app

import hex.shopping.utilities.StringUtils

fun main() {
    val tokens = StringUtils.split(MessageUtils.getMessage())
    println(StringUtils.join(tokens))
}
