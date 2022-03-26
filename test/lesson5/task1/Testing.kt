package lesson5.task1

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("Coverage")
class Testing {
    /**
     * Для заданного списка неотрицательных чисел и числа определить,
     * есть ли в списке пара чисел таких, что их сумма равна заданному числу.
     * Если да, верните их индексы в виде Pair<Int, Int>;
     * если нет, верните пару Pair(-1, -1).
     *
     * Индексы в результате должны следовать в порядке (меньший, больший).
     *
     * Постарайтесь сделать ваше решение как можно более эффективным,
     * используя то, что вы узнали в данном уроке.
     *
     * Например:
     *   findSumOfTwo(listOf(1, 2, 3), 4) -> Pair(0, 2)
     *   findSumOfTwo(listOf(1, 2, 3), 6) -> Pair(-1, -1)
     */
    @Test
    fun findSumOfTwo() {
        // 1. Неотрицательные числа, "без подвоха"
        Assertions.assertEquals(
            Pair(1, 2),
            findSumOfTwo(
                listOf(1, 2, 3),
                5
            )
        )
        Assertions.assertEquals(
            Pair(3, 4),
            findSumOfTwo(
                listOf(1, 10, 100, 1000, 10000, 20000),
                11000
            )
        )
        Assertions.assertEquals(
            Pair(0, 5),
            findSumOfTwo(
                listOf(1, 10, 100, 1000, 10000, 20000),
                20001
            )
        )

        // 2. Отсутствие решения
        Assertions.assertEquals(
            Pair(-1, -1),
            findSumOfTwo(
                listOf(1, 2, 3, 4, 5),
                10
            )
        )
        Assertions.assertEquals(
            Pair(-1, -1),
            findSumOfTwo(
                listOf(1, 1, 1, 1, 1),
                3
            )
        )

        // 3. Работа с пустым списком
        Assertions.assertEquals(
            Pair(-1, -1),
            findSumOfTwo(
                listOf(),
                10
            )
        )
        Assertions.assertEquals(
            Pair(-1, -1),
            findSumOfTwo(
                listOf(),
                0
            )
        )

        // 4. Работа со списком из одного элемента
        Assertions.assertEquals(
            Pair(-1, -1),
            findSumOfTwo(
                listOf(1),
                1
            )
        )
        Assertions.assertEquals(
            Pair(-1, -1),
            findSumOfTwo(
                listOf(1),
                2
            )
        )

        // 5. Работа с 0
        Assertions.assertEquals(
            Pair(-1, -1),
            findSumOfTwo(
                listOf(1, 2, 0),
                0
            )
        )
        Assertions.assertEquals(
            Pair(0, 1),
            findSumOfTwo(
                listOf(0, 0),
                0
            )
        )
        Assertions.assertEquals(
            Pair(0, 2),
            findSumOfTwo(
                listOf(0, 100, 0),
                0
            )
        )

        // 6. Наличие отрицательных чисел во входных данных
        // Так как в задании про отрицательные числа сказано только то, что их не должно быть,
        // было выдвинуто предположение, что функция должна проверять наличие отрицательных чисел и выбрасывать исключение
        Assertions.assertThrows(Exception::class.java) { findSumOfTwo(listOf(-1, -2, -3), 1) }
        Assertions.assertThrows(Exception::class.java) { findSumOfTwo(listOf(1, 2, 3), -1) }
        Assertions.assertThrows(Exception::class.java) { findSumOfTwo(listOf(-1, -2, -3), -4) }

        // 7. number можно составить из суммы числа с самим собой
        Assertions.assertEquals(
            Pair(-1, -1),
            findSumOfTwo(
                listOf(5, 4, 2),
                8
            )
        )
        Assertions.assertEquals(
            Pair(-1, -1),
            findSumOfTwo(
                listOf(1, 2, 1, 1, 1),
                4
            )
        )
        Assertions.assertEquals(
            Pair(1, 2),
            findSumOfTwo(
                listOf(3, 1, 5),
                6
            )
        )

        // 8. Работа с макс инт
        Assertions.assertEquals(
            Pair(0, 1),
            findSumOfTwo(
                listOf(Int.MAX_VALUE / 2, Int.MAX_VALUE / 2 + 1, 1),
                Int.MAX_VALUE
            )
        )
        Assertions.assertEquals(
            Pair(2, 3),
            findSumOfTwo(
                listOf(Int.MAX_VALUE, Int.MAX_VALUE, 0, 1),
                1
            )
        )

        // 9. Порядок индексов в паре как (меньший индекс, больший индекс)
        val resInd1 = findSumOfTwo(
            listOf(11, 5, 10, 3),
            14
        )
        val resInd2 = findSumOfTwo(
            listOf(3, 5, 10, 11),
            14
        )
        Assertions.assertTrue(resInd1.first < resInd1.second)
        Assertions.assertTrue(resInd2.first < resInd2.second)
        Assertions.assertEquals(resInd1, resInd2)
        Assertions.assertEquals(Pair(0, 3), resInd1)
        Assertions.assertEquals(Pair(0, 3), resInd2)


        // 10. Несколько вариантов составления пары.
        // Так как в задании напрямую не указано, что функция должна вернуть в таком случае,
        // будем ожидать, что она вернёт любую пару
        val resPair1 = findSumOfTwo(
            listOf(1, 1, 1),
            2
        )
        Assertions.assertTrue(resPair1 == Pair(0, 1) || resPair1 == Pair(0, 2) || resPair1 == Pair(1, 2))

        val resPair2 = findSumOfTwo(
            listOf(0, 1, 2, 3, 4, 5),
            5
        )
        Assertions.assertTrue(resPair2 == Pair(0, 5) || resPair2 == Pair(1, 4) || resPair2 == Pair(2, 3))
    }
}