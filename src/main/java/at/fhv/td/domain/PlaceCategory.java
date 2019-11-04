package at.fhv.td.domain;

import at.fhv.td.domain.interfaces.IPlaceCategory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "placeCategories")
public class PlaceCategory implements IPlaceCategory {
    @Id
    @Column(name = "categoryname", updatable = false, nullable = false)
    private String _categoryname;

    @Column(name = "category")
    private String _category;

    @Column(name = "price")
    private Float _price;

    @Override
    public String getCategoryname() {
        return _categoryname;
    }

    public void setCategoryname(String categoryname) {
        _categoryname = categoryname;
    }

    @Override
    public String getCategory() {
        return _category;
    }

    public void setCategory(String category) {
        _category = category;
    }

    @Override
    public Float getPrice() {
        return _price;
    }

    public void setPrice(Float price) {
        _price = price;
    }
}
