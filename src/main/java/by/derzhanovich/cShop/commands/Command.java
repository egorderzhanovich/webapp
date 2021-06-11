package by.derzhanovich.cShop.commands;

import by.derzhanovich.cShop.exception.ParamNullException;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    String execute(HttpServletRequest request) throws ParamNullException;
}
