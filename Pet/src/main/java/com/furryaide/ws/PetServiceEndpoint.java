package com.furryaide.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import petservice.CreatePetRequest;
import petservice.CreatePetResponse;
import petservice.DeletePetRequest;
import petservice.DeletePetResponse;
import petservice.GetPetRequest;
import petservice.GetPetResponse;
import petservice.SearchPetsRequest;
import petservice.SearchPetsResponse;
import petservice.SortPetsRequest;
import petservice.SortPetsResponse;
import petservice.FilterPetsRequest;
import petservice.FilterPetsResponse;
import petservice.UpdatePetRequest;
import petservice.UpdatePetResponse;
import petservice.Pet;
import petservice.ObjectFactory;
import petservice.StatusCode;

@Endpoint
public class PetServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.furryaide/ws/PetService";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createPetRequest")
	@ResponsePayload
	public CreatePetResponse createPet(@RequestPayload CreatePetRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		StatusCode code = factory.createStatusCode();
		CreatePetResponse response = factory.createCreatePetResponse();
		code.setCode(200);
		response.setStatusCode(code);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updatePetRequest")
	@ResponsePayload
	public UpdatePetResponse updatePet(@RequestPayload UpdatePetRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		StatusCode code = factory.createStatusCode();
		UpdatePetResponse response = factory.createUpdatePetResponse();
		code.setCode(200);
		response.setStatusCode(code);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deletePetRequest")
	@ResponsePayload
	public DeletePetResponse deletePet(@RequestPayload DeletePetRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		DeletePetResponse response = factory.createDeletePetResponse();
		StatusCode code = factory.createStatusCode();
		code.setCode(204);
		response.setStatusCode(code);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPetRequest")
	@ResponsePayload
	public GetPetResponse getPet(@RequestPayload GetPetRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		GetPetResponse response = factory.createGetPetResponse();
		Pet pet = getPetById(request.getId());
		response.setPet(pet);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "searchPetsRequest")
	@ResponsePayload
	public SearchPetsResponse searchPets(@RequestPayload SearchPetsRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		SearchPetsResponse response = factory.createSearchPetsResponse();
		List<Pet> pets = searchPetsByQuery(request.getQuery());
		response.getPets().addAll(pets);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "sortPetsRequest")
	@ResponsePayload
	public SortPetsResponse sortPets(@RequestPayload SortPetsRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		SortPetsResponse response = factory.createSortPetsResponse();
		List<Pet> pets = sortPetsBy(request.getSortBy());
		response.getPets().addAll(pets);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "filterPetsRequest")
	@ResponsePayload
	public FilterPetsResponse filterPets(@RequestPayload FilterPetsRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		FilterPetsResponse response = factory.createFilterPetsResponse();
		List<Pet> pets = filterPetsBy(request.getFilterBy());
		response.getPets().addAll(pets);
		return response;
	}

	private Pet getPetById(Long id) {
		Pet pet = new Pet();
		pet.setId(id);
		pet.setName("Fido");
		pet.setSpecies("Dog");
		pet.setBreed("Labrador");
		pet.setAge(5);

		return pet;
	}

	private List<Pet> searchPetsByQuery(String query) {
		List<Pet> pets = new ArrayList<Pet>();
		// Add logic to search pets based on the query
		return pets;
	}

	private List<Pet> sortPetsBy(String sortBy) {
		List<Pet> pets = new ArrayList<Pet>();
		// Add logic to sort pets based on the sortBy criteria
		return pets;
	}

	private List<Pet> filterPetsBy(String filterBy) {
		List<Pet> pets = new ArrayList<Pet>();
		// Add logic to filter pets based on the filterBy criteria
		return pets;
	}
}
