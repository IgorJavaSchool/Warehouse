package yanevskyy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Y on 16.08.2016.
 */
public class TemperatureControlTest {
    Milk milk = new Milk("Milk", 8, 15, true);
    TemperatureControl temperatureControl = new TemperatureControl();
    @Before
    public void setUp(){
        temperatureControl.fillStorage();
    }
    @Test
    public void GetProductMore100PercentReproductionMoveToFridge() throws Exception {
        milk.setCreateDate(new Date().getTime() - 691500000);
        TemperatureControl temperatureControlResult = new TemperatureControl();
        temperatureControlResult.fillStorage();
        temperatureControlResult.getStorages().get(4).getFoods().add(milk);

        temperatureControl.checkReproduct(milk);

        Assert.assertEquals(temperatureControlResult.getStorages().size(), temperatureControl.getStorages().size());
        for (int i = 0; i < temperatureControlResult.getStorages().size(); i++) {
            Assert.assertEquals(temperatureControlResult.getStorages().get(i).getFoods(), temperatureControl.getStorages().get(i).getFoods());
        }
    }

}