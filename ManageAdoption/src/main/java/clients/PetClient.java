package clients;

import manageadoptionservice.Pet;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static clients.XMLUtils.getParsedOutput;

public class PetClient {
    private static final String PET_SERVICE_URL = "http://localhost:5001/wsdlfirst/PetService";

    public static Pet getPetById(long petId) throws IOException, ParserConfigurationException, SAXException {
        String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:pet=\"http://www.furryaide/ws/PetService\">" +
                "   <soapenv:Header/>" +
                "   <soapenv:Body>" +
                "      <pet:getPetRequest>" +
                "         <pet:id>" + petId + "</pet:id>" +
                "      </pet:getPetRequest>" +
                "   </soapenv:Body>" +
                "</soapenv:Envelope>";

        Document document = getParsedOutput(xmlInput, PET_SERVICE_URL);

        Pet pet = new Pet();
        pet.setId(Long.parseLong(document.getElementsByTagName("ns2:id").item(0).getTextContent()));
        pet.setName(document.getElementsByTagName("ns2:name").item(0).getTextContent());
        pet.setSpecies(document.getElementsByTagName("ns2:species").item(0).getTextContent());
        pet.setBreed(document.getElementsByTagName("ns2:breed").item(0).getTextContent());
        pet.setAge(Integer.parseInt(document.getElementsByTagName("ns2:age").item(0).getTextContent()));
        pet.setAdopted(Boolean.parseBoolean(document.getElementsByTagName("ns2:adopted").item(0).getTextContent()));

        return pet;
    }

    public static boolean updatePetStatus(Pet pet) throws IOException, ParserConfigurationException, SAXException {
        String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:pet=\"http://www.furryaide/ws/PetService\" xmlns:pet1=\"http://www.furryaide/ws/Pet\">" +
                "   <soapenv:Header/>" +
                "   <soapenv:Body>" +
                "      <pet:updatePetRequest>" +
                "         <pet:Pet>" +
                "            <pet1:id>" + pet.getId() + "</pet1:id>" +
                "            <pet1:name>" + pet.getName() + "</pet1:name>" +
                "            <pet1:species>" + pet.getSpecies() + "</pet1:species>" +
                "            <pet1:breed>" + pet.getBreed() + "</pet1:breed>" +
                "            <pet1:age>" + pet.getAge() + "</pet1:age>" +
                "            <pet1:adopted>" + pet.isAdopted() + "</pet1:adopted>" +
                "         </pet:Pet>" +
                "      </pet:updatePetRequest>" +
                "   </soapenv:Body>" +
                "</soapenv:Envelope>";

        Document document = getParsedOutput(xmlInput, PET_SERVICE_URL);
        return true;
    }
}
