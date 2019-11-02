package at.fhv.td.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaceCategoryDTOTest {
    private PlaceCategoryDTO _testPlaceCategory;

    @Before
    public void before() {
        _testPlaceCategory = new PlaceCategoryDTO();
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