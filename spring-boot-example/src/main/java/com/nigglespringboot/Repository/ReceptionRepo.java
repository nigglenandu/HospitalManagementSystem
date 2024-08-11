package com.nigglespringboot.Repository;

import com.nigglespringboot.Entity.ReceptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptionRepo extends JpaRepository<ReceptionEntity, Integer> {
}
