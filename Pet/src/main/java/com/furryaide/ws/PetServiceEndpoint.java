package com.furryaide.ws;


import petservice.*;
import repository.PetRepository;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class PetServiceEndpoint {

	private static final String NAMESPACE_URI = "http://www.furryaide/ws/PetService";
	private PetRepository petRepository = new PetRepository();

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createPetRequest")
	@ResponsePayload
	public CreatePetResponse createPet(@RequestPayload CreatePetRequest request) {
		ObjectFactory factory = new ObjectFactory();
		StatusCode code = factory.createStatusCode();
		CreatePetResponse response = factory.createCreatePetResponse();

		Pet pet = new Pet();
		pet.setId(request.getPet().getId());
		pet.setName(request.getPet().getName());
		pet.setSpecies(request.getPet().getSpecies());
		pet.setBreed(request.getPet().getBreed());
		pet.setAge(request.getPet().getAge());

		petRepository.addPet(pet);

		code.setCode(200);
		response.setStatusCode(code);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updatePetRequest")
	@ResponsePayload
	public UpdatePetResponse updatePet(@RequestPayload UpdatePetRequest request) {
		ObjectFactory factory = new ObjectFactory();
		StatusCode code = factory.createStatusCode();
		UpdatePetResponse response = factory.createUpdatePetResponse();

		Pet pet = petRepository.getPetById(request.getPet().getId());
		if (pet != null) {
			pet.setName(request.getPet().getName());
			pet.setSpecies(request.getPet().getSpecies());
			pet.setBreed(request.getPet().getBreed());
			pet.setAge(request.getPet().getAge());
			code.setCode(200);
		} else {
			code.setCode(404);
		}

		response.setStatusCode(code);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deletePetRequest")
	@ResponsePayload
	public DeletePetResponse deletePet(@RequestPayload DeletePetRequest request) {
		ObjectFactory factory = new ObjectFactory();
		DeletePetResponse response = factory.createDeletePetResponse();
		StatusCode code = factory.createStatusCode();

		petRepository.deletePet(request.getId());

		code.setCode(204);
		response.setStatusCode(code);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPetRequest")
	@ResponsePayload
	public GetPetResponse getPet(@RequestPayload GetPetRequest request) {
		ObjectFactory factory = new ObjectFactory();
		GetPetResponse response = factory.createGetPetResponse();
		System.out.println(request.getId());
		Pet pet = petRepository.getPetById(request.getId());
		response.setPet(pet);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "searchPetsRequest")
	@ResponsePayload
	public SearchPetsResponse searchPets(@RequestPayload SearchPetsRequest request) {
		ObjectFactory factory = new ObjectFactory();
		SearchPetsResponse response = factory.createSearchPetsResponse();
		List<Pet> pets = petRepository.searchPets(request.getQuery());
		response.getPets().addAll(pets);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "sortPetsRequest")
	@ResponsePayload
	public SortPetsResponse sortPets(@RequestPayload SortPetsRequest request) {
		ObjectFactory factory = new ObjectFactory();
		SortPetsResponse response = factory.createSortPetsResponse();
		List<Pet> pets = petRepository.sortPetsByAge();
		response.getPets().addAll(pets);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "filterPetsRequest")
	@ResponsePayload
	public FilterPetsResponse filterPets(@RequestPayload FilterPetsRequest request) {
		ObjectFactory factory = new ObjectFactory();
		FilterPetsResponse response = factory.createFilterPetsResponse();
		List<Pet> pets = petRepository.filterPetsBySpecies(request.getFilterBy());
		response.getPets().addAll(pets);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllPetsRequest")
	@ResponsePayload
	public GetAllPetsResponse getAllPets() {
		ObjectFactory factory = new ObjectFactory();
		GetAllPetsResponse response = factory.createGetAllPetsResponse();
		List<Pet> pets = petRepository.getAllPets();
		System.out.println(pets);
		response.getPets().addAll(pets);

		return response;
	}
}
