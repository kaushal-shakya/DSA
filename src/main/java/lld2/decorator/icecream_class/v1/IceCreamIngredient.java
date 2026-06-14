package lld2.decorator.icecream_class.v1;

public abstract class IceCreamIngredient {

    public String description;

    String getDescription() {
        return description = "Ice Cream";
    }

    abstract double getCost();
}
