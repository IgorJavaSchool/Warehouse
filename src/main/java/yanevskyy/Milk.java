package yanevskyy;

import java.util.Date;

/**
 * Imitations the milk.
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Milk extends Food {
    public Milk(String name, int expirationDate, double price, Date createDate, boolean canReproduct) {
        super(name, expirationDate, price, createDate, canReproduct);
    }
}
