package machine

enum class Coffee(var water: Int, var milk: Int, var beans: Int, var cups: Int, var money: Int) {
    MACHINE(400, 540, 120, 9, 550),
    ESPRESSO(250, 0, 16, 1, 4),
    LATTE(350, 75, 20, 1, 7),
    CAPPUCCINO(200, 100, 12, 1, 6);


    fun giveMeCoffee (number:String) {
        var coffee = ""
        when (number) {
            "1" -> coffee = "ESPRESSO"
            "2" -> coffee = "LATTE"
            "3" -> coffee = "CAPPUCCINO"
        }
        val result = mutableListOf<String>()
        if (MACHINE.water < Coffee.valueOf(coffee).water) result.add("water")
        if (MACHINE.milk < Coffee.valueOf(coffee).milk) result.add("milk")
        if (MACHINE.beans < Coffee.valueOf(coffee).beans) result.add("beans")
        if (MACHINE.cups < Coffee.valueOf(coffee).cups) result.add("cups")
        if (result.joinToString() == "") {
            MACHINE.water -= Coffee.valueOf(coffee).water
            MACHINE.milk -= Coffee.valueOf(coffee).milk
            MACHINE.beans -= Coffee.valueOf(coffee).beans
            MACHINE.cups -= Coffee.valueOf(coffee).cups
            MACHINE.money += Coffee.valueOf(coffee).money
            println("I have enough resources, making you a coffee!")
        }
        else
            println("Sorry, not enough ${result.joinToString()}!")
    }

    fun printFullInfo() {
        println(
            "The coffee machine has:\n" +
                    "${water} ml of water\n" +
                    "${milk} ml of milk\n" +
                    "${beans} g of coffee beans\n" +
                    "${cups} disposable cups\n" +
                    "\$${money} of money"
        )
    }

    fun giveMeYourMoney() {
        println("I gave you $${money}")
    }
}

fun buy() {
    var typeOfCoffee = "none"
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
    typeOfCoffee = readln()
    if (typeOfCoffee != "back") Coffee.MACHINE.giveMeCoffee(typeOfCoffee)
    else return
}

fun fill() {
    println("Write how many ml of water you want to add:")
    Coffee.MACHINE.water += readln().toInt()
    println("Write how many ml of milk you want to add:")
    Coffee.MACHINE.milk += readln().toInt()
    println("Write how many grams of coffee beans you want to add:")
    Coffee.MACHINE.beans += readln().toInt()
    println("Write how many disposable cups you want to add:")
    Coffee.MACHINE.cups += readln().toInt()
}

fun take() {
    Coffee.MACHINE.giveMeYourMoney()
    Coffee.MACHINE.money = 0
}

fun remaining() {
    Coffee.MACHINE.printFullInfo()
}

fun main() {
    var statusChoose: String = "none"
    do {
        println("Write action (buy, fill, take, remaining, exit):")
        statusChoose = readln()
        when (statusChoose) {
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
            "remaining" -> remaining()
        }
    } while (statusChoose != "exit")
}









