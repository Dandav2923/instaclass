package com.clan.instaclass.classService.repositories;

import com.clan.instaclass.classService.entities.VoteEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<VoteEnt, Integer> {
}
