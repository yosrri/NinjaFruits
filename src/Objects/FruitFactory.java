package Objects;


public class FruitFactory {
	public IDrops getFruit(String fruit) {
		if (fruit.equalsIgnoreCase("apple"))
			return Apple.getInstance();
		if (fruit.equalsIgnoreCase("banana"))
			return Banana.getInstance();
		else if (fruit.equalsIgnoreCase("watermelon"))
			return Watermelon.getInstance();
  else return null;
	}
}
