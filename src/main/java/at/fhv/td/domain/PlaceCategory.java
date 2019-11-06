package at.fhv.td.domain;

import at.fhv.td.domain.interfaces.IPlaceCategory;

import javax.persistence.*;

@Entity
@Table(name = "placeCategories")
public class PlaceCategory implements IPlaceCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id", updatable = false, nullable = false)
    private Long _categoryId;

    @Column(name = "categoryname", nullable = false)
    private String _categoryname;

    @Column(name = "category")
    private String _category;

    @Column(name = "price")
    private Float _price;

    @Column(name="amount")
    private int _amount;

    @Override
    public Long getCategoryId() { return _categoryId; }

    @Override
    public String getCategoryName() {
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

    @Override
    public int getAmount() { return _amount; }

    public void setAmount(int amount) { _amount = amount; }
}
