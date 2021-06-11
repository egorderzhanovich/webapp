package by.derzhanovich.cShop.utils;

import by.derzhanovich.cShop.exception.ParamNullException;

public class ParamValidator {

    public static void validateParam(String parameter) throws ParamNullException {
        if(parameter == null){
            throw new ParamNullException("Parameters is not initialized!");
        }

    }
}
