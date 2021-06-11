package by.derzhanovich.cShop.commands;

import by.derzhanovich.cShop.exception.ParamNullException;
import by.derzhanovich.cShop.model.Category;
import by.derzhanovich.cShop.model.Product;
import by.derzhanovich.cShop.utils.PagesPathEnum;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public class CategoryCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws ParamNullException {
        if(request.getParameter("category_name").equalsIgnoreCase("cars")){
            Category cars = new Category("Cars", "car.jpg");
            cars.setProductList(Arrays.asList(
                    new Product(1,"bmw", 1500, "bmw cobra"),
                    new Product(2,"Audi", 15000, "A5 3.2 TFSI")
            ));
            request.setAttribute("category", cars);
        }else if(request.getParameter("category_name").equalsIgnoreCase("Mobile phones")) {
            Category mobilePhones = new Category("Mobile phones", "mobile.jpg");
            mobilePhones.setProductList(Arrays.asList(
                    new Product(1, "Samsung", 100, "Samsung S20FE"),
                    new Product(2, "IPhone", 150, "IPhone 12 128GB 5G")
            ));
            request.setAttribute("category", mobilePhones);
        }
        else if(request.getParameter("category_name").equalsIgnoreCase("laptops")) {
            Category laptops = new Category("laptops", "laptop.jpg");
            laptops.setProductList(Arrays.asList(
                    new Product(1, "Acer", 100, "Acer s584185"),
                    new Product(2, "Macbook", 101050, "MacBook Pro")
            ));
            request.setAttribute("category", laptops);
        }

        return PagesPathEnum.CATEGORY_PAGE.getPath();
    }
}
