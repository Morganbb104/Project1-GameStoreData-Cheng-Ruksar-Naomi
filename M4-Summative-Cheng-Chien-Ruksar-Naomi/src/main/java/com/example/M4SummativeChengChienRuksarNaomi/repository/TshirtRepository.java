package com.example.M4SummativeChengChienRuksarNaomi.repository;


import com.example.M4SummativeChengChienRuksarNaomi.models.Tshirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TshirtRepository extends JpaRepository<Tshirt, Integer> {

    List<Tshirt> findBySize(String size);
    List<Tshirt> findByColor(String color);

}
