package com.Altera.task.service;

import com.Altera.task.entity.Vessel;
import com.Altera.task.repository.VesselRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VesselService {
    @Autowired
    VesselRepository vesselRepository;
    public Vessel create(Vessel vessel){
        return vesselRepository.save(vessel);
    }

    public List<Vessel> findAll(){
        return (List<Vessel>) vesselRepository.findAll();
    }

    public Vessel findOne(Integer id) {
        return vesselRepository.findById(id).get();
    }

    public Vessel update(Vessel vessel){
        return vesselRepository.save(vessel);
    }

    public void deleteOne(Integer id){
        vesselRepository.deleteById(id);
    }

}
