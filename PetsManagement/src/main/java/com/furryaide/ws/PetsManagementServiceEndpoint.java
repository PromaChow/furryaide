package com.furryaide.ws;

import petsmanagementservice.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import clients.PetServiceClient;
import clients.AccessControlClient;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Endpoint
public class PetsManagementServiceEndpoint {

	private static final String NAMESPACE_URI = "http://www.furryaide/ws/PetsManagementService";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getManagedPetsRequest")
	@ResponsePayload
	public GetManagedPetsResponse getManagedPets(@RequestPayload GetManagedPetsRequest request) {
		GetManagedPetsResponse response = new GetManagedPetsResponse();
		ObjectFactory factory = new ObjectFactory();

		try {
			if (!AccessControlClient.checkPermission(request.getToken(), "view-pets")) {
				response.setStatusCode(createStatusCode(403));
				return response;
			}


			List<Pet> pets = PetServiceClient.getAllPets();
			response.getPets().addAll(pets);
			response.setStatusCode(createStatusCode(200));
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatusCode(createStatusCode(500));
		}

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getManagedPetDetailsRequest")
	@ResponsePayload
	public GetManagedPetDetailsResponse getManagedPetDetails(@RequestPayload GetManagedPetDetailsRequest request) {
		GetManagedPetDetailsResponse response = new GetManagedPetDetailsResponse();
		ObjectFactory factory = new ObjectFactory();

		try {
			if (!AccessControlClient.checkPermission(request.getToken(), "view-pet-details")) {
				response.setStatus(createStatusCode(403));
				return response;
			}

			Document document = PetServiceClient.getPetById(request.getPetId());
			Pet pet = parsePet(document);
			response.setPet(pet);
			response.setStatus(createStatusCode(200));
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(createStatusCode(500));
		}

		return response;
	}

	private List<Pet> parsePets(Document document) {
		List<Pet> pets = new ArrayList<Pet>();
		NodeList petNodes = document.getElementsByTagName("pet");
		for (int i = 0; i < petNodes.getLength(); i++) {
			Pet pet = new Pet();
			pet.setId(Long.parseLong(petNodes.item(i).getChildNodes().item(0).getTextContent()));
			pet.setName(petNodes.item(i).getChildNodes().item(1).getTextContent());
			pet.setSpecies(petNodes.item(i).getChildNodes().item(2).getTextContent());
			pet.setBreed(petNodes.item(i).getChildNodes().item(3).getTextContent());
			pet.setAge(Integer.parseInt(petNodes.item(i).getChildNodes().item(4).getTextContent()));
			pets.add(pet);
		}
		return pets;
	}

	private Pet parsePet(Document document) {
		NodeList petNodes = document.getElementsByTagName("pet");
		Pet pet = new Pet();
		pet.setId(Long.parseLong(petNodes.item(0).getChildNodes().item(0).getTextContent()));
		pet.setName(petNodes.item(0).getChildNodes().item(1).getTextContent());
		pet.setSpecies(petNodes.item(0).getChildNodes().item(2).getTextContent());
		pet.setBreed(petNodes.item(0).getChildNodes().item(3).getTextContent());
		pet.setAge(Integer.parseInt(petNodes.item(0).getChildNodes().item(4).getTextContent()));
		return pet;
	}

	private StatusCode createStatusCode(int code) {
		StatusCode status = new StatusCode();
		status.setCode(code);
		return status;
	}
}
