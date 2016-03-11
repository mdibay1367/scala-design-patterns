trait Item { 
	def name(): String 
	def packing(): Packing 
	def price(): Float 
}

trait Packing  {
	def pack(): String 
}

trait Burger extends Item { 
	def packing(): Packing = Wrap()
}

trait ColdDrink extends Item {
	def packing(): Packing = Bottle()
}

case class Wrap() extends Packing {
	override def pack(): String = "Wrap packing"
}

case class Bottle() extends Packing {
	override def pack(): String = "Bottle packing"
}

case class VegieBurger() extends Burger {
	override def name(): String = "This is a vegie burger"
	override def price(): Float  = 2.4.toFloat
}

case class BeefBurger() extends Burger {
	override def name(): String = "This is a beef burger"
	override def price(): Float = 3.1.toFloat
}

case class Coke() extends ColdDrink {
 	override def name(): String = "This is a Cock"
	override def price(): Float = 3.1.toFloat
}

case class Pepsi() extends ColdDrink {
	override def name(): String = "This is a Pepsi"
	override def price(): Float = 3.1.toFloat
}

case class Meal() {
	var items: Seq[Item] = Seq()
	def addItem(item: Item): Unit = {
		items = items :+ item
	}

	def getCost(): Float = {
		items.map{x: Item => x.price()}.sum
	}
}

object MealBuilder {
	val meal: Meal = Meal()

	def prepareVegMeal(): Meal = {
		meal.addItem(VegieBurger())
		meal.addItem(Coke())
		meal
	}
	def prepareNonVegMeal(): Meal = {
		meal.addItem(BeefBurger())
		meal.addItem(Pepsi())
		meal
	}
}
