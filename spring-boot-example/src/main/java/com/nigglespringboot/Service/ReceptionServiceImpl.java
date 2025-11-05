package com.nigglespringboot.Service;

import com.nigglespringboot.Entity.ReceptionEntity;
import com.nigglespringboot.Repository.ReceptionRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ReceptionServiceImpl implements IReceptionService {

    @Autowired
    private ReceptionRepo receptionRepo;

    @Override
    public ReceptionEntity saveReception(ReceptionEntity receptionEntity) {
        log.info("Saving new reception: {}", receptionEntity);
        ReceptionEntity savedReception = receptionRepo.save(receptionEntity);
        log.debug("Reception saved successfully with ID: {}", savedReception.getId());
        return savedReception;
    }

    @Override
    public List<ReceptionEntity> getAllReceptions() {
        log.info("Fetching all receptions");
        List<ReceptionEntity> receptions = receptionRepo.findAll();
        log.debug("Total receptions found: {}", receptions.size());
        return receptions;
    }

    @Override
    public Optional<ReceptionEntity> getReceptionById(Integer id) {
        log.info("Fetching reception by ID: {}", id);
        Optional<ReceptionEntity> reception = receptionRepo.findById(id);

        if (reception.isPresent()) {
            log.debug("Reception found: {}", reception.get());
        } else {
            log.warn("No reception found with ID: {}", id);
        }

        return reception;
    }
}
