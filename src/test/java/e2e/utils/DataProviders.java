package e2e.utils;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.lang.Object;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> userCanNotLoginTest() {

        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"tatara@abv.bg", "Manowar33246"});
        list.add(new Object[]{"tatar@abv.bg", "Manowar333246"});
        list.add(new Object[]{"", ""});
        list.add(new Object[]{"tatatata", "Redddd233"});
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> adminCanNotLoginTest() {

        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"g.powergmail.com", "GPower3333"});
        list.add(new Object[]{"g.power@gmail.com", "Gpower33"});
        list.add(new Object[]{"", ""});
        list.add(new Object[]{"g.powergmail.com", "Gpower33"});
        return list.iterator();
    }
}

