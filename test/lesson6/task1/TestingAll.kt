package lesson6.task1

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

@Tag("CoverageAll")
class TestingAll {
    /**
     * Строка состоит из набора слов, отделённых друг от друга одним пробелом.
     * Определить, имеются ли в строке повторяющиеся слова, идущие друг за другом.
     * Слова, отличающиеся только регистром, считать совпадающими.
     * Вернуть индекс начала первого повторяющегося слова, или -1, если повторов нет.
     * Пример: "Он пошёл в в школу" => результат 9 (индекс первого 'в')
     */
    @Test
    fun firstDuplicateIndex() {
        assertAll(
            // 1. Нижний регистр, есть повторения, "без подвоха"
            { Assertions.assertEquals(16, firstDuplicateIndex("в лесу родилась ёлочка ёлочка")) },
            { Assertions.assertEquals(0, firstDuplicateIndex("в в лесу она росла")) },
            { Assertions.assertEquals(11, firstDuplicateIndex("the forest raised raised a christmas tree")) },
            { Assertions.assertEquals(5, firstDuplicateIndex("twas silent silent and serene")) },

            // 2. Нижний регистр, без повторов
            { Assertions.assertEquals(-1, firstDuplicateIndex("в лесу родилась ёлочка")) },
            { Assertions.assertEquals(-1, firstDuplicateIndex("в лесу она росла")) },
            { Assertions.assertEquals(-1, firstDuplicateIndex("the forest raised a Christmas tree")) },
            { Assertions.assertEquals(-1, firstDuplicateIndex("twas silent and serene")) },

            // 3. Нет слов
            { Assertions.assertEquals(-1, firstDuplicateIndex("")) },

            // 4. Одно слово
            { Assertions.assertEquals(-1, firstDuplicateIndex("слово")) },
            { Assertions.assertEquals(-1, firstDuplicateIndex("абвгдеёжзийклмнопрстуфхцчшщъыьэюя")) },
            { Assertions.assertEquals(-1, firstDuplicateIndex("abcdefghijklmnopqrstuvwxyz")) },

            // 5. Слова в словах
            { Assertions.assertEquals(-1, firstDuplicateIndex("новосёл осёл сёл ёл л")) },
            { Assertions.assertEquals(-1, firstDuplicateIndex("графиня графин графи граф гра гр г")) },
            {
                Assertions.assertEquals(
                    -1,
                    firstDuplicateIndex("brainstorm brainstor brainsto brainst brains brain brai bra br b")
                )
            },

            // 6. Разный регистр
            { Assertions.assertEquals(16, firstDuplicateIndex("в лесу родилась ЁЛОЧКА ёлочка")) },
            {
                Assertions.assertEquals(
                    firstDuplicateIndex("в лесу родилась ЁЛОЧКА ёлочка"),
                    firstDuplicateIndex("в лесу родилась ёлочка ЁЛОЧКА")
                )
            },
            {
                Assertions.assertEquals(
                    firstDuplicateIndex("в лесу родилась ЁЛОЧКА ёлочка"),
                    firstDuplicateIndex("в лесу родилась ЁлОчКа ёЛоЧкА")
                )
            },

            // 7. Слова из разных комбинаций букв, символов и цифр
            {
                Assertions.assertEquals(
                    18,
                    firstDuplicateIndex("8oeze0\"kkag%gh!j3 %hдcв0\\b %hдcв0\\b slyc\$erzsyqvfj%0 h!mr9cs y0s c6x%tlc&sotpg\$ugom6l xq1l% vacmo\$nw29kki63!xphypf")
                )
            },
            {
                Assertions.assertEquals(
                    50,
                    firstDuplicateIndex("8oeze0\"kkag%gh!j3 %hc0\\b slyc\$erzsyqvfj%0 h!mr9cs y0s y0s c6x%tlc&sotpg\$ugom6l xq1l% vacmo\$nw29kki63!xphypf")
                )
            },
            {
                Assertions.assertEquals(
                    -1,
                    firstDuplicateIndex("8oeze0\"kkag%gh!j3 %hдcв0\\b slyc\$erzsyqvfj%0 h!mr9cs y0s c6x%tlc&sotpg\$ugom6l xq1l% vacmo\$nw29kki63!xphypf")
                )
            },
            {
                Assertions.assertEquals(
                    0,
                    firstDuplicateIndex("123woт_эт0%4_словe4k0!! 123woт_эт0%4_словe4k0!!")
                )
            },
            {
                Assertions.assertEquals(
                    -1,
                    firstDuplicateIndex("123woт_эт0%4_словe4k0!! а_%383№*\"_et0_?!123w_dруg0е%4_словe4k0!!")
                )
            },

            // 8. Слова из разных комбинаций букв, символов и цифр + разный регистр
            {
                Assertions.assertEquals(
                    18,
                    firstDuplicateIndex("8oeZe0\"KKag%GH!J3 %hДC0В\\b %hДC0В\\b sLYc\$ErZsyqVfj%0 h!mR9cS y0S C6x%TLc&SOTpG\$uGOm6L xq1L% vACmO\$Nw29kKi63!xphypF")
                )
            },
            {
                Assertions.assertEquals(
                    50,
                    firstDuplicateIndex("8oeZe0\"KKag%GH!J3 %hC0\\b sLYc\$ErZsyqVfj%0 h!mR9cS y0S y0S C6x%TLc&SOTpG\$uGOm6L xq1L% vACmO\$Nw29kKi63!xphypF")
                )
            },
            {
                Assertions.assertEquals(
                    -1,
                    firstDuplicateIndex("8oeZe0\"KKag%GH!J3 %hДC0В\\b sLYc\$ErZsyqVfj%0 h!mR9cS y0S C6x%TLc&SOTpG\$uGOm6L xq1L% vACmO\$Nw29kKi63!xphypF")
                )
            },
            {
                Assertions.assertEquals(
                    0,
                    firstDuplicateIndex("123Woт_Эт0%4_слОвe4k0!! 123Woт_Эт0%4_слОвe4k0!!")
                )
            },
            {
                Assertions.assertEquals(
                    -1,
                    firstDuplicateIndex("23Woт_Эт0%4_слОвe4k0!! А_%383№*\"_Et0_?!123w_DруG0е%4_СлOвe4k0!!")
                )
            },

            // 9. Множество повторов подряд
            { Assertions.assertEquals(0, firstDuplicateIndex("а А а А а А а А а А а А")) },
            { Assertions.assertEquals(0, firstDuplicateIndex("Мяу мяу мяУ МЯУ мЯу МяУ МЯу мЯУ")) },
            { Assertions.assertEquals(4, firstDuplicateIndex("ГАВ Мяу мяу мяУ МЯУ мЯу МяУ МЯу мЯУ гав")) },
            { Assertions.assertEquals(9, firstDuplicateIndex("42! о42! 42! 42! 42! 42! 42! 42! 42! 42!")) },

            // 10. Множество повторов в разных местах
            { Assertions.assertEquals(0, firstDuplicateIndex("а А а б Б б А а А Б б Б а А а Б б Б А а А")) },
            {
                Assertions.assertEquals(
                    9,
                    firstDuplicateIndex("Гав! гав Мяу мяу мяУ ГАв ГАВ гАВ гАв МЯУ гав ГАВ мЯу МяУ гав МЯу гаВ мЯУ")
                )
            },
            {
                Assertions.assertEquals(
                    15,
                    firstDuplicateIndex("1 2 42! о42! 3 42! 42! 4 4 42! 42! 5 6 6 42! 42! 42! 7 8 8 42!")
                )
            },

            // 11. Перенос строки и табуляция
            { Assertions.assertEquals(-1, firstDuplicateIndex("а\tб\tв")) },
            { Assertions.assertEquals(-1, firstDuplicateIndex("а\nб\nв")) },
            { Assertions.assertEquals(-1, firstDuplicateIndex("а\t \tб б\t")) },
            { Assertions.assertEquals(-1, firstDuplicateIndex("а\n \nб б\n")) },
            { Assertions.assertEquals(2, firstDuplicateIndex("а \t \t б \t в")) },
            { Assertions.assertEquals(2, firstDuplicateIndex("а \n \n б \n в")) },
            { Assertions.assertEquals(2, firstDuplicateIndex("а \n\t \n\t б \n в")) },

            // 12. Несколько пробелов подряд
            // В задании указано, что слова должны быть разделены ОДНИМ пробелом, тогда получается,
            // что могут существовать слова нулевого размера, т.е. "" (например, для " ").
            // ОДНАКО так как у слова нулевого размера не может быть своего индекса,
            // то будем ожидать исключения для сообщения о некорректной строке
            { Assertions.assertThrows(Exception::class.java) { firstDuplicateIndex(" ") } },
            { Assertions.assertThrows(Exception::class.java) { firstDuplicateIndex("а  б    в   г") } }
        )
    }

