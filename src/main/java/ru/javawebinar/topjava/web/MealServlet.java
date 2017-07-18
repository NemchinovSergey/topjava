package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.MealDao;
import ru.javawebinar.topjava.dao.MealMemoryDaoImpl;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;


public class MealServlet extends HttpServlet {
    private static final Logger LOG = getLogger(MealServlet.class);

    private static String MEAL_VIEW = "/meal.jsp";
    private static String LIST_MEALS = "/meals.jsp";

    private MealDao mealDao;

    public MealServlet() {
        mealDao = new MealMemoryDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("doGet()");

        List<MealWithExceed> mealsWithExceeded = MealsUtil.getMealsWithExceeded(mealDao.getAllMeals(), MealsUtil.DEFAULT_CALORIES_PER_DAY);
        request.setAttribute("meals", mealsWithExceeded);


        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            mealDao.deleteMeal(id);
            forward = LIST_USER;
            request.setAttribute("meals", mealDao.getAllUsers());
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int userId = Integer.parseInt(request.getParameter("id"));
            User user = dao.getUserById(userId);
            request.setAttribute("user", user);
        } else if (action.equalsIgnoreCase("listUser")){
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());
        } else {
            forward = INSERT_OR_EDIT;
        }

        request.getRequestDispatcher("/meals.jsp").forward(request, response);
        /*RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);*/
    }
}
