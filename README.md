# Пояснялка.

**Привет!** Я решил тестовое задание для конкурса на место в летнем кампусе "Сферума".
ТЗ (благо оно в открытом доступе): https://like-brace-188.notion.site/dc79d7bc33cc477bb3e7ba6e40c62f3f

Хочу сразу уточнить несколько моментов. Они важны. Я не делал в коде дополнительных классов или функций, т.к. на мой взгляд, в нативных командах легче разобраться. Зато в коде много поясняющих комментариев.

**0.** Из-за технических особенностей GitHub весь проект лежит в архиве. Пароля нет.

**1.** Основной и единственный код лежит в файлике `app.kts`. Да, это скрипт, а не файл с расширением `.kt`. Но условие из ТЗ я выполнил, ведь скрипт целиком и полностью написан на Kotlin. + Некоторые компиляторы требуют запуска главной функции с помощью `main()`, поэтому в моём коде есть отдельная строчка для запуска функции `main()`.

**2.** В ТЗ есть несостыковка. Вот скрины:
![](https://i.imgur.com/NWg3CrX.png)
![](https://i.imgur.com/rT0TL3O.png)
Команда на первом скрине отличается от команды на втором. Я выбрал второй вариант, в моём коде это реализовано как:
```
buy "<название>" <количество>
```
**3.** В моём коде реализована функция "help", которая выводит на экран список всех доступный команд с пояснениями. Вы можете заценить.

**4.** В моём коде, как и практически во всех, есть костыли. В частности, `<переменная>.toString().toInt()`. Они фиксят баги Kotlin, которые пока не успели поправить. Не бейте, пожалуйста :)

**5.** Я не знаю, как вы будете запускать код, но я делал это через **Intellij IDEA** от **JetBrains**. Очень советую делать это оттуда. Ну, тут вы уже сами разберётесь.

**6.** Ну и шестой, "бонусный" пункт, если вам надо будет связаться со мной.

**E-mail: justmarfix@vk.com**
**ВКонтакте:** [**клик**](https://vk.com/justmarfix)

Что, мемов не будет? Конечно, мемы будут! По крайней мере, держите один мем, который (я надеюсь) поднимет Вам настроение.
![](https://sun1-86.userapi.com/s/v1/ig2/uQMp_o-RIQOtqvrRj-VpkKG3jJGVH1kihtrOg4-bi86YAKwKxpAPWNm0w42t4xiSdG9gk0jhcq7etqh4GYIkIJ3s.jpg?size=1024x948&quality=95&type=album)
