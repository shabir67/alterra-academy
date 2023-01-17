package com.Altera.task.controller;

import com.Altera.task.entity.User;
import com.Altera.task.entity.Vessel;
import com.Altera.task.service.VesselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class VesselController {
    @Autowired
    VesselService vesselService;

    @GetMapping(path = "/v1/vessels")
    public List<Vessel> getAllVessel(){
        return (List<Vessel>) vesselService.findAll();
    }

    @GetMapping(path="/v1/vessels/{id}")
    public Vessel getOneVessel(@PathVariable("id") Integer id) {
        return vesselService.findOne(id);
    }

    @PostMapping("/v1/vessels")
    public Vessel createVessel(@RequestBody Vessel vessel){
        return  vesselService.create(vessel);
    }

    @PutMapping("/v1/vessels")
    public Vessel updateVessel(@RequestBody Vessel vessel){
        return vesselService.update(vessel);
    }

    @DeleteMapping("/v1/vessels/{id}")
    public String deleteVessel(@PathVariable("id") Integer id){

        vesselService.deleteOne(id);
        return "Deleted Successfully";

    }
}
