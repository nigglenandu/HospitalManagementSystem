package com.nigglespringboot.Service;

import com.nigglespringboot.Entity.ReceptionEntity;

import java.util.List;
import java.util.Optional;

public interface IReceptionService {

    public ReceptionEntity saveReception(ReceptionEntity receptionEntity);
    public List<ReceptionEntity> getAllReceptions();
    public Optional<ReceptionEntity> getReceptionById(Integer id);
}
