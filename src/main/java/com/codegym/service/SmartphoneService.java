package com.codegym.service;

import com.codegym.model.Smartphone;
import com.codegym.repository.IPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartphoneService implements IPhoneService {
    @Autowired
    private IPhoneRepository phoneRepository;

    @Override
    public Iterable<Smartphone> findAll() {
        return phoneRepository.findAll();
    }

    @Override
    public Optional<Smartphone> findById(Long id) {
        return phoneRepository.findById(id);
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
        return phoneRepository.save(smartphone);
    }

    @Override
    public void remove(Long id) {
        phoneRepository.deleteById(id);
    }
}
