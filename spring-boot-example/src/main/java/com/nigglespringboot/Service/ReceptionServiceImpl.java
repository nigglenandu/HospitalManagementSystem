package com.nigglespringboot.Service;

import com.nigglespringboot.Entity.ReceptionEntity;
import com.nigglespringboot.Repository.ReceptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceptionServiceImpl implements IReceptionService{
    @Autowired
    ReceptionRepo receptionRepo;

    public ReceptionEntity saveReception(ReceptionEntity receptionEntity){
        receptionRepo.save(receptionEntity);
        return receptionEntity;
    }

    public List<ReceptionEntity> getAllReceptions(){
        return receptionRepo.findAll();
    }

    public ReceptionEntity getReceptionById(Integer id){
        Optional<ReceptionEntity> optional = receptionRepo.findById(id);
        return optional.get();
    }

}
