package by.derzhanovich.cShop.servlet;

import by.derzhanovich.cShop.commands.Command;
import by.derzhanovich.cShop.commands.CommandFactory;
import by.derzhanovich.cShop.exception.CommandException;
import by.derzhanovich.cShop.exception.ParamNullException;
import by.derzhanovich.cShop.utils.PagesPathEnum;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cShop")
public class CShopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        Command command = CommandFactory.defineCommand(req);
        String path;
        try {
        path = command.execute(req);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);

            requestDispatcher.forward(req,response);
        } catch (CommandException e) {
          req.getRequestDispatcher(PagesPathEnum.SIGN_IN.getPath()).forward(req,response);
        }
    }
}
