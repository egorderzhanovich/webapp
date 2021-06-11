package by.derzhanovich.cShop.model;

import java.util.List;
import java.util.Objects;

public class Category {
    private String name;
    private String imageName;
    private List<Product> productList;

    public Category(String model, String imageName) {
        this.name = model;
        this.imageName = imageName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + name + '\'' +
                ", imageName='" + imageName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name) &&
                Objects.equals(imageName, category.imageName) &&
                Objects.equals(productList, category.productList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, imageName, productList);
    }
}
