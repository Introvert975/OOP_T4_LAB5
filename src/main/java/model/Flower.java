package model;

public class Flower {
    private static int id;
    private String name;
    private String type;
    private String color;
    private int length;
    private int price;

    public Flower(int id, String name, String type, String color, int length, int price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.color = color;
        this.length = length;
        this.price = price;
    }
    public Flower(String name, String type, String color, int length,int price)
    {
        this(-1, name, type, color,length, price);
    }

    public static int getId() {return id;}
    public String getName() {
        return name;
    }

    public String getType() {return type;}

    public String getColor() {
        return color;
    }

    public int getLength() {
        return length;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flower flower = (Flower) o;
        return id == flower.id && length == flower.length && price == flower.price && name.equals(flower.name) && type.equals(flower.type) && color.equals(flower.color);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + length;
        result = 31 * result + price;
        return result;
    }
}

