package by.derzhanovich.cShop.utils;

public enum PagesPathEnum {
    HOME_PAGE("cShop.jsp"),
    SIGN_IN("signin.jsp"),
    CATEGORY_PAGE("category.jsp"),
    CART_PAGE("cart.jsp"),
    PRODUCT_PAGE("product.jsp");

    private final String path;

    PagesPathEnum(String path) {
        this.path = path;
    }

    public String getPath(){return path;}
}
