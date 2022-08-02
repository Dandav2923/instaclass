package com.clan.classe.repository;

import com.clan.classe.entity.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClasseRepository extends JpaRepository<Classe,Integer> {
    public List<Classe> findByClassNameContainsIgnoreCase(String nomeClasse);
    public List<Classe> findByClassNameIgnoreCase(String nomeClasse);
    @Query("select classe from Classe classe where classe.istituteFk = :idIstituto")
    public List<Classe> findByIstituteFk (@Param("idIstituto") Integer id);
    @Query("select classe from Classe classe where classe.istituteFk = :idIstituto")
    public List<Classe> findByClassName (@Param("idIstituto") Integer id);
    @Query("select classe from Classe classe where classe.istituteFk = :idIstituto AND classe.className LIKE :className")
    public List<Classe> findByClassNameContains (@Param("idIstituto") Integer id, @Param("className")String className);
    @Modifying
    @Query("delete from Classe classe where classe.id=:id")
    public void deleteById (@Param("id") Integer id);

    @Modifying
    @Query("delete from Classe classe where classe.istituteFk = :idIstituto AND classe.className LIKE :className" )
    public void deleteByClassName(@Param("idIstituto") Integer id, @Param("className")String className);
}
