package com.chaski.classdemo;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalorieEntryService {

    @Autowired
    private CalorieEntryRepository calorieEntryRepository;

    public List<CalorieEntry> getAllEntries() {
        return calorieEntryRepository.findAll();
    }

    public Optional<CalorieEntry> getEntryById(Long id) {
        return calorieEntryRepository.findById(id);
    }

    public CalorieEntry saveEntry(CalorieEntry entry) {
        return calorieEntryRepository.save(entry);
    }

    @Transactional
    public void deleteEntryByDateAndCalories(String date, int calories) {
        calorieEntryRepository.deleteByDateAndCalories(date, calories);
    }
}
