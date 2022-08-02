package com.clan.istituto.service;

import com.clan.DTO.MateriaDTO;
import com.clan.istituto.entity.Istituto;
import com.clan.istituto.entity.Materia;
import com.clan.istituto.exception.docente.DatiNonValidiException;
import com.clan.istituto.exception.docente.MateriaNonTrovataException;
import com.clan.istituto.repository.IstitutoRepository;
import com.clan.istituto.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private IstitutoRepository istitutoRepository;

    public Materia registerMatter(MateriaDTO matDTO) throws DatiNonValidiException, MateriaNonTrovataException {
        if (matDTO.getNameMatter() == null || matDTO.getIdIstituto() == null || matDTO.getIdIstituto() == 0){
            throw new DatiNonValidiException("valori non validi");
        }
        Istituto ist = istitutoRepository.findById(matDTO.getIdIstituto()).orElse(null);
        if (ist == null) {
            throw new MateriaNonTrovataException("materia non trovata");
        }
        Materia mat = new Materia();
        mat.setNameMatter(matDTO.getNameMatter());
        mat.setMatterIstitute(ist);
        return materiaRepository.save(mat);

    }
}