    /**
     * Строка содержит названия товаров и цены на них в формате вида
     * "Хлеб 39.9; Молоко 62; Курица 184.0; Конфеты 89.9".
     * То есть, название товара отделено от цены пробелом,
     * а цена отделена от названия следующего товара точкой с запятой и пробелом.
     * Вернуть название самого дорогого товара в списке (в примере это Курица),
     * или пустую строку при нарушении формата строки.
     * Все цены должны быть больше нуля либо равны нулю.
     */
    @Test
    fun mostExpensive() {
        assertAll(
            // 1. Верный формат, "без подвоха"
            { Assertions.assertEquals("Чипсы", mostExpensive("Булочка 40; Шоколадка 49; Газировка 89; Чипсы 96")) },
            { Assertions.assertEquals("Чипсы", mostExpensive("Чипсы 96; Газировка 89; Шоколадка 49; Булочка 40")) },
            { Assertions.assertEquals("Чипсы", mostExpensive("Газировка 89; Булочка 40; Чипсы 96; Шоколадка 49")) },

            // 2. Верный формат, различная комбинация типов цен
            {
                Assertions.assertEquals(
                    "Шоколадка",
                    mostExpensive("Булочка 40; Шоколадка 490; Газировка 89; Чипсы 96")
                )
            },
            {
                Assertions.assertEquals(
                    "Шоколадка",
                    mostExpensive("Булочка 40.0; Шоколадка 490.0; Газировка 89.0; Чипсы 96.0")
                )
            },
            {
                Assertions.assertEquals(
                    "Шоколадка",
                    mostExpensive("Булочка 40; Шоколадка 490.0; Газировка 89.0; Чипсы 96")
                )
            },

            // 3. Верный формат, названия продуктов из букв, цифр и символов, без ";" в названиях.
            {
                Assertions.assertEquals(
                    "4444",
                    mostExpensive("1111 1111; 2222 2222; 3333 3333; 4444 4444")
                )
            },
            {
                Assertions.assertEquals(
                    "!\"№$",
                    mostExpensive("!\"№$ 100; %^&* 2; ()!@ 33; #(@* 5")
                )
            },
            {
                Assertions.assertEquals(
                    "cho_Colate25%",
                    mostExpensive("12376#&*@ 40; cho_Colate25% 409; oIWwidj72№(\" 89; а-ауз_)(09№2 96")
                )
            },

            // 4. Верный формат, символ ";" в названии продукта
            // Так как разделителем является именно "; ", то в самих названиях наличие ";" должно быть приемлемым вариантом
            {
                Assertions.assertEquals(
                    "Максимальная;цена",
                    mostExpensive("Первый;продукт 40; Второй 49; Шоколадка 89; Максимальная;цена 96")
                )
            },
            {
                Assertions.assertEquals(
                    "Максимальная;цена",
                    mostExpensive("Максимальная;цена 96; Первый;продукт 40; Второй 49; Шоколадка 89")
                )
            },
            {
                Assertions.assertEquals(
                    "а-ауз_)(09№;2",
                    mostExpensive("12376#&*@ 40; cho_Colate25% 49; oIWwidj72№(\" 89; а-ауз_)(09№;2 96")
                )
            },

            // 5. В списке отсутствуют продукты
            { Assertions.assertEquals("", mostExpensive("")) },

            // 6. В списке один продукт
            { Assertions.assertEquals("Единственный", mostExpensive("Единственный 1")) },

            // 7. Продукты с ценой = 0
            { Assertions.assertEquals("Бесплатно", mostExpensive("Бесплатно 0")) },
            { Assertions.assertEquals("Платно", mostExpensive("Бесплатно 0; Платно 1")) },

            // 8. Несколько продуктов с одинаковой, но не максимальной ценой
            {
                Assertions.assertEquals(
                    "Максимальный",
                    mostExpensive("Первый 1; Второй 2; Опять_второй 2; Максимальный 3")
                )
            },
            {
                Assertions.assertEquals(
                    "Максимальный",
                    mostExpensive("Первый 1; Второй 2.0; Опять_второй 2; Максимальный 3")
                )
            },
            {
                Assertions.assertEquals(
                    "Максимальный",
                    mostExpensive("Первый 1; Бесплатно 0.0; Второй 2.0; Опять_бесплатно 0; Максимальный 3")
                )
            },

            // 9. Несколько продуктов с одинаковой максимальной ценой
            // Т.к. в задании не указано, какой по порядку продукт выбирать, если есть несколько продуктов с максимальной ценой,
            // будем считать, что любой из таких продуктов нам подойдёт
            {
                val resTwoMax = mostExpensive("Первый 1; Второй 2.0; Максимальный 3; Опять_максимальный 3.0")
                Assertions.assertTrue(resTwoMax == "Максимальный" || resTwoMax == "Опять_максимальный")
            },
            {
                val resAllMax = mostExpensive("Максимальный 3; Опять_максимальный 3.0; Снова_максимальный 3")
                Assertions.assertTrue(resAllMax == "Максимальный" || resAllMax == "Опять_максимальный" || resAllMax == "Снова_максимальный")
            },
            {
                val resAllZero = mostExpensive("Бесплатно 0; Опять_бесплатно 0.0; Снова_бесплатно 0")
                Assertions.assertTrue(resAllZero == "Бесплатно" || resAllZero == "Опять_бесплатно" || resAllZero == "Снова_бесплатно")
            },

            // 10. Продукты с одинаковым названием
            {
                Assertions.assertEquals(
                    "Булочка",
                    mostExpensive("Булочка 40; Булочка 490.0; Булочка 89.0; Булочка 96")
                )
            },
            {
                Assertions.assertEquals(
                    "Шоколадка",
                    mostExpensive("Булочка 40; Шоколадка 490.0; Булочка 89.0; Булочка 96")
                )
            },
            {
                Assertions.assertEquals(
                    "Шоколадка",
                    mostExpensive("Булочка 40; Шоколадка 490.0; Булочка 89.0; Шоколадка 96")
                )
            },
            {
                Assertions.assertEquals(
                    "Шоколадка",
                    mostExpensive("Булочка 40; Шоколадка 490.0; Булочка 89.0; Шоколадка 960")
                )
            },
            {
                Assertions.assertEquals(
                    "Булочка",
                    mostExpensive("Булочка 1000; Шоколадка 490.0; Булочка 100.0; Шоколадка 96")
                )
            },
            {
                val resDupleAllZero = mostExpensive("Булочка 0; Шоколадка 0.0; Булочка 0.0; Шоколадка 0")
                Assertions.assertTrue(resDupleAllZero == "Булочка" || resDupleAllZero == "Шоколадка")
            },

            // 11. Продукты с названием из нескольких слов
            // Т.к. в задании не говорится о том, что пробел не может быть в названии продукта
            // (говорится только о том, что название и цена должны быть разделены именно пробелом),
            // то будем ожидать, что продукты с названиями в пробелах должны обрабатываться корректно
            { Assertions.assertEquals("Вкусная булочка", mostExpensive("Вкусная булочка 100")) },
            { Assertions.assertEquals("Очень вкусная булочка", mostExpensive("Очень вкусная булочка 100")) },
            {
                Assertions.assertEquals(
                    "Вторая_булочка",
                    mostExpensive("Первая булочка 100; Вторая_булочка 200; Третья булочка 50")
                )
            },

            // 12. Неверный формат: продукты с отрицательной ценой
            { Assertions.assertEquals("", mostExpensive("Булочка -1")) },
            { Assertions.assertEquals("", mostExpensive("Булочка -1.0; Шоколадка -100")) },
            { Assertions.assertEquals("", mostExpensive("Булочка -1.0; Шоколадка 100")) },

            // 13. Неверный формат: неверные разделители
            { Assertions.assertEquals("", mostExpensive("Булочка40")) },
            { Assertions.assertEquals("", mostExpensive("Булочка 40; Шоколадка; Чипсы 96")) },
            { Assertions.assertEquals("", mostExpensive("Булочка 40;Шоколадка 49;Газировка 89;Чипсы 96")) },
            { Assertions.assertEquals("", mostExpensive("Булочка 40;  Шоколадка 49;  Газировка 89;  Чипсы 96")) },
            { Assertions.assertEquals("", mostExpensive("Булочка 40. Шоколадка 49. Газировка 89. Чипсы 96")) },
            { Assertions.assertEquals("", mostExpensive("Булочка\t40; Шоколадка\t49; Газировка\t89; Чипсы 96")) },
            { Assertions.assertEquals("", mostExpensive("Булочка\t40;\tШоколадка\t49;\tГазировка\t89;\tЧипсы 96")) },

            // 14. Слишком большие значения для String.toInt() или String.toDouble()
            { Assertions.assertEquals("Булочка", mostExpensive("Булочка ${Int.MAX_VALUE}0")) },
            { Assertions.assertEquals("Шоколадка", mostExpensive("Шоколадка 1${Double.MAX_VALUE}")) },
            {
                Assertions.assertEquals(
                    "Шоколадка",
                    mostExpensive("Булочка ${Int.MAX_VALUE}0; Шоколадка 1${Double.MAX_VALUE}")
                )
            },
            {
                Assertions.assertEquals(
                    "Булочка",
                    mostExpensive("Булочка 2${Double.MAX_VALUE}; Шоколадка 1${Double.MAX_VALUE}")
                )
            }
        )
    }
}