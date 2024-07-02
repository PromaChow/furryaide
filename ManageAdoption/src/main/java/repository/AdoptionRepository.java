package repository;

import java.util.*;
import manageadoptionservice.*;

import static manageadoptionservice.Status.APPROVED;

public class AdoptionRepository {
    private static AdoptionRepository instance;
    private List<Adoption> adoptionRecords;
    private long nextId;

    private AdoptionRepository() {
        adoptionRecords = new ArrayList<Adoption>();
        nextId = 1;
    }

    public static synchronized AdoptionRepository getInstance() {
        if (instance == null) {
            instance = new AdoptionRepository();
        }
        return instance;
    }

    public Adoption addAdoptionRecord(long customerID, long petID, long relinquisherID) {
        Adoption adoptionDetails = new Adoption();
        adoptionDetails.setId(nextId++);
        adoptionDetails.setCustomerID(customerID);
        adoptionDetails.setPetID(petID);
        adoptionDetails.setRelinquisherID(relinquisherID);
        adoptionDetails.setStatus(APPROVED);

        adoptionRecords.add(adoptionDetails);
        return adoptionDetails;
    }

    public List<Adoption> getAllAdoptionRecords() {
        return adoptionRecords;
    }

    public Adoption getAdoptionRecord(long id) {
        for (Adoption record : adoptionRecords) {
            if (record.getId() == id) {
                return record;
            }
        }
        return null;
    }
}
