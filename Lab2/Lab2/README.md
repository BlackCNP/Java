# Java
[повернутись назад](https://github.com/BlackCNP/Java/blob/main/README.md)

# Класи

# `Item`:
+ Представляє загальний елемент у бібліотеці.
+ Має властивості для назви та типу.
# `Book`:
+ Розширює `Item`.
Представляє книгу з додатковими властивостями для автора, ISBN, року публікації та клієнта, який її орендував.
# `DVD`:
+ Розширює `Item`.
+ Представляє DVD з додатковими властивостями для режисера, року випуску та клієнта, який її орендував.
# `Client`:
+ Представляє клієнта бібліотеки з його ім'ям та списком орендованих елементів.
# `LibraryManager`:
+ Керує бібліотечними елементами, клієнтами, операціями оренди та повернення.
# Основна функціональність

+ Створення елементів та клієнтів:
+ Створює екземпляри книг та DVD.
+ Створює екземпляри клієнтів.
+ Реєстрація клієнтів:
- Реєструє клієнтів у менеджері бібліотеки.
+ Додавання елементів:
- Додає книги та DVD до менеджера бібліотеки.
+ Видалення книг:
- Видаляє книги за ISBN.
+ Оренда елементів:
- Орендує елементи клієнтам.
+ Повернення елементів:
- Повертає елементи від клієнтів.
+ Відображення елементів:
- Відображає доступні, орендовані та повернені елементи.

# Ключові висновки


Код моделює просту систему управління бібліотекою з основними функціями.

