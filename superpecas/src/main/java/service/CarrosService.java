package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CarrosRepository;

@Service
public class CarrosService {

    @Autowired
    private CarrosRepository carrosRepository;
}
