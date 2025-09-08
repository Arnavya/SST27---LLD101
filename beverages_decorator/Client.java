package beverages_decorator;

public class Client {

	public static void main(String[] args) {

		// Plain Cappuccino
		Beverage coffee = new Cappuccino();
		System.out.println("Plain Cappuccino: $" + coffee.cost());

		// Cappuccino with milk
		Beverage coffeeWithMilk = new MilkDecorator(new Cappuccino());
		System.out.println("Cappuccino with Milk: $" + coffeeWithMilk.cost());

		// Cappuccino with soy milk
		Beverage coffeeWithSoyMilk = new SoyMilkDecorator(new Cappuccino());
		System.out.println("Cappuccino with Soy Milk: $" + coffeeWithSoyMilk.cost());

		// Latte with milk
		Beverage latteWithMilk = new MilkDecorator(new Latte());
		System.out.println("Latte with Milk: $" + latteWithMilk.cost());

		// Multiple decorators - Cappuccino with both milk and soy milk
		Beverage coffeeWithBoth = new SoyMilkDecorator(new MilkDecorator(new Cappuccino()));
		System.out.println("Cappuccino with Milk and Soy Milk: $" + coffeeWithBoth.cost());

	}

}