class A (var var1: Int, var var2: Int, private var var3: Int) {
    fun sum(): Int {
        return var1 + var2 + var3
    }
}

fun A.multiply(): Int {
    return this.var1 * this.var2
}

fun Int.isPair(): Boolean {
    return this % 2 == 0
}

fun Int.isPositive(): Boolean {
    return this >= 0
}

fun String.upperCaseFirstLetter(): String {
    return if (this.count() > 0) this.substring(0, 1).toUpperCase().plus(this.substring(1)) else ""
}

fun main(args: Array<String>) {
	var objectA = A(1, 2, 3)
    println("Suma: " + objectA.sum())
    
    println("")
    println("--- Extensión de A ---")
    println("Multiply: " + objectA.multiply())
    
    println("")
    println("--- Extensión de Int ---")
    var number1 = 10
    var number2 = 3
    var number3 = -10
    println("¿Es par? " + number1.isPair())
    println("¿Es par? " + number2.isPair())
    println("¿Es positivo? " + number2.isPositive())
    println("¿Es positivo? " + number3.isPositive())
    
    println("")
    println("--- Extensión de String ---")
    var text = "hola"
    println(text.upperCaseFirstLetter())
    println("curso".upperCaseFirstLetter())
}
