package by.derzhanovich.cShop.commands;

import by.derzhanovich.cShop.exception.CommandException;
import by.derzhanovich.cShop.model.Basket;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.derzhanovich.cShop.utils.PagesPathEnum.CART_PAGE;

public class RedirectToShoppingCart implements Command {

    @Override
    public String execute(HttpServletRequest request)  {
        HttpSession session = request.getSession();
        Basket cart = (Basket) session.getAttribute("cart");

        if (cart == null) {
            request.setAttribute("cartProductsList", "");
        } else {
            request.setAttribute("cartProductsList", cart.getProducts());
        }

        return CART_PAGE.getPath();

    }
}
