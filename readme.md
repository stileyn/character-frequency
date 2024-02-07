# API для подсчета частоты символов

Это REST API вычисляет частоту символов в заданной строке и возвращает результат, отсортированный по убыванию частоты символов.

## Запуск приложения

1. Клонируйте этот репозиторий.
2. Убедитесь, что у вас установлен Java JDK и Maven.
3. Перейдите в директорию проекта.
4. Выполните команду: `mvn spring-boot:run`.
5. Приложение будет запущено по адресу `http://localhost:8080`.

## Входящие параметры

- **input**: String - Входная строка, для которой вы хотите подсчитать частоту символов.
- Например: `http://localhost:8080/character-frequency?input=aaaaabcccc`

## Формат вывода

API возвращает JSON объект, где ключи представляют символы, а значения представляют их частоту во входной строке.
