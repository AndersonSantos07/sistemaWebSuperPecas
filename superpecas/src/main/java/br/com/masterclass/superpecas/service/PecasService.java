package br.com.masterclass.superpecas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.masterclass.superpecas.repository.PecasRepository;

@Service
public class PecasService {

    @Autowired
    private PecasRepository pecasRepository;
}
