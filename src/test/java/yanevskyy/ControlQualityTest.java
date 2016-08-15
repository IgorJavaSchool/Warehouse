package yanevskyy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class ControlQualityTest {
    Milk milk = new Milk("Milk", 8, 15, false);
    ControlQuality controlQuality = new ControlQuality();
    @Before
    public void setUp() throws Exception {
        controlQuality.fillStorage();
    }

    @Test
    public void GetProductLess25PercentSendToWarehouse() throws Exception {
        milk.setCreateDate(new Date().getTime() - 172000000);
        ControlQuality controlQualityResult = new ControlQuality();
        controlQualityResult.fillStorage();
        controlQualityResult.getStorages().get(2).getFoods().add(milk);


        controlQuality.checkQuality(milk);

        Assert.assertEquals(controlQualityResult.getStorages().size(), controlQuality.getStorages().size());
        for (int i = 0; i < controlQualityResult.getStorages().size(); i++) {
            Assert.assertEquals(controlQualityResult.getStorages().get(i).getFoods(), controlQuality.getStorages().get(i).getFoods());
        }
    }

    @Test
    public void GetProductMore25Less75PercentSendToShop() throws Exception {
        milk.setCreateDate(new Date().getTime() - 180000000);
        ControlQuality controlQualityResult = new ControlQuality();
        controlQualityResult.fillStorage();
        controlQualityResult.getStorages().get(0).getFoods().add(milk);


        controlQuality.checkQuality(milk);

        Assert.assertEquals(controlQualityResult.getStorages().size(), controlQuality.getStorages().size());
        for (int i = 0; i < controlQualityResult.getStorages().size(); i++) {
            Assert.assertEquals(controlQualityResult.getStorages().get(i).getFoods(), controlQuality.getStorages().get(i).getFoods());
        }
    }

    @Test
    public void GetProductMore75Less100PercentSendToShopSetDiscount() throws Exception {
        milk.setCreateDate(new Date().getTime() - 681500000);
        ControlQuality controlQualityResult = new ControlQuality();
        controlQualityResult.fillStorage();
        controlQualityResult.getStorages().get(0).getFoods().add(milk);
        milk.setDiscount(50);
        double discountResult = controlQualityResult.getStorages().get(0).getFoods().get(0).getDiscount();

        controlQuality.checkQuality(milk);

        Assert.assertEquals(controlQualityResult.getStorages().size(), controlQuality.getStorages().size());
        for (int i = 0; i < controlQualityResult.getStorages().size(); i++) {
            Assert.assertEquals(controlQualityResult.getStorages().get(i).getFoods(), controlQuality.getStorages().get(i).getFoods());
        }
        Assert.assertThat(controlQuality.getStorages().get(0).getFoods().get(0).getDiscount(), is(discountResult));
    }

    @Test
    public void GetProductMore100PercentSendToTrash() throws Exception {
        milk.setCreateDate(new Date().getTime() - 691500000);
        ControlQuality controlQualityResult = new ControlQuality();
        controlQualityResult.fillStorage();
        controlQualityResult.getStorages().get(1).getFoods().add(milk);

        controlQuality.checkQuality(milk);

        Assert.assertEquals(controlQualityResult.getStorages().size(), controlQuality.getStorages().size());
        for (int i = 0; i < controlQualityResult.getStorages().size(); i++) {
            Assert.assertEquals(controlQualityResult.getStorages().get(i).getFoods(), controlQuality.getStorages().get(i).getFoods());
        }
    }

    @Test
    public void calculationPercent() throws Exception {
        milk.setCreateDate(new Date().getTime() - 172800000);
        long result = 25;

        long check = controlQuality.calculationPercent(milk);

        Assert.assertEquals(check, result);
    }

    @Test
    public void GetProductLess25PercentAndOneWarehouseIsFullSendToWarehouse2() throws Exception {
        milk.setCreateDate(new Date().getTime() - 172000000);
        ControlQuality controlQualityResult = new ControlQuality();
        controlQualityResult.fillStorage();
        controlQuality.getStorages().get(2).setFull(true);
        controlQualityResult.getStorages().get(3).getFoods().add(milk);

        controlQuality.checkQuality(milk);

        Assert.assertEquals(controlQualityResult.getStorages().size(), controlQuality.getStorages().size());
        for (int i = 0; i < controlQualityResult.getStorages().size(); i++) {
            Assert.assertEquals(controlQualityResult.getStorages().get(i).getFoods(), controlQuality.getStorages().get(i).getFoods());
        }
    }

}