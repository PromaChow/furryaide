package com.furryaide.ws;

import java.util.HashMap;
import java.util.Map;
import repository.AdoptionRepository;
import manageadoptionservice.*;

public class AdoptionManagementService {
    private Map<Long, RequestAdoptionRequest> adoptionRequests = new HashMap<Long, RequestAdoptionRequest>();
    private AdoptionRepository adoptionRepository = AdoptionRepository.getInstance();
    private long nextId = 1;

    public long requestAdoption(long customerID, long petID) {
        RequestAdoptionRequest request = new RequestAdoptionRequest();

        request.setCustomerID(customerID);
        request.setPetID(petID);
        request.setStatus(Status.PENDING);
        adoptionRequests.put(request.getPetID(), request);
        System.out.println(request.getPetID());
//        System.out.println("adopt"+adoptionRequests.get(request.getPetID()));
        return request.getId();
    }

    public boolean approveAdoption(long adoptionRequestID, long relinquisherID) {

        RequestAdoptionRequest request = adoptionRequests.get(adoptionRequestID);
        request.setStatus(Status.APPROVED);
        System.out.println(request.getStatus());
        adoptionRepository.addAdoptionRecord(request.getCustomerID(), request.getPetID(), relinquisherID);

        return true;
    }

    public boolean rejectAdoption(long adoptionRequestID, long relinquisherID) {
        RequestAdoptionRequest request = adoptionRequests.get(adoptionRequestID);
        request.setStatus(Status.REJECTED);

        return true;

    }

    public boolean cancelAdoption(long adoptionRequestID, String reason) {
        RequestAdoptionRequest request = adoptionRequests.get(adoptionRequestID);
        request.setStatus(Status.CANCELLED);

        return true;
    }

    public Status getAdoptionStatus(long adoptionRequestID) {
        RequestAdoptionRequest request = adoptionRequests.get(adoptionRequestID);
        return request.getStatus();
    }

    public Adoption getAdoptionDetails(long adoptionRequestID) {
        Adoption details = adoptionRepository.getAdoptionRecord(adoptionRequestID);
        if (details != null) {
            Adoption adoption = new Adoption();
            adoption.setId(details.getId());
            adoption.setCustomerID(details.getCustomerID());
            adoption.setPetID(details.getPetID());
            adoption.setStatus(details.getStatus());
            adoption.setRelinquisherID(details.getRelinquisherID());
            return adoption;
        }
        return null;
    }
}
