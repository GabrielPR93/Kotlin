class A (var number: Int, var text: String)

fun iterateListWithLambda(list: List<Int>, function: (number: Int) -> Unit) {
    list.map { 
        println("Test: " + it)
        function(it)
    }
}

fun executeMethodsIfNumberIsPair(number: Int, pair: () -> Unit, odd: () -> Unit) {
    if (number % 2 == 0) pair() else odd()
}

fun main(args: Array<String>) {
	val objectList = listOf(A(1, "Test"),
                        A(2, "Test 2"),
                        A(3,"Test 3"))
    val intList = listOf(1, 2, 3, 4)
    
    println("--- Antes de la lambda ---")
    objectList.map { println(it.number) }
    
    println("")
    println("--- Después de la lambda ---")
    //intList.map { value: A -> value.number++ }
    objectList.map { it.number++ }
    objectList.map { println(it.number) }
    
    println("")
    println("--- Ejecutar método con lambda ---")
    var number = 0
    iterateListWithLambda(intList, {
        number += it
    })
    println("Number: " + number)
    
    println("")
    println("--- Ejecutar método executeMethodsIfNumberIsPair ---")
    executeMethodsIfNumberIsPair(11, {
        println("Es par")
    }, {
        println("No es par")
    })
}