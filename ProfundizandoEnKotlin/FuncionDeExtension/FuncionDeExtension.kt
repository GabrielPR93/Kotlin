class A (var var1: Int, var var2: Int, private var var3: Int) {
    fun sum() : Int {
        return var1 + var2
    }
}

fun A.multiply(): Int {
    return this.var1 * this.var2 * sum() //* this.var3
}

fun Int.isPar(): Boolean {
    return this % 2 == 0
}

fun Int.isPositive(): Boolean {
    return this >= 0
}

fun Int.multiply(number: Int): Int {
    return this * number
}
 
fun String.upperCaseFirstLetter(): String {
    return if(this.count() > 0) this.substring(0, 1).toUpperCase().plus(this.substring(1)) else ""
}

fun main(args: Array<String>) {
	var number1: Int = 10
    var number2: Int = -10
    var text = ""
    println("Es positivo: " + number1.isPositive())
    println("$number1 ¿es par?: " + number1.isPar())
    println("Es positivo: " + number2.isPositive())
    println("Multiply: " + number1.multiply(10))
    println(text.upperCaseFirstLetter())
    
    println("")
    println("--- Función de extensión de A ---")
    var objectA = A(1, 6, 10)
    println("Sum: " + objectA.sum())
    println("Multiply: " + objectA.multiply())
}