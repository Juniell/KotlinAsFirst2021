package lesson6.fuzzing

import lesson6.task1.firstDuplicateIndex
import lesson6.task1.mostExpensive
import org.apache.commons.lang3.RandomStringUtils
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.random.Random

@Tags(Tag("CoverageFuzzer"), Tag("CoverageAllWithFuzzing"))
class Fuzzer {
    private val numOfTest = 100
    private val maxStrLen = 1000000
    private val symbols = listOf(
        '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '=', '+', '"', '№', ';',
        ':', '?', '{', '}', '[', ']', ',', '.', '<', '>', '/', '\\', '|', '\'', '←', '↑', '→', '↓', '\n', '\t'
    )

    fun generateString(): String {
        val strLength = Random.nextInt(0, maxStrLen)
        val r = RandomStringUtils.randomAscii(strLength)
        val list = (('a'..'z') + ('A'..'Z') + ('0'..'9') + symbols).toString()
        RandomStringUtils.random(Random.nextInt(0, maxStrLen), list)
        return r
    }

    @Test
    fun firstDuplicateIndex() {
        val testList = mutableListOf<() -> Unit>()
        for (i in 1..numOfTest)
            testList.add { assertDoesNotThrow { firstDuplicateIndex(generateString()) } }

        assertAll(testList)
    }

    @Test
    fun mostExpensive() {
        val testList = mutableListOf<() -> Unit>()
        for (i in 1..numOfTest)
            testList.add { assertDoesNotThrow { mostExpensive(generateString()) } }

        assertAll(testList)
    }
}
