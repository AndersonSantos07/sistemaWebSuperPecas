package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PecasRepository;

@Service
public class PecasService {

    @Autowired
    private PecasRepository pecasRepository;
}
