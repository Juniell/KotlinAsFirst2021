package lesson5.fuzzing

import lesson5.task1.findSumOfTwo
import org.junit.jupiter.api.*
import kotlin.random.Random

@Tags(Tag("CoverageFuzzer"), Tag("CoverageAllWithFuzzing"))
class Fuzzer {
    private val numOfTest = 100
    private val maxListSize = 100000

    private fun generateList(): List<Int> {
        val listSize = Random.nextInt(0, maxListSize)
        val list = mutableListOf<Int>()

        for (i in 0..listSize)
            list.add(Random.nextInt())
        return list
    }

    @Test
    fun findSumOfTwo() {
        val testList = mutableListOf<() -> Unit>()
        for (i in 1..numOfTest)
            testList.add { Assertions.assertDoesNotThrow { findSumOfTwo(generateList(), Random.nextInt()) } }

        assertAll(testList)
    }
}