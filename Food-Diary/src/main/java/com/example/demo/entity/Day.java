package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="days")
public class Day extends CoreEntity<Day,Meal>{
    @NotNull(message = "value must be not null")
    private LocalDate dayDate;

    public Day(){}

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Meal> meals;

    @Override
    public void update(Day day) {
        setDayDate(day.getDayDate());
        setMeals(day.getMeals());
    }
    @Override
    public List<Meal> getCollection() {
        return getMeals();
    }
    @Override
    public void addToCollection(Meal meal) {
        getMeals().add(meal);
    }

    @Override
    public void removeFromCollection(Meal meal) {
        getMeals().remove(meal);
    }


    public LocalDate getDayDate() {
        return dayDate;
    }

    public void setDayDate(LocalDate dayDate) {
        this.dayDate = dayDate;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }
}
