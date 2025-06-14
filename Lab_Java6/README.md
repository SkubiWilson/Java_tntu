Ознайомитись з основними колекціями Java та методами, які забезпечують зберігання, сортування, обробку та доступ до елементів колекцій. Засвоїти використання `hashCode()`, `Comparable` та утилітного класу `Collections`.

- `HashSet` — зберігання унікальних об’єктів на основі `hashCode()`
- `TreeSet` — зберігання відсортованих об'єктів за допомогою `Comparable`
- `TreeMap` — асоціативний масив з автоматичним сортуванням ключів
- `LinkedList` — двозв’язний список для ефективної вставки/видалення
- `ArrayList` — динамічний масив для швидкого доступу за індексом
- `Queue` — черга (FIFO), реалізована через `LinkedList`
- `PriorityQueue` — черга з пріоритетами
- `Collections` — утилітний клас для сортування, пошуку, перемішування колекцій


1. Продемонструвати використання `HashSet` і `hashCode()`
2. Продемонструвати використання `TreeSet` і `Comparable`
3. Продемонструвати використання `TreeMap` і `Comparable`
4. Продемонструвати використання `LinkedList`
5. Продемонструвати використання `ArrayList`
6. Продемонструвати використання `Queue`
7. Продемонструвати використання `PriorityQueue`


- Для `HashSet` важливо перевизначити методи `equals()` і `hashCode()`, щоб уникнути дублікатів.
- Для `TreeSet` і `TreeMap` необхідно реалізувати `Comparable` або передати `Comparator`.
- Усі приклади містять прості класи (`Person`, `Student`) для демонстрації поведінки колекцій.


Кожне завдання оформлено в окремому Java-файлі. Для компіляції
