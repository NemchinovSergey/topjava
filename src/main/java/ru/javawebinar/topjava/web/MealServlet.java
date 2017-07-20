package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.MealDao;
import ru.javawebinar.topjava.dao.MealMemoryDaoImpl;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.util.TimeUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import static org.slf4j.LoggerFactory.getLogger;


public class MealServlet extends HttpServlet {
    private static final Logger LOG = getLogger(MealServlet.class);

    private static String INSERT_OR_EDIT = "/meal.jsp";
    private static String LIST_MEALS = "/meals.jsp";

    private MealDao mealDao;

    public MealServlet() {
        mealDao = new MealMemoryDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("doGet()");

        String forward = null;
        String action = request.getParameter("action");

        if ("DELETE".equalsIgnoreCase(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            mealDao.delete(id);
            response.sendRedirect("meals");
            return;
        } if ("EDIT".equalsIgnoreCase(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            forward = INSERT_OR_EDIT;
            request.setAttribute("meal", mealDao.get(id));
        } else if ("ADD".equalsIgnoreCase(action)) {
            forward = INSERT_OR_EDIT;
        }

        if (forward == null || forward.isEmpty()) {
            forward = LIST_MEALS;
            request.setAttribute("meals", MealsUtil.getMealsWithExceeded(mealDao.getAll(), MealsUtil.DEFAULT_CALORIES_PER_DAY));
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.debug("doPost()");
        req.setCharacterEncoding("UTF-8");

        String id = req.getParameter("id");
        String description = req.getParameter("desc");

        LocalDateTime dateTime;
        try {
            dateTime = LocalDateTime.parse(req.getParameter("date"), TimeUtil.formatter);
        }
        catch (DateTimeParseException e) {
            dateTime = LocalDateTime.now();
        }

        int calories;
        try {
            calories = Integer.parseInt(req.getParameter("calories"));
        }
        catch (Exception e) {
            calories = 0;
        }

        Meal meal = new Meal(dateTime, description, calories);

        if (id != null && !id.isEmpty()) {
            meal.setId(Integer.parseInt(id));
        }

        mealDao.save(meal);

        resp.sendRedirect("meals");
    }
}
