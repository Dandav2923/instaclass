package com.clan.istituto.service;


import com.clan.istituto.entity.Istituto;
import com.clan.istituto.repository.IstitutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IstitutoService {

    @Autowired
    private IstitutoRepository istitutoRepository;

    public Istituto register(Istituto ist) {
       return  istitutoRepository.save(ist);
    }
}
