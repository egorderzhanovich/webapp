package by.derzhanovich.cShop.commands;

import by.derzhanovich.cShop.exception.CommandException;
import by.derzhanovich.cShop.model.Basket;
import by.derzhanovich.cShop.model.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.derzhanovich.cShop.utils.PagesPathEnum.PRODUCT_PAGE;

public class AddProductToCartCommand implements Command {

    @Override
    public String execute(HttpServletRequest request)  {
        HttpSession session = request.getSession();
        int productId = Integer.parseInt(request.getParameter("product_id"));

        Product product = new Product(productId, "Samsung", 100, "Samsung S20FE");

        Basket cart;
        Object objCart = session.getAttribute("cart");

        if (objCart != null) {
            cart = (Basket) objCart;
        } else {
            cart = new Basket();
            session.setAttribute("cart", cart);
        }

        cart.addProduct(product);
        request.setAttribute("product", product);

        return PRODUCT_PAGE.getPath();
    }
}
