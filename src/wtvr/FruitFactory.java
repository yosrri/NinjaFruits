package wtvr;

public class FruitFactory {
public IDrops getFruit(String fruit)
{
	if(fruit.equalsIgnoreCase("apple"))
	{
		return new Apple();
	}
	 if(fruit.equalsIgnoreCase("banana"))
	{
		return new Banana();
	}
	else if(fruit.equalsIgnoreCase("watermelon"))
	{
		return new Watermelon();
	}
	return null;
}
}
