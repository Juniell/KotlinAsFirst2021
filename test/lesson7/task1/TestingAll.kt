package lesson7.task1

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import java.io.File

@Tag("CoverageAll")
class TestingAll {
    private val filesNames = mutableListOf<String>()
    private var count = 0
    private val filePath = "input" + File.separator + "Testing" + File.separator

    @AfterEach
    fun deleteAllTempFiles() {
        for (fileName in filesNames) {
            val file = File(fileName)
            if (!file.isDirectory)
                file.delete()
        }
    }

    private fun getNewFileName(): String {
        val res = "temp$count"
        count++
        filesNames.add(res)
        return res
    }

    private fun assertFilesContent(fileNameExpected: String, fileNameActual: String) {
        assertEquals(
            File(fileNameExpected).readText(),
            File(fileNameActual).readText()
        )
    }

    /**
     * Во входном файле с именем inputName содержится некоторый текст.
     * Некоторые его строки помечены на удаление первым символом _ (подчёркивание).
     * Перенести в выходной файл с именем outputName все строки входного файла, убрав при этом помеченные на удаление.
     * Все остальные строки должны быть перенесены без изменений, включая пустые строки.
     * Подчёркивание в середине и/или в конце строк значения не имеет.
     */
    @Test
    fun deleteMarked() {
        assertAll(
            // 1. Файл без удаления строк
            {
                val outputFile = getNewFileName()
                deleteMarked(filePath + "nothing_to_delete_1.txt", outputFile)
                assertFilesContent(filePath + "nothing_to_delete_1.txt", outputFile)
            },
            {
                val outputFile = getNewFileName()
                deleteMarked(filePath + "nothing_to_delete_2.txt", outputFile)
                assertFilesContent(filePath + "nothing_to_delete_2.txt", outputFile)
            },
            {
                val outputFile = getNewFileName()
                deleteMarked(filePath + "nothing_to_delete_3.txt", outputFile)
                assertFilesContent(filePath + "nothing_to_delete_3.txt", outputFile)
            },

            // 2. Файл без удаления строк с пустыми строками
            {
                val outputFile = getNewFileName()
                deleteMarked(filePath + "nothing_to_delete_with_empty_lines.txt", outputFile)
                assertFilesContent(filePath + "nothing_to_delete_with_empty_lines.txt", outputFile)
            },
            {
                val outputFile = getNewFileName()
                deleteMarked(filePath + "only_empty_lines.txt", outputFile)
                assertFilesContent(filePath + "only_empty_lines.txt", outputFile)
            },

            // 3. Пустой файл
            {
                val outputFile = getNewFileName()
                deleteMarked(filePath + "empty.txt", outputFile)
                assertFilesContent(filePath + "empty.txt", outputFile)
            },

            // 4. Файл, все строки в котором необходимо удалить
            {
                val outputFile = getNewFileName()
                deleteMarked(filePath + "delete_everything_1.txt", outputFile)
                assertFilesContent(filePath + "empty.txt", outputFile)
            },
            {
                val outputFile = getNewFileName()
                deleteMarked(filePath + "delete_everything_2.txt", outputFile)
                assertFilesContent(filePath + "empty.txt", outputFile)
            },

            // 5. Файл и с удалением строк, и без
            {
                val outputFile = getNewFileName()
                deleteMarked(filePath + "mixed.txt", outputFile)
                assertFilesContent(filePath + "mixed_ans.txt", outputFile)
            },

            // 6. Файл, в котором перемешано вообще всё: удаление, не удаление, пустые строки, подчёркивания в разных местах
            {
                val outputFile = getNewFileName()
                deleteMarked(filePath + "mixed_all.txt", outputFile)
                assertFilesContent(filePath + "mixed_all_ans.txt", outputFile)
            }
        )
    }
}