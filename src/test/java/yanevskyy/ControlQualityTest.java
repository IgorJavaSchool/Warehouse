package yanevskyy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class ControlQualityTest {
    private Milk milk;
    private Date createDate = new Date();
    private List<Food> foodsShop;
    private List<Food> foodsWarehouse;
    private List<Food> foodsTrash;
    private ControlQuality controlQuality = new ControlQuality();
    @Before
    public void setUp() throws Exception {
        foodsShop = new ArrayList<>();
        foodsWarehouse = new ArrayList<>();
        foodsTrash = new ArrayList<>();
        controlQuality.addStorage(new Shop(foodsShop));
        controlQuality.addStorage(new Warehouse(foodsWarehouse));
        controlQuality.addStorage(new Trash(foodsTrash));
    }

    @Test
    public void WhenProductLess25PercentThenSendToWarehouse() throws Exception {
        createDate.setTime(new Date().getTime() - 172000000);
        milk = new Milk("Milk", 8, 15, createDate);

        controlQuality.checkQuality(milk);

        Assert.assertTrue(foodsWarehouse.contains(milk));
        Assert.assertFalse(foodsShop.contains(milk));
        Assert.assertFalse(foodsTrash.contains(milk));
    }

    @Test
    public void WhenProductMore25Less75PercentThenSendToShop() throws Exception {
        createDate.setTime(new Date().getTime() - 180000000);
        milk = new Milk("Milk", 8, 15, createDate);

        controlQuality.checkQuality(milk);

        Assert.assertFalse(foodsWarehouse.contains(milk));
        Assert.assertTrue(foodsShop.contains(milk));
        Assert.assertFalse(foodsTrash.contains(milk));
    }

    @Test
    public void WhenProductMore75Less100PercentThenSendToShopSetDiscount() throws Exception {
        createDate.setTime(new Date().getTime() - 681500000);
        milk = new Milk("Milk", 8, 15, createDate);

        controlQuality.checkQuality(milk);

        Assert.assertFalse(foodsWarehouse.contains(milk));
        Assert.assertTrue(foodsShop.contains(milk));
        Assert.assertTrue(milk.getDiscount() == 50);
        Assert.assertFalse(foodsTrash.contains(milk));
    }

    @Test
    public void WhenProductMore100PercentThenSendToTrash() throws Exception {
        createDate.setTime(new Date().getTime() - 691500000);
        milk = new Milk("Milk", 8, 15, createDate);

        controlQuality.checkQuality(milk);

        Assert.assertFalse(foodsWarehouse.contains(milk));
        Assert.assertFalse(foodsShop.contains(milk));
        Assert.assertTrue(foodsTrash.contains(milk));
    }

    @Test
    public void calculationPercent() throws Exception {
        createDate.setTime(new Date().getTime() - 172800000);
        milk = new Milk("Milk", 8, 15, createDate);
        long result = 25;

        long check = milk.percentExpiration();

        Assert.assertEquals(check, result);


    }

}