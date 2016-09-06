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
    /*Recyclability*/
    private boolean canReproduct;

    /**
     * Creates new product. Creation date as current date.
     * @param name Product name.
     * @param expirationDays Amount of days before expiration date.
     * @param price Product price
     */
    public Food(String name, int expirationDays, double price, Date createDate, boolean canReproduct) {
        this.name = name;
        this.expirationDays = expirationDays;
        this.price = price;
        this.createDate = createDate;
        this.canReproduct = canReproduct;
    }

    void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public boolean isCanReproduct() {
        return canReproduct;
    }

    /**
     * Create expiration date.
     * @return
     */
    public Date dateExpiration(){
        return new Date(this.expirationDays * 86400000 + this.createDate.getTime());
    }

    /**
     * Calculate percent time expiration for food.
     * @return
     */
    public long percentExpiration(){
        long timeExpiration = dateExpiration().getTime()- this.createDate.getTime();
        long timeCurrent = System.currentTimeMillis() - this.createDate.getTime();
        return timeCurrent * 100 / timeExpiration;
    }

}
