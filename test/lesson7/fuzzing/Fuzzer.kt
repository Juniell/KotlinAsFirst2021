package lesson7.fuzzing

import lesson6.fuzzing.Fuzzer
import lesson7.task1.deleteMarked
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import java.io.File

@Tags(Tag("CoverageFuzzer"), Tag("CoverageAllWithFuzzing"))
class Fuzzer {
    private val filePath = "input" + File.separator + "Testing" + File.separator + "fuzzing.txt"
    private val numOfTest = 100

    private fun clearFile(filePath: String) {
        writeToFile(filePath, "")
    }

    private fun writeToFile(filePath: String, str: String) {
        val file = File(filePath)
        val fw = file.bufferedWriter()
        fw.write(str)
        fw.close()
    }

    @AfterEach
    fun deleteOutputFile() {
        File("outputFile.txt").delete()
    }

    @Test
    fun deleteMarked() {
        val testList = mutableListOf<() -> Unit>()
        for (i in 1..numOfTest)
            testList.add {
                writeToFile(filePath, Fuzzer().generateString())
                assertDoesNotThrow { deleteMarked(filePath, "outputFile.txt") }
                clearFile(filePath)
                clearFile("outputFile.txt")
            }

        assertAll(testList)
    }
}