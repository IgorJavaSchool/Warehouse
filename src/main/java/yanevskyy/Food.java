package yanevskyy;

import java.util.Date;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Food {
    private final String name;
    private int expirationDate;
    private final Date createDate;
    private double price;
    private double disscount;

    public Food(String name, int expirationDate, double price) {
        this.name = name;
        this.expirationDate = expirationDate;
        this.price = price;
        this.createDate = new Date();
    }

    public String getName() {
        return name;
    }

    public int getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(int expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDisscount() {
        return disscount;
    }

    public void setDisscount(double disscount) {
        this.disscount = disscount;
    }
}
