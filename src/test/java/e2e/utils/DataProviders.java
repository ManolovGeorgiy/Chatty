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

        list.add(new Object[]{"tatara@abv.bg", "Manowar33246","invalid_email"});
        list.add(new Object[]{"tatar@abv.bg", "Manowar333246", "invalid_password"});
        list.add(new Object[]{"", "", "no_fields_filled_in"});
        list.add(new Object[]{"tatatata", "Redddd233", "with_invalid_data"});
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> adminCanNotLoginTest() {

        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"g.powergmail.com", "GPower3333","invalid_email"});
        list.add(new Object[]{"g.power@gmail.com", "Gpower3334", "invalid_password"});
        list.add(new Object[]{"", "", "no_fields_filled_in"});
        list.add(new Object[]{"g.powergmail.com", "Gpower33", "with_invalid_data"});
        return list.iterator();
    }
}

