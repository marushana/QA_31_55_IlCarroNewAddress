package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchCarTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        app.getHelperCar().clickLogo();
    }

    @Test
    public void searchCurrentMonthSuccess(){
        app.getHelperCar().searchCurrentMonth("Haifa", "6/10/2026", "6/20/2026");
        app.getHelperCar().getScreen("src/test/resources/screenshots/current.png");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
    }

    @Test
    public void searchCurrentYear(){
        app.getHelperCar().searchCurrentYear("Haifa", "8/15/2026", "11/7/2026");
        app.getHelperCar().getScreen("src/test/resources/screenshots/year.png");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
    }

    @Test
    public void searchAnyPeriodValid(){
        app.getHelperCar().searchAnyPeriodSuccess("Haifa", "6/15/2026", "1/7/2027");
        app.getHelperCar().getScreen("src/test/resources/screenshots/any.png");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());


    }
}
