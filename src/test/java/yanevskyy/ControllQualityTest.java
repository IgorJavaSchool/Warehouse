package yanevskyy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class ControllQualityTest {
    Milk milk = new Milk("Milk", 8, 15);
    ControllQuality controllQuality = new ControllQuality();
    @Before
    public void setUp() throws Exception {
        controllQuality.fillStorage();
    }

    @Test
    public void GetProductLess25PercentSendToWarehouse() throws Exception {
        milk.setCreateDate(new Date().getTime() - 172000000);
        ControllQuality controllQualityResult = new ControllQuality();
        controllQualityResult.fillStorage();
        for (Storage storage : controllQualityResult.getStorages()) {
            if (storage.toString().equals("Warehouse"))
                controllQualityResult.findStorage("Warehouse").getFoods().add(milk);
        }

        controllQuality.checkQuality(milk);

        Assert.assertEquals(controllQualityResult.getStorages().size(), controllQuality.getStorages().size());
        for (int i = 0; i < controllQualityResult.getStorages().size(); i++) {
            Assert.assertEquals(controllQualityResult.getStorages().get(i).getFoods(), controllQuality.getStorages().get(i).getFoods());
        }
    }

    @Test
    public void GetProductMore25Less75PercentSendToShop() throws Exception {
        milk.setCreateDate(new Date().getTime() - 180000000);
        ControllQuality controllQualityResult = new ControllQuality();
        controllQualityResult.fillStorage();
        for (Storage storage : controllQualityResult.getStorages()) {
            if (storage.toString().equals("Shop"))
                controllQualityResult.findStorage("Shop").getFoods().add(milk);
        }

        controllQuality.checkQuality(milk);

        Assert.assertEquals(controllQualityResult.getStorages().size(), controllQuality.getStorages().size());
        for (int i = 0; i < controllQualityResult.getStorages().size(); i++) {
            Assert.assertEquals(controllQualityResult.getStorages().get(i).getFoods(), controllQuality.getStorages().get(i).getFoods());
        }
    }

    @Test
    public void GetProductMore75Less100PercentSendToShopSetDiscount() throws Exception {
        milk.setCreateDate(new Date().getTime() - 681500000);
        ControllQuality controllQualityResult = new ControllQuality();
        controllQualityResult.fillStorage();
        for (Storage storage : controllQualityResult.getStorages()) {
            if (storage.toString().equals("Shop"))
                controllQualityResult.findStorage("Shop").getFoods().add(milk);
        }
        milk.setDisscount(50);
        double discountResult = controllQualityResult.getStorages().get(0).getFoods().get(0).getDisscount();

        controllQuality.checkQuality(milk);

        Assert.assertEquals(controllQualityResult.getStorages().size(), controllQuality.getStorages().size());
        for (int i = 0; i < controllQualityResult.getStorages().size(); i++) {
            Assert.assertEquals(controllQualityResult.getStorages().get(i).getFoods(), controllQuality.getStorages().get(i).getFoods());
        }
        Assert.assertThat(controllQuality.getStorages().get(0).getFoods().get(0).getDisscount(), is(discountResult));
    }

    @Test
    public void GetProductMore100PercentSendToTrash() throws Exception {
        milk.setCreateDate(new Date().getTime() - 691500000);
        ControllQuality controllQualityResult = new ControllQuality();
        controllQualityResult.fillStorage();
        for (Storage storage : controllQualityResult.getStorages()) {
            if (storage.toString().equals("Trash"))
                controllQualityResult.findStorage("Trash").getFoods().add(milk);
        }

        controllQuality.checkQuality(milk);

        Assert.assertEquals(controllQualityResult.getStorages().size(), controllQuality.getStorages().size());
        for (int i = 0; i < controllQualityResult.getStorages().size(); i++) {
            Assert.assertEquals(controllQualityResult.getStorages().get(i).getFoods(), controllQuality.getStorages().get(i).getFoods());
        }
    }

    @Test
    public void calculationPercent() throws Exception {
        long timeExpiration = milk.dateExpiration().getTime()- milk.getCreateDate().getTime();
        /*345600000 Amount of days after create product.  */
        long timeCurrent = new Date().getTime() - milk.getCreateDate().getTime() + 172800000;
        long result = 25;

        long check = controllQuality.calculationPercent(timeExpiration, timeCurrent);

        Assert.assertEquals(check, result);


    }

}