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
    Milk milk;
    Date createDate = new Date();
    List<Food> foodsShop;
    List<Food> foodsWarehouse;
    List<Food> foodsWarehouse2;
    List<Food> foodsTrash;
    Storage shop;
    Storage warehouse;
    Storage warehouse2;
    Storage trash;
    ControlQuality controlQuality = new ControlQuality();

    @Before
    public void setUp() throws Exception {
        foodsShop = new ArrayList<>();
        foodsWarehouse = new ArrayList<>();
        foodsWarehouse2 = new ArrayList<>();
        foodsTrash = new ArrayList<>();
        shop = new Shop(foodsShop, false);
        warehouse = new Warehouse(foodsWarehouse, false);
        warehouse2 = new Warehouse(foodsWarehouse2, false);
        trash = new Trash(foodsTrash, false);
        controlQuality.addStorage(shop);
        controlQuality.addStorage(warehouse);
        controlQuality.addStorage(trash);
        controlQuality.addStorage(warehouse2);
    }

    @Test
    public void whenProductLess25PercentThenSendToWarehouse() throws Exception {
        createDate.setTime(new Date().getTime() - 172000000);
        milk = new Milk("Milk", 8, 15, createDate, true);

        controlQuality.checkQuality(milk);

        Assert.assertTrue(foodsWarehouse.contains(milk));
        Assert.assertFalse(foodsShop.contains(milk));
        Assert.assertFalse(foodsTrash.contains(milk));
    }

    @Test
    public void whenProductMore25Less75PercentThenSendToShop() throws Exception {
        createDate.setTime(new Date().getTime() - 180000000);
        milk = new Milk("Milk", 8, 15, createDate, true);

        controlQuality.checkQuality(milk);

        Assert.assertFalse(foodsWarehouse.contains(milk));
        Assert.assertTrue(foodsShop.contains(milk));
        Assert.assertFalse(foodsTrash.contains(milk));
    }

    @Test
    public void whenProductMore75Less100PercentThenSendToShopSetDiscount() throws Exception {
        createDate.setTime(new Date().getTime() - 681500000);
        milk = new Milk("Milk", 8, 15, createDate, true);

        controlQuality.checkQuality(milk);

        Assert.assertFalse(foodsWarehouse.contains(milk));
        Assert.assertTrue(foodsShop.contains(milk));
        Assert.assertTrue(milk.getDiscount() == 50);
        Assert.assertFalse(foodsTrash.contains(milk));
    }

    @Test
    public void whenProductMore100PercentThenSendToTrash() throws Exception {
        createDate.setTime(new Date().getTime() - 691500000);
        milk = new Milk("Milk", 8, 15, createDate, false);

        controlQuality.checkQuality(milk);

        Assert.assertFalse(foodsWarehouse.contains(milk));
        Assert.assertFalse(foodsShop.contains(milk));
        Assert.assertTrue(foodsTrash.contains(milk));
    }

    @Test
    public void calculationPercent() throws Exception {
        createDate.setTime(new Date().getTime() - 172800000);
        milk = new Milk("Milk", 8, 15, createDate, true);
        long result = 25;

        long check = milk.percentExpiration();

        Assert.assertEquals(check, result);
    }

    @Test
    public void whenProductLess25PercentWarehouse1IsFullThenSendToWarehouse2() throws Exception {
        warehouse = new Warehouse(foodsWarehouse, true);
        controlQuality = new ControlQuality();
        controlQuality.addStorage(shop);
        controlQuality.addStorage(warehouse);
        controlQuality.addStorage(warehouse2);
        controlQuality.addStorage(trash);
        createDate.setTime(new Date().getTime() - 172000000);
        milk = new Milk("Milk", 8, 15, createDate, true);

        controlQuality.checkQuality(milk);

        Assert.assertFalse(foodsWarehouse.contains(milk));
        Assert.assertTrue(foodsWarehouse2.contains(milk));
        Assert.assertFalse(foodsShop.contains(milk));
        Assert.assertFalse(foodsTrash.contains(milk));
    }

    @Test
    public void whenProductMore100PercentAndReproductIsTrueThenSendToRefregerator() throws Exception {
        createDate.setTime(new Date().getTime() - 691500000);
        milk = new Milk("Milk", 8, 15, createDate, true);
        List<Food> foodsRefregerator = new ArrayList<>();
        Storage refregerator = new Refregerator(foodsRefregerator,false);
        controlQuality.addStorage(refregerator);

        controlQuality.checkQuality(milk);

        Assert.assertFalse(foodsWarehouse.contains(milk));
        Assert.assertFalse(foodsWarehouse2.contains(milk));
        Assert.assertFalse(foodsShop.contains(milk));
        Assert.assertFalse(foodsTrash.contains(milk));
        Assert.assertTrue(foodsRefregerator.contains(milk));
        Assert.assertTrue(createDate.getTime() == System.currentTimeMillis());
    }

}