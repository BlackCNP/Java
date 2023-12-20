# Java
[повернутись назад](https://github.com/BlackCNP/Java/blob/main/README.md)

План розробки програми бібліотечного управління
Опис класів
Item (Abstract Class)

Атрибути:

1.title: String

2.uniqueID: String (унікальний для кожного елемента)

3.isBorrowed: boolean (за замовчуванням false)

Методи:

1.Конструктори, гетери, сетери

2.abstract void borrowItem(): Позначає елемент як позичений.


3.abstract void returnItem(): Позначає елемент як не позичений.

4.Book (implements Item)


Атрибути:

1.author: String

1.Методи:

2.borrowItem(): Реалізує абстрактний метод з Item.

3.returnItem(): Реалізує абстрактний метод з Item.
4.DVD (implements Item)

Атрибути:

1.duration: int (хвилини)
Методи:

1.borrowItem(): Реалізує абстрактний метод з Item.
2.returnItem(): Реалізує абстрактний метод з Item.
3.Client

Атрибути:

1.name: String
2.borrowedItems: ArrayList<Item>
Методи:

1.Конструктори, гетери, сетери

2.borrowItem(Item): Додає елемент до списку позичених клієнтом.

3.returnItem(Item): Видаляє елемент зі списку позичених клієнтом.

4.IManageable (Інтерфейс)

Методи:

1.add(Item): Додає елемент.

2.remove(Item): Видаляє елемент.

3.listAvailable(): Виводить усі доступні елементи.

4.listBorrowed(): Виводить усі позичені елементи.

5.Library (implements IManageable)

Атрибути:

1.availableItems: ArrayList<Item> (для зберігання всіх доступних елементів)

2.borrowedItems: ArrayList<Item> (для зберігання всіх позичених елементів)

3.clients: HashMap<String, Client> (для зберігання всіх зареєстрованих клієнтів)

4.returnedItems: ArrayList<Item> (для зберігання всіх повернутих елементів)

Методи:


1.addItem(Item): Додає елемент.

2.registerClient(Client): Реєструє нового клієнта.

3.lendItem(Item, Client): Позичає елемент клієнту.

4.returnItem(Item, Client): Повертає позичений елемент.

5.displayReturnedItems(): Виводить всі повернуті елементи.

6.displayAvailableItems(): Виводить усі доступні елементи.

7.deleteBookByISBN(String): Видаляє книгу за ISBN.

8.displayBorrowedItems(): Виводить усі позичені елементи.

Послідовність виконаних дій:

1.Створити екземпляр бібліотеки.

2.Додати елементи до бібліотеки (книги, DVD тощо).

3.Зареєструвати нових клієнтів в бібліотеці.

4.Відображення доступних елементів в бібліотеці.

5.Позичити елементи клієнтам.

6.Відобразити позичені елементи.

7.Повернути елементи в бібліотеку.

8.Відобразити елементи, що були повернуті.

9.Відобразити доступні елементи.

10.Відобразити позичені елементи.
