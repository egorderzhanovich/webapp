package by.derzhanovich.cShop.commands;

import by.derzhanovich.cShop.exception.ParamNullException;
import by.derzhanovich.cShop.model.Category;
import by.derzhanovich.cShop.model.Product;
import by.derzhanovich.cShop.model.User;
import by.derzhanovich.cShop.utils.PagesPathEnum;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static by.derzhanovich.cShop.utils.ParamValidator.validateParam;

public class SignInCommand implements Command{
    List<Category> categories = new ArrayList<>();
    @Override
    public String execute(HttpServletRequest request) throws ParamNullException {
        String login = request.getParameter("username");
        String psw = request.getParameter("password");

        validateParam(login);
        validateParam(psw);

        User user = getUser();

        return checkUsers(request,user);
    }
    private String checkUsers(HttpServletRequest request, User user){
        if(user!=null && request.getParameter("username").equals(user.getUsername())
                && request.getParameter("password").equals(user.getPassword())){
            request.getSession().setAttribute("username",user);

            request.setAttribute("categories", categories);
            return PagesPathEnum.HOME_PAGE.getPath();
        }
        else{
            return PagesPathEnum.SIGN_IN.getPath();
        }
    }

    private User getUser(){
        return new User("admin","admin");

    }

    {
        Category mobilePhones = new Category("Mobile phones", "mobile.jpg");
        Category laptops = new Category("Laptops", "laptop.jpg");
        Category fridges = new Category("Fridges", "fridge.jpg");
        Category car = new Category("Cars", "car.jpg");
        Category camera = new Category("Cameras", "camera.jpg");

        categories.add(mobilePhones);
        categories.add(laptops);
        categories.add(fridges);
        categories.add(car);
        categories.add(camera);



    }




}
