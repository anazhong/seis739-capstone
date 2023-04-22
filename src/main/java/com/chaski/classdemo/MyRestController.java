package com.chaski.classdemo;
 

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ui.Model;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class MyRestController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private CalorieEntryService calorieEntryService;

    @GetMapping("/calorie-entries")
    public List<CalorieEntry> getAllEntries() {
      return calorieEntryService.getAllEntries();
    }

    @PostMapping("/calorie-entry")
    public void addEntry(@RequestBody CalorieEntry entry) {
      calorieEntryService.saveEntry(entry);
    }

    @DeleteMapping("/delete-calorie-entry")
    public void deleteEntryByDateAndCalories(@RequestBody DateAndCaloriesRequest request) {
        calorieEntryService.deleteEntryByDateAndCalories(request.getDate(), request.getCalories());
    }
}

class DateAndCaloriesRequest {
    private String date;
    private int calories;

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
