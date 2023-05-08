package com.wisercat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    @Autowired
    PetRepository petRepository;



    public List<Pet> getAllPets() {
        List<Pet> result = (List<Pet>) petRepository.findAll();
        if(result.size() > 0) return result;
            else return new ArrayList<Pet>();
    }

    public Pet getPetById(Long id) throws RecordNotFoundException {
        Optional<Pet> pet = petRepository.findById(id);

        if(pet.isPresent()) return pet.get();
        else throw new RecordNotFoundException("No pets with given id");
    }

    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet updatePet(Pet pet, Long id) {
        Pet updatedPet = new Pet();
        updatedPet.setId(id);
        updatedPet.setName(pet.getName());
        updatedPet.setCode(pet.getCode());
        updatedPet.setColor(pet.getColor());
        updatedPet.setType(pet.getType());
        updatedPet.setCountry(pet.getCountry());

        return petRepository.save(updatedPet);
    }
}
