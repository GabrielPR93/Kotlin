fun main(args: Array<String>) {
    val ints = IntArray(10)
    for (number in ints) {
        print("$number ")
    }
    
    println("")
    println("-------")
    
    val ints2: IntArray = intArrayOf(1, 2, 3, 4)
    for (number in ints2) {
        print("$number ")
    }
    
    println("")
    println("-------")
    
    val ints3 = IntArray(10, { i -> i+2 })
    for (number in ints3) {
        print("$number ")
    }
    
    println("")
    println("-------")
    
    val list: List<String> = listOf("Test 1", "Test 2", "Test 3", "Test 4")
    val filterList = list.filter({ it.contains("2") })
    for (text in filterList) {
        print(text)
    }
    
    println("")
    println("--- map ---")
    
    val listToApplyMap: List<String> = listOf("Test 1", "Test 2", "Test 3", "Test 4")
    val mapList = listToApplyMap.map({ text -> text + "test, " })
    for (text in mapList) {
        print(text)
    }
    
    println("")
    println("--- fold ---")
    
    val listToApplyFold: List<Int> = listOf(1, 2, 3, 4, 5)
    println("Fold: " + listToApplyFold.fold(2) {
        count, it -> count + it
    })
    
    println("")
    println("--- Any ---")
    
    val listToApplyAny: List<Int> = listOf(1, -2, 3, 4, 5)
    println("Any: " + listToApplyAny.any {
        it < 0
    })
    
    println("")
    println("--- Count ---")
    
    println("Count: " + listToApplyAny.count {
        it < 0
    })
    
    println("")
    println("--- Find ---")
    
    println("Find: " + listToApplyAny.find {
        it < 0
    })
    
    println("")
    println("-- Max ---")
    
    println("Max: " + listToApplyAny.max())
    
    println("")
    println("--- Min ---")
    
    println("Min: " + listToApplyAny.min())
    
    println("")
    println("--- ElementAtOrNull ---")
    
    println("ElementAtOrNull: " + listToApplyAny.elementAtOrNull(10))
    
    println("")
    println("--- Partition ---")
    
    println("Partition: " + listToApplyAny.partition {
        it < 0
    })
    
    println("")
    println("--- Sort ---")
    
    val intArrayToSort: IntArray = intArrayOf(10, 2, 8, 4, 3)
    intArrayToSort.sort()
    for (text in intArrayToSort) {
        print("$text ")
    }
}