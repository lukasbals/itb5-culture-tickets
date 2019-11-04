package at.fhv.td.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaceCategoryTest {
    private PlaceCategory _testPlaceCategory;

    @Before
    public void before() {
        _testPlaceCategory = new PlaceCategory();
    }

    @Test
    public void getAndSetCategory() {
        String category = "standingplace";
        _testPlaceCategory.setCategory(category);
        assertEquals(category, _testPlaceCategory.getCategory());
    }

    @Test
    public void getAndSetCategoryName() {
        String name = "14B";
        _testPlaceCategory.setCategoryname(name);
        assertEquals(name, _testPlaceCategory.getCategoryname());
    }

    @Test
    public void getAndSetPrice() {
        Float price = 23.7f;
        _testPlaceCategory.setPrice(price);
        assertEquals(price, _testPlaceCategory.getPrice());
    }
}