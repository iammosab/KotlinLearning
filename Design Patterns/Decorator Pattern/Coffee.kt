interface Coffee {
    fun getCost(): Double
    fun getDescription(): String
}

class BasicCoffee : Coffee {
    override fun getCost(): Double {
        return 5.0
    }

    override fun getDescription(): String {
        return "Basic Coffee"
    }
}

abstract class CoffeeDecorator(private val decoratedCoffee: Coffee) : Coffee {
    override fun getCost(): Double {
        return decoratedCoffee.getCost()
    }

    override fun getDescription(): String {
        return decoratedCoffee.getDescription()
    }
}

class MilkDecorator(decoratedCoffee: Coffee) : CoffeeDecorator(decoratedCoffee) {
    override fun getCost(): Double {
        return super.getCost() + 1.5
    }

    override fun getDescription(): String {
        return super.getDescription() + ", Milk"
    }
}

class SugarDecorator(decoratedCoffee: Coffee) : CoffeeDecorator(decoratedCoffee) {
    override fun getCost(): Double {
        return super.getCost() + 0.5
    }

    override fun getDescription(): String {
        return super.getDescription() + ", Sugar"
    }
}

class WhippedCreamDecorator(decoratedCoffee: Coffee) : CoffeeDecorator(decoratedCoffee) {
    override fun getCost(): Double {
        return super.getCost() + 2.0
    }

    override fun getDescription(): String {
        return super.getDescription() + ", Whipped Cream"
    }
}



fun main() {
    var coffee: Coffee = BasicCoffee()
    println("${coffee.getDescription()} -> $${coffee.getCost()}")

    coffee = MilkDecorator(coffee)
    println("${coffee.getDescription()} -> $${coffee.getCost()}")

    coffee = SugarDecorator(coffee)
    println("${coffee.getDescription()} -> $${coffee.getCost()}")

    coffee = WhippedCreamDecorator(coffee)
    println("${coffee.getDescription()} -> $${coffee.getCost()}")
}