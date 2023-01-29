// Пример первых входных: balance: 1000, books: [("Алгебра, 10 класс", 5, 100), ("Теория чисел, 2 класс", 42, 500)]
fun main() {
    val text = readLine()!!.split("balance: ", "books: ") // приводим данные к удобному виду
    var bal = text[1].replace(",", "").replace(" ", "").toInt()
    var books = text[2].replace("[", "").replace("]", "").replace(")", "").replace("(", "").replace("\",", "\"\",")
        .replace("1,", "11,").replace("2,", "22,").replace("3,", "33,").replace("4,", "44,").replace("5,", "55,")
        .replace("6,", "66,").replace("7,", "77,").replace("8,", "88,").replace("9,", "99,").replace("0,", "00,")
        .replace("  ", " ") // костыль, очень важный костыль.
        .split("\", ", "1, ", "2, ", "3, ", "4, ", "5, ", "6, ", "7, ", "8, ", "9, ", "0, ",).toMutableList()
    var stock = 0 // стоковая переменная, нужна для обхода через while
    var final = emptyList<Any>().toMutableList() // Финальный список книг вида ["Название", <кол-во>, <цена>]
        while (stock < books.size) { //Из-за того, что нельзя изменить тип элемента в массиве, переписываем данные в новый массив.
        final.add(books[stock])
        final.add(books[stock + 1].toInt())
        final.add(books[stock + 2].toInt())
        stock += 3
    }
    stock = 0
    var bought = emptyList<Any>().toMutableList() // список купленных книг
    var out1 = "" // стоковые переменные, нужны для вывода списков книг
    var out2 = ""
    println("███████╗██╗░░░░░███████╗░█████╗░████████╗██████╗░░█████╗░  ██████╗░░█████╗░░█████╗░██╗░░██╗░██████╗")
    println("██╔════╝██║░░░░░██╔════╝██╔══██╗╚══██╔══╝██╔══██╗██╔══██╗  ██╔══██╗██╔══██╗██╔══██╗██║░██╔╝██╔════╝")
    println("█████╗░░██║░░░░░█████╗░░██║░░╚═╝░░░██║░░░██████╔╝██║░░██║  ██████╦╝██║░░██║██║░░██║█████═╝░╚█████╗░")
    println("██╔══╝░░██║░░░░░██╔══╝░░██║░░██╗░░░██║░░░██╔══██╗██║░░██║  ██╔══██╗██║░░██║██║░░██║██╔═██╗░░╚═══██╗")
    println("███████╗███████╗███████╗╚█████╔╝░░░██║░░░██║░░██║╚█████╔╝  ██████╦╝╚█████╔╝╚█████╔╝██║░╚██╗██████╔╝")
    println("╚══════╝╚══════╝╚══════╝░╚════╝░░░░╚═╝░░░╚═╝░░╚═╝░╚════╝░  ╚═════╝░░╚════╝░░╚════╝░╚═╝░░╚═╝╚═════╝░")
    println("Введите \"help\" для справки, или \"exit\" для выхода. Ввод осуществляется без кавычек.")
    while (true) {
        var check = false // переменная для проверки условия в команде "buy"
        print(">>> ")
        var a = readLine()
         var test = false // переменная для проверки условия в команде "buy"
        if (a == "print balance") {
            println("balance: $bal руб.")
        }
        else if (a == "show books in stock") {
            stock = 0
            out2 = ""
            while (stock < final.size) {
                if (final[stock + 1] != 0) {
                    out2 += "\t${final[stock]}, ${final[stock + 1]} шт., ${final[stock + 2]} руб.\n"
                }
                stock += 3
            }
            if (out2 == "") {
                println("В продаже не осталось книг!")
            }
            else {
                println("Книги в продаже:")
                println(out2)
            }
        }
        else if (a == "show bought books") {
            stock = 0
            out1 = ""
            if (bought.size == 0) {
                println("Вы ещё не купили ни одну книгу!")
            }
            else {
                while (stock < bought.size) {
                    out1 += "\t${bought[stock]}, ${bought[stock + 1]} шт.\n"
                    stock += 2
                }
                println("Купленные книги:")
                println(out1)
            }
        }
        else if (a!!.startsWith("buy")) {
            var b = a!!.replace(" \"", " \"\"").replace("\" ", "\"\" ").split(" \"", "\" ").toMutableList() // первыый массив с данными, которые ввёл пользователь
            if (b.size != 3) { // защита на случай опечаток, т.к. несколько пробелов и пр.
                    println("no deal")
                    continue
                }
            var c = emptyList<Any>().toMutableList() // новый массив для замены типов данных
            stock = 0
            c.add(b[1])
            c.add(b[2].toInt())
            while (stock < final.size) {
                   if (final[stock] == c[0] && c[1].toString().toInt() != 0 && 0 < final[stock + 1].toString().toInt() && final[stock + 2].toString().toInt() * c[1].toString().toInt() <= bal.toString().toInt() && final[stock + 1].toString().toInt() >= c[1].toString().toInt() && c[1].toString().toInt() > 0) {
                   test = true
                   }
                    if (test == true) {
                        break
                    }
                    stock = stock + 3
            }
            if (test == true) {
                println("deal")
                    final[stock+1] = final[stock+1].toString().toInt() - c[1].toString().toInt() // .toStr().toInt() исправляет баг Kotlin, переводя число в строку и обратно в число.
                    bal = bal.toString().toInt() - c[1].toString().toInt() * final[stock+2].toString().toInt()
                stock = 0
                while (stock < bought.size) {
                    if (bought[stock] == c[0]) {
                        check = true
                        break
                    }
                    stock += 2
                }
                if (check == true) {
                    bought[stock+1] = bought[stock+1].toString().toInt() + c[1].toString().toInt()
                }
                else {
                    bought.add(c[0])
                    bought.add(c[1])
                }
            }
                else {
                    println("no deal")
                    }
            }
            else if (a == "help") {
                println("Список команд приложения:")
                println("\thelp — выводит это сообщение.")
                println("\tprint balance — выводит текущий баланс пользователя.")
                println("\tshow books in stock — показывает книги, которые остались в продаже.")
                println("\tbuy <название> <количество> — покупает книгу.")
                println("\tshow bought books — показывает купленные пользователем книги.")
                println("\texit — выход из программы.")
            }
            else if (a == "exit") {
                break
            }
            else {
                println("I don't understand")
            }
        }
    }
main()