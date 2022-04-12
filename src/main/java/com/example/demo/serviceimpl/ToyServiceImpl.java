package com.example.demo.serviceimpl;
import java.util.List;

import com.example.demo.entity.Toy;
import com.example.demo.repository.ToyRepository;
import com.example.demo.service.ToyService;
import org.springframework.stereotype.Service;


@Service
public class ToyServiceImpl implements ToyService {

    private ToyRepository toyRepository;

    public ToyServiceImpl(ToyRepository toyRepository) {
        super();
        this.toyRepository = toyRepository;
    }

    @Override
    public List<Toy> getAllToys() {
        return toyRepository.findAll();
    }

    @Override
    public Toy saveToy(Toy toy) {
        return toyRepository.save(toy);
    }

    @Override
    public Toy getToyById(Long id) {
        return toyRepository.findById(id).get();
    }

    @Override
    public Toy updateToy(Toy toy) {
        return toyRepository.save(toy);
    }

    @Override
    public void deleteToyById(Long id) {
        toyRepository.deleteById(id);
    }

}

