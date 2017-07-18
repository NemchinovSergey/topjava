package ru.javawebinar.topjava.dao;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static org.slf4j.LoggerFactory.getLogger;

public class MealMemoryDaoImpl implements MealDao {
    private static final Logger LOG = getLogger(MealMemoryDaoImpl.class);

    public final static ConcurrentHashMap<Integer, Meal> MEALS = new ConcurrentHashMap<>();

    static {
        LOG.debug("static initialization");

        List<Meal> mealList = Arrays.asList(
                new Meal(LocalDateTime.of(2017, Month.MAY, 29, 10, 0), "Завтрак", 500),
                new Meal(LocalDateTime.of(2017, Month.MAY, 29, 13, 0), "Обед", 1500),
                new Meal(LocalDateTime.of(2017, Month.MAY, 29, 20, 0), "Ужин", 700),
                new Meal(LocalDateTime.of(2017, Month.MAY, 30, 10, 0), "Завтрак", 500),
                new Meal(LocalDateTime.of(2017, Month.MAY, 30, 13, 0), "Обед", 1000),
                new Meal(LocalDateTime.of(2017, Month.MAY, 30, 20, 0), "Ужин", 500),
                new Meal(LocalDateTime.of(2017, Month.MAY, 31, 10, 0), "Завтрак", 1000),
                new Meal(LocalDateTime.of(2017, Month.MAY, 31, 13, 0), "Обед", 500),
                new Meal(LocalDateTime.of(2017, Month.MAY, 31, 20, 0), "Ужин", 510),
                new Meal(LocalDateTime.of(2017, Month.JUNE, 1, 10, 0), "Завтрак", 300),
                new Meal(LocalDateTime.of(2017, Month.JUNE, 1, 13, 0), "Обед", 900),
                new Meal(LocalDateTime.of(2017, Month.JUNE, 1, 20, 0), "Ужин", 750)
        );

        mealList.forEach(meal -> MEALS.put(MEALS.size(), meal));
    }
    
    @Override
    public void addMeal(Meal meal) {
        LOG.debug("addMeal: {}", meal);
        MEALS.put(meal.getId(), meal);
    }

    @Override
    public void deleteMeal(int id) {
        LOG.debug("deleteMeal: {}", id);
        MEALS.remove(id);
    }

    @Override
    public void updateMeal(Meal meal) {
        LOG.debug("updateMeal: {}", meal);
        MEALS.put(meal.getId(), meal);
    }

    @Override
    public Meal getMealById(int id) {
        LOG.debug("getMealById: {}", id);
        return MEALS.get(id);
    }

    @Override
    public List<Meal> getAllMeals() {
        LOG.debug("getAllMeals()");
        return new ArrayList<>(MEALS.values());
    }
}
