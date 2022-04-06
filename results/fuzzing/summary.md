# Результаты покрытия с использованием Fuzzing

## 1. Результаты использования Fuzzing
На вход тестируемым функциям подавались данные, сгенерированные самостоятельно написанным фаззером. 
Тесты проверяли, что тестируемые функции не падают с исключениями.

Из 4 тестируемых функций не проходит данное тестирование только `lesson6.task1.mostExpensive`.
При тестировании этой функции выпадали следующие исключения:
- `java.lang.NumberFormatException (Parse.kt:188)`
- `java.lang.StringIndexOutOfBoundsException (Parse.kt:185)`

Это связано с тем, что данная функция реализована "наивно" и не проверяет входную строку на соответствие 
ожидаемому формату.

## 2. Покрытие только для Fuzzing
Тестовое покрытие полученное с использованием только fuzzing почти для всех трестируемых функций меньше, чем покрытие, 
полученное [в прошлой лабораторной работе](../coverage/summary.md).

Например, для упомянутой ранее `lesson6.task1.mostExpensive` покрытие составило 54% по инструкциям и 35% по веткам,
в сравнении с 100% и 100% соответственно для покрытия, полученного в прошлой лабораторной работе.

Это связано с тем, что функции при рандомных входных данных могут не доходить до "интересных" строк кода,
либо обрабатывают их примерно одинаково. 
В частости, для `lesson6.task1.mostExpensive` фаззинг так и не дошёл до 4 строк, т.к. падали исключения, упомянутые выше.


## 3. Покрытие для предыдущих тестов + Fuzzing
Тестовое покрытие, полученное таким образом, не отличается от тестового покрытия, которое было получено
[в прошлой лабораторной работе](../coverage/summary.md).

Полученные результаты приведены в таблице ниже.

|                                   | только Fuzzing                                          | All                                                      | All with Fuzzing                                         |
|-----------------------------------|---------------------------------------------------------|----------------------------------------------------------|----------------------------------------------------------|
| **lesson5 findSumOfTwo()**        | 96% cov Missed Instruction<br/>75% cov Missed Branches  | 96% cov Missed Instruction<br/>88% cov Missed Branches   | 96% cov Missed Instruction<br/>88% cov Missed Branches   |
| **lesson6 firstDuplicateIndex()** | 100% cov Missed Instruction<br/>83% cov Missed Branches | 100% cov Missed Instruction<br/>100% cov Missed Branches | 100% cov Missed Instruction<br/>100% cov Missed Branches |
| **lesson6 mostExpensive()**       | 54% cov Missed Instruction<br/>35% cov Missed Branches  | 100% cov Missed Instruction<br/>100% cov Missed Branches | 100% cov Missed Instruction<br/>100% cov Missed Branches |
| **lesson7 deleteMarked.()**       | 95% cov Missed Instruction<br/>50% cov Missed Branches  | 95% cov Missed Instruction<br/>50% cov Missed Branches   | 95% cov Missed Instruction<br/>50% cov Missed Branches   |

Кроме того, стоит отметить, что покрытие для фаззинга может отличаться при нескольких запусках. 
Связано это с рандомизацией входных данных.



