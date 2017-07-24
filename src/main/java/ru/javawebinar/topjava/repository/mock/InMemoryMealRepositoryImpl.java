package ru.javawebinar.topjava.repository.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class InMemoryMealRepositoryImpl implements MealRepository {
    private static final Logger log = LoggerFactory.getLogger(InMemoryMealRepositoryImpl.class);

    private Map<Integer, Meal> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        log.debug("object initialization");
        MealsUtil.MEALS.forEach(this::save);
    }

    @Override
    public Meal save(Meal meal) {
        log.debug("save: {}", meal);
        if (Objects.equals(meal.getId(), AuthorizedUser.id())) {
            if (meal.isNew()) {
                meal.setId(counter.incrementAndGet());
            }
            repository.put(meal.getId(), meal);
            return meal;
        }
        else {
            log.debug("Access denied! meal id {}, user id {}", meal.getId(), AuthorizedUser.id());
            return null;
        }
    }

    @Override
    public void delete(int userId, int mealId) {
        log.debug("delete: userId {}, mealId {}", userId, mealId);
        Meal meal = repository.get(mealId);
        if (Objects.equals(meal.getUserId(), userId)) {
            log.debug("Delete meal: user id {}, meal id {}", userId, meal.getId());
            repository.remove(mealId);
        }
        else {
            log.debug("Access denied! user id {}, meal id {}", userId, meal.getId());
        }
    }

    @Override
    public Meal get(int userId, int mealId) {
        log.debug("get: userId {}, mealId {}", userId, mealId);
        Meal meal = repository.get(mealId);
        return Objects.equals(meal.getUserId(), userId) ? meal : null;
    }

    @Override
    public List<Meal> getAllByUserId(int userId) {
        log.debug("getAllByUserId: {}", userId);
        return repository.values().stream()
                .filter(u -> Objects.equals(u.getUserId(), userId))
                .sorted(Comparator.comparing(Meal::getDateTime))
                .collect(Collectors.toList());
    }
}

