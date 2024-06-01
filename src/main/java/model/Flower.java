package model;

public class Flower {
    private static int id;
    private String name;
    private String type;
    private String color;
    private int length;
    private int price;

    public Flower(int id, String name, String type, String color, int length, int price)
    {
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
}

