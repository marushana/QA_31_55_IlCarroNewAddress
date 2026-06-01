package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchCarTests extends TestBase{

//    @Test
//    public void searchCurrentMonthSuccess(){
//        app.getHelperCar().searchCurrentMonth("Haifa", "6/10/2026", "6/31/2026");
//        app.getHelperCar().submit();
//        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
//    }

    @Test
    public void searchCurrentYear(){
        app.getHelperCar().searchCurrentYear("Haifa", "8/15/2026", "11/7/2026");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
    }

    @Test
    public void searchAnyPeriodValid(){
        app.getHelperCar().searchAnyPeriodSuccess("Haifa", "6/15/2026", "3/17/2027");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());


    }
}
