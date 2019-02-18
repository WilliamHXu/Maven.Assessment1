package com.zipcodewilmington.assessment1.part3;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by leon on 2/16/18.
 */
public class PetOwner {
    /**
     * @param name name of the owner of the Pet
     * @param pets array of Pet object
     */
    private String name;
    private Pet[] pets;

    public PetOwner(String name, Pet... pets) {
        this.name = name;
        Pet[] tempPets = pets;
        try {
            for (Pet pet : pets) {
                pet.setOwner(this);
            }
        }
        catch (Exception e){}
        this.pets = tempPets;

    }



    /**
     * @param pet pet to be added to the composite collection of Pets
     */
    public void addPet(Pet pet) {
        if (pets == null) {this.pets = new Pet[0];}
        Pet[] newPetArray = new Pet[pets.length + 1];
        for (int i = 0; i < pets.length; i++) {
            newPetArray[i] = pets[i];
        }
        newPetArray[newPetArray.length-1] = pet;
        this.pets = newPetArray;
    }

    /**
     * @param pet pet to be removed from the composite collection Pets
     */
    public void removePet(Pet pet) {
        try {
            Pet[] newPetArray = new Pet[pets.length - 1];
            if (newPetArray.length == 0) {
                this.pets = new Pet[0];
            }
            else {
                boolean removed = false;
                for (int i = 0, j = 0; i < pets.length; i++) {
                    if (!pets[i].equals(pet) || removed) {
                        newPetArray[j++] = pets[i];
                    }
                    else {
                        removed = true;
                    }
                }
                this.pets = newPetArray;
            }
        }
        catch (Exception e){

        }
    }

    /**
     * @param pet pet to evaluate ownership of
     * @return true if I own this pet
     */
    public Boolean isOwnerOf(Pet pet) {
        Boolean owner = false;
        for (Pet p : pets) {
            if (p.equals(pet)) {
                owner = true;
            }
        }
        return owner;
    }

    /**
     * @return the age of the Pet object whose age field is the lowest amongst all Pets in this class
     */
    public Integer getYoungetPetAge() {
        Integer youngestAge = pets[0].getAge();
        for (Pet p : pets) {
            if (p.getAge() < youngestAge) {
                youngestAge = p.getAge();
            }
        }
        return youngestAge;
    }




    /**
     * @return the age of the Pet object whose age field is the highest amongst all Pets in this class
     */
    public Integer getOldestPetAge() {
        Integer oldestAge = pets[0].getAge();
        for (Pet p : pets) {
            if (p.getAge() > oldestAge) {
                oldestAge = p.getAge();
            }
        }
        return oldestAge;
    }


    /**
     * @return the sum of ages of Pet objects stored in this class divided by the number of Pet object
     */
    public Float getAveragePetAge() {
        Float sum = 0f;
        for (Pet pet : pets) {
            sum += pet.getAge();
        }
        return sum/pets.length;
    }

    /**
     * @return the number of Pet objects stored in this class
     */
    public Integer getNumberOfPets() {
        for (Pet p: pets) {
            System.out.println(p);
        }
        return pets.length;
    }

    /**
     * @return the name property of the Pet
     */
    public String getName() {
        return name;
    }

    /**
     * @return array representation of animals owned by this PetOwner
     */
    public Pet[] getPets() {
        if(getNumberOfPets() != 0) {

            System.out.println("In try statement");
            return pets;
        }
        else{
            Pet[] noPets = new Pet[1];
            return noPets;
        }
    }
}
