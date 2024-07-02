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
        adoptionRequests.put(request.getId(), request);
        return request.getId();
    }

    public boolean approveAdoption(long adoptionRequestID, long relinquisherID) {
        RequestAdoptionRequest request = adoptionRequests.get(adoptionRequestID);
        if (request != null && request.getStatus() == Status.PENDING) {
            request.setStatus(Status.APPROVED);


            // Store approved adoption details
            adoptionRepository.addAdoptionRecord(request.getCustomerID(), request.getPetID(), relinquisherID);

            return true;
        }
        return false;
    }

    public boolean rejectAdoption(long adoptionRequestID, long relinquisherID) {
        RequestAdoptionRequest request = adoptionRequests.get(adoptionRequestID);
        if (request != null && request.getStatus() == Status.PENDING) {
            request.setStatus(Status.REJECTED);

            return true;
        }
        return false;
    }

    public boolean cancelAdoption(long adoptionRequestID, String reason) {
        RequestAdoptionRequest request = adoptionRequests.get(adoptionRequestID);
        if (request != null && request.getStatus() == Status.PENDING) {
            request.setStatus(Status.CANCELLED);

            return true;
        }
        return false;
    }

    public Status getAdoptionStatus(long adoptionRequestID) {
        RequestAdoptionRequest request = adoptionRequests.get(adoptionRequestID);
        if (request != null) {
            return request.getStatus();
        }
        return null;
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
