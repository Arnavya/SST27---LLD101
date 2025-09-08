package beverages_decorator;

public class SoyMilkDecorator extends BeverageDecorator {

    public SoyMilkDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public int cost() {
        return beverage.cost() + 3;
    }
}