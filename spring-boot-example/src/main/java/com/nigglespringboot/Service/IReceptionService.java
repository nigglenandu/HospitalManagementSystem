package com.nigglespringboot.Service;

import com.nigglespringboot.Entity.ReceptionEntity;

import java.util.List;

public interface IReceptionService {

    public ReceptionEntity saveReception(ReceptionEntity receptionEntity);
    public List<ReceptionEntity> getAllReceptions();
    public ReceptionEntity getReceptionById(Integer id);
}
