package com.nigglespringboot.Service;

import com.nigglespringboot.Entity.DoctorEntity;
import com.nigglespringboot.Repository.DoctorRepo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class DoctorServiceImpl implements IDoctorService {

    private final DoctorRepo doctorRepo;

    @Override
    public DoctorEntity saveDoctor(DoctorEntity doctorEntity) {
        log.info("Saving doctor: {}", doctorEntity.getName());
        return doctorRepo.save(doctorEntity);
    }

    @Override
    public List<DoctorEntity> getAllDoctors() {
        log.info("Fetching all doctors...");
        return doctorRepo.findAll();
    }

    @Override
    public Optional<DoctorEntity> getDoctorById(Integer id) {
        log.info("Fetching doctor by ID: {}", id);
        return doctorRepo.findById(id);
    }
}
