fun error(): Nothing {
    throw RuntimeException()
}

fun main(args: Array<String>) {
	val number: String? = "hola"
    
    val count: Int = try {
        number!!.count()
    } catch (e: Exception) {
        0
    }
    
    println("Count: " + count)
    
    //error()
    
    number?.let { println(number) } ?: error()
}