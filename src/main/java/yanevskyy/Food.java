package yanevskyy;

import java.util.Date;

/**
 * Used to describe the product.
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Food {
    /*Product name*/
    private final String name;
    /*Amount of days before expiration date*/
    private int expirationDays;
    /*The date create*/
    private Date createDate;
    /*Product price*/
    private double price;
    /*Product discount*/
    private double discount;
    private boolean canReproduct;

    /**
     * Creates new product. Creation date as current date.
     * @param name Product name.
     * @param expirationDays Amount of days before expiration date.
     * @param price Product price
     */
    public Food(String name, int expirationDays, double price) {
        this.name = name;
        this.expirationDays = expirationDays;
        this.price = price;
        this.createDate = new Date();
    }

    public String getName() {
        return name;
    }

    public int getExpirationDays() {
        return expirationDays;
    }

    public void setExpirationDays(int expirationDays) {
        this.expirationDays = expirationDays;
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

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setCreateDate(long createDate) {
        this.createDate.setTime(createDate);
    }

    /**
     * Create expiration date.
     * @return
     */
    public Date dateExpiration(){
        return new Date(getExpirationDays() * 86400000 + getCreateDate().getTime());
    }

    public boolean isCanReproduct() {
        return canReproduct;
    }

    public void setCanReproduct(boolean canReproduct) {
        this.canReproduct = canReproduct;
    }
}
