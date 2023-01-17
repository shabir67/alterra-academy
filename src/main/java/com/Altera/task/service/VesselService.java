package com.Altera.task.service;

import com.Altera.task.entity.VesselEntitiy;
import com.Altera.task.repository.VesselRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VesselService {
    @Autowired
    VesselRepository vesselRepository;
    public VesselEntitiy create(VesselEntitiy vessel){
        return vesselRepository.save(vessel);
    }

    public VesselEntitiy update(VesselEntitiy vessel){
        return
    }

    public VesselEntitiy deleteOne(Integer id){
        vesselRepository.deleteById(id);
    }

}
