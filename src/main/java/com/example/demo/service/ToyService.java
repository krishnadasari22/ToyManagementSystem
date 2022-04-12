package com.example.demo.service;
import java.util.List;

import com.example.demo.entity.Toy;

public interface ToyService {
    List<Toy> getAllToys();

    Toy saveToy(Toy toy);

    Toy getToyById(Long id);

    Toy updateToy(Toy toy);

    void deleteToyById(Long id);

}
