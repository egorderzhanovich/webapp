package by.derzhanovich.cShop.commands;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static final Map<String,Command> COMMAND_MAP = new HashMap<>();

    static{
        COMMAND_MAP.put("cShop", new HomePageCommand());
        COMMAND_MAP.put("sign-in", new SignInCommand());
        COMMAND_MAP.put("category-redirect",new CategoryCommand());
        COMMAND_MAP.put("add-product-to-cart", new AddProductToCartCommand());
        COMMAND_MAP.put("redirect-to-shopping-cart", new RedirectToShoppingCart());
        COMMAND_MAP.put("product-redirect", new RedirectProductPageCommand());
    }

    public static Command defineCommand(HttpServletRequest request) {
        String commandKey = request.getParameter("command");
        if(commandKey == null || commandKey.isEmpty()){
            commandKey = "sign-in";
        }
        return COMMAND_MAP.get(commandKey);
    }
}
