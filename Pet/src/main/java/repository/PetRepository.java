package repository;

import petservice.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PetRepository {

    private List<Pet> pets = new ArrayList<Pet>();

    public PetRepository() {
        // Initialize with some dummy data
        pets.add(createPet(1L, "Buddy", "Dog", "Golden Retriever", 5));
        pets.add(createPet(2L, "Whiskers", "Cat", "Siamese", 2));
        pets.add(createPet(3L, "Tweety", "Bird", "Canary", 1));
        pets.add(createPet(4L, "Max", "Dog", "Beagle", 3));
    }

    public List<Pet> getAllPets() {
        return new ArrayList<Pet>(pets);
    }

    public Pet getPetById(Long id) {
        for (Pet pet : pets) {
            if (pet.getId() == id) {
                return pet;
            }
        }
        return null;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void deletePet(Long id) {
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getId() == id) {
                pets.remove(i);
                break;
            }
        }
    }

    public List<Pet> searchPets(String name) {
        List<Pet> result = new ArrayList<Pet>();
        for (Pet pet : pets) {
            if (pet.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(pet);
            }
        }
        return result;
    }

    public List<Pet> sortPetsByAge() {
        List<Pet> sortedPets = new ArrayList<Pet>(pets);
        Collections.sort(sortedPets, new Comparator<Pet>() {
            @Override
            public int compare(Pet p1, Pet p2) {
                return p1.getAge() - p2.getAge();
            }
        });
        return sortedPets;
    }
    public List<Pet> filterPetsBySpecies(String species) {
        List<Pet> result = new ArrayList<Pet>();
        for (Pet pet : pets) {
            if (pet.getSpecies().equalsIgnoreCase(species)) {
                result.add(pet);
            }
        }
        return result;
    }

    private Pet createPet(Long id, String name, String species, String breed, int age) {
        Pet pet = new Pet();
        pet.setId(id);
        pet.setName(name);
        pet.setSpecies(species);
        pet.setBreed(breed);
        pet.setAge(age);
        return pet;
    }
}
