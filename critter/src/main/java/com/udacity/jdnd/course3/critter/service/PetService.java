package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.Repository.PetRepository;
import com.udacity.jdnd.course3.critter.entities.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class PetService {
    @Autowired
    PetRepository petRepository;

    public Pet savePet(Pet pet){
        return petRepository.save(pet);
    }
    public List<Pet> getAllPets(){
        return petRepository.findAll();
    }
    public Pet getPetById(Long id){
        return petRepository.getOne(id);
    }

    public List<Pet> getPetsByOwner(Long ownerid){
        List<Pet> pets = petRepository.findPetByownerid(ownerid);
        System.out.println(pets.get(0).getId());
        return pets;
    }
}
