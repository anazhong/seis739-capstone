package com.chaski.classdemo;

import jakarta.persistence.*;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.Transient;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;



@Entity
public class CalorieEntry {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    private String date;

    @Column(name="calories")
    private int calories;

    public CalorieEntry() {
    }

    public CalorieEntry(String date, int calories) {
        this.date = date;
        this.calories = calories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}



// public class CalorieEntry {
//     private String date;
//     private int calories;
//
//     public CalorieEntry() {
//     }
//
//     public CalorieEntry(String date, int calories) {
//         this.date = date;
//         this.calories = calories;
//     }
//
//     public String getDate() {
//         return date;
//     }
//
//     public void setDate(String date) {
//         this.date = date;
//     }
//
//     public int getCalories() {
//         return calories;
//     }
//
//     public void setCalories(int calories) {
//         this.calories = calories;
//     }
// }