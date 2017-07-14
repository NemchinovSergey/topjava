package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;


public class MealServlet extends HttpServlet {
    private static final Logger LOG = getLogger(MealServlet.class);

    private static List<Meal> meals;

    @Override
    public void init() throws ServletException {
        LOG.debug("init() begin");
        super.init();

        meals = Arrays.asList(
                new Meal(LocalDateTime.of(2015, Month.MAY, 29, 10, 0), "Завтрак", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 29, 13, 0), "Обед", 1500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 29, 20, 0), "Ужин", 700),
                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510),
                new Meal(LocalDateTime.of(2015, Month.JUNE, 1, 10, 0), "Завтрак", 300),
                new Meal(LocalDateTime.of(2015, Month.JUNE, 1, 13, 0), "Обед", 900),
                new Meal(LocalDateTime.of(2015, Month.JUNE, 1, 20, 0), "Ужин", 750)
        );
        meals.forEach(meal -> LOG.debug(meal.toString()));

        List<MealWithExceed> mealsWithExceeded = MealsUtil.getFilteredWithExceeded(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
        mealsWithExceeded.forEach(meal -> LOG.debug(meal.toString()));

        LOG.debug("init() end");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("doGet()");

        List<MealWithExceed> mealsWithExceeded = MealsUtil.getMealsWithExceeded(meals,2000);
        mealsWithExceeded.forEach(meal -> LOG.debug(meal.toString()));

        request.setAttribute("meals", mealsWithExceeded);

        LOG.debug("forward to meals.jsp");
        request.getRequestDispatcher("/meals.jsp").forward(request, response);

        LOG.debug("doGet() end");
    }
}
