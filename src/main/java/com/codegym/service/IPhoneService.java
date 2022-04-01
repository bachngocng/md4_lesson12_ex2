package com.codegym.service;

import com.codegym.model.Smartphone;

import java.util.Optional;

public interface IPhoneService {
    Iterable<Smartphone> findAll();

    Optional<Smartphone> findById(Long id);

    Smartphone save(Smartphone smartphone);

    void remove(Long id);
}