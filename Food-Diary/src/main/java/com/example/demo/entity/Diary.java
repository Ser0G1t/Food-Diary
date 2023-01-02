package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="diaries")
public class Diary extends CoreEntity<Diary,Day>{

    public Diary(){}

    //start day
    @OneToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Day> days;

    @Override
    public void update(Diary diary) {

    }

    @Override
    public List<Day> getCollection() {
        return getDays();
    }

    @Override
    public void addToCollection(Day day) {
        getDays().add(day);
    }

    @Override
    public void removeFromCollection(Day day) {
        getDays().remove(day);
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }
}
