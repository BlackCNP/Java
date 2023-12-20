[повернутись назад](https://github.com/BlackCNP/Java/blob/main/README.md)

# Decoder

Клас `Decoder` використовується для декодування повідомлень, які були закодовані за допомогою спеціального кодування.

## Методи

### decodeVowelEncoding

Цей метод приймає закодоване повідомлення як вхідний параметр. Він замінює всі цифри від 1 до 5 на відповідні голосні (1 = a, 2 = e, 3 = i, 4 = o, 5 = u).

### decodeConsonantEncoding

Цей метод також приймає закодоване повідомлення як вхідний параметр. Він замінює всі приголосні на наступну приголосну в алфавіті. Наприклад, 'b' замінюється на 'c', 'c' замінюється на 'd' і т.д. Є винятки для 'z', 'Z', '{' та '['.

## Приклад використання

```java
public static void main(String[] args) {
    String encodedMessage1 = "t2st3ng";
    String encodedMessage2 = "ufttjoh";
    String encodedMessage3 = "sdrshmf";

    String decodedMessage1 = decodeVowelEncoding(encodedMessage1);
    String decodedMessage2 = decodeConsonantEncoding(encodedMessage2);
    String decodedMessage3 = decodeConsonantEncoding(encodedMessage3);

    System.out.println("Decoded Message 1: " + decodedMessage1);
    System.out.println("Decoded Message 2: " + decodedMessage2);
    System.out.println("Decoded Message 3: " + decodedMessage3);
} 
//Цей приклад демонструє, як можна використовувати клас `Decoder` для декодування повідомлень.

