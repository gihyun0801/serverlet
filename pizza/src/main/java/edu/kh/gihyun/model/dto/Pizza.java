package edu.kh.gihyun.model.dto;

public class Pizza {
  private String name;
  private int price;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public Pizza(String name, int price) {
	super();
	this.name = name;
	this.price = price;
}
  public Pizza() {}
@Override
public String toString() {
	return "Pizza [name=" + name + ", price=" + price + "]";
}

  
  
}
