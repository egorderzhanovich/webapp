package by.derzhanovich.cShop.commands;

import by.derzhanovich.cShop.exception.ParamNullException;
import by.derzhanovich.cShop.utils.PagesPathEnum;

import javax.servlet.http.HttpServletRequest;

public class HomePageCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) throws ParamNullException {
        return PagesPathEnum.HOME_PAGE.getPath();
    }
}
