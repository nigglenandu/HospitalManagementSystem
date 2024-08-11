package com.nigglespringboot.Repository;

import com.nigglespringboot.Entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends JpaRepository<AppointmentEntity, Integer> {
}
