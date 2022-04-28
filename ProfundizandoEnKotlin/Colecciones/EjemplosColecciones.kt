fun main(args: Array<String>) {
	val ints = IntArray(10)
    for (number in ints) {
        print("$number")
    }
    
    print("")
    println("-----")
    val ints2 = intArrayOf(1, 2, 3, 4)
    for (number in ints2) {
        print("$number")
    }
    
    print("")
    println("-----")
    val ints3 = IntArray(10, { i -> i+2 })
    for (number in ints3) {
        print("$number")
    }
    
    println("")
    println("--- filter ---")
    val list = listOf("Test 1", "Test 2", "Test 3", "Test 4")
    val filterList = list.filter {
        it.contains("Test")
    }
    for (text in filterList) {
        print(text)
    }
    
    println("")
    println("--- map ---")
    val listToApplyMap = listOf("Test 1", "Test 2", "Test 3", "Test 4")
    val mapList = listToApplyMap.map {
        text -> text + ", "
    }
    for (text in mapList) {
        print(text)
    }
    
    println("")
    println("--- fold ---")
    val listToApplyFold = listOf(1, -2, 3, 4, 5)
    println("Fold: " + listToApplyFold.fold(2) {
        count, it -> count + it
    })
    
    println("")
    println("--- Any ---")
    val listToApplyAny = listOf(1, -2, 3, -4, 5)
    println("Any: " + listToApplyAny.any {
        it < 0
    })
    
    println("")
    println("--- count ---")
    println("Count: " + listToApplyAny.count {
        it < 0
    })
    
    println("")
    println("--- find ---")
    println("Find: " + listToApplyAny.find {
        it < 0
    })
    
    println("")
    println("--- Max ---")
    println("Max: " + listToApplyAny.max())
    
    println("")
    println("--- Min ---")
    println("Min: " + listToApplyAny.min())
    
    println("")
    println("--- ElementAtOrNull ---")
    println("ElementAtOrNull: " + listToApplyAny.elementAtOrNull(3))
    
    println("")
    println("--- Partition ---")
    println("Partition: " + (listToApplyAny.partition {
        it > 0
    }).first)
    
    println("")
    println("--- Sort ---")
    val intArrayToSort = intArrayOf(10, 2, 8, 4, 3)
    intArrayToSort.sort()
    for (number in intArrayToSort) {
        print("$number")
    }
}