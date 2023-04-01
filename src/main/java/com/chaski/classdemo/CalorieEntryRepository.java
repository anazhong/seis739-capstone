package com.chaski.classdemo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CalorieEntryRepository extends JpaRepository<CalorieEntry, Long> {
    void deleteByDateAndCalories(String date, int calories);
}
