package by.derzhanovich.cShop.commands;



import by.derzhanovich.cShop.exception.CommandException;
import by.derzhanovich.cShop.model.Product;

import javax.servlet.http.HttpServletRequest;

import static by.derzhanovich.cShop.utils.PagesPathEnum.PRODUCT_PAGE;


public class RedirectProductPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        int productId = Integer.parseInt(request.getParameter("product_id"));
        Product product = new Product(productId, "Samsung", 100, "Samsung S20FE");
        request.setAttribute("product", product);
        return PRODUCT_PAGE.getPath();

    }
}
