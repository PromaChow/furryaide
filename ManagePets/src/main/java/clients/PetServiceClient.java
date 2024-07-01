package clients;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import petsmanagementservice.Pet;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static clients.XMLUtils.getParsedOutput;

public class PetServiceClient {
    private static final String PET_SERVICE_URL = "http://localhost:5001/wsdlfirst/petService";

    public static List<Pet>  getAllPets() throws IOException, ParserConfigurationException, SAXException {
        String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:pet=\"http://www.furryaide/ws/PetService\">" +
                "   <soapenv:Header/>" +
                "   <soapenv:Body>" +
                "      <pet:getAllPetsRequest/>" +
                "   </soapenv:Body>" +
                "</soapenv:Envelope>";

        Document document = getParsedOutput(xmlInput, PET_SERVICE_URL);
        return parsePets(document);

    }

    public static Document getPetById(Long petId) throws IOException, ParserConfigurationException, SAXException {
        String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:pet=\"http://www.furryaide/ws/PetService\">" +
                "   <soapenv:Header/>" +
                "   <soapenv:Body>" +
                "      <pet:getPetRequest>" +
                "         <pet:id>" + petId + "</pet:id>" +
                "      </pet:getPetRequest>" +
                "   </soapenv:Body>" +
                "</soapenv:Envelope>";

        return getParsedOutput(xmlInput, PET_SERVICE_URL);
    }


    private static List<Pet> parsePets(Document document) {
        List<Pet> pets = new ArrayList<Pet>();
        NodeList petNodes = document.getElementsByTagName("ns3:pets");

        for (int i = 0; i < petNodes.getLength(); i++) {
            NodeList childNodes = petNodes.item(i).getChildNodes();
            Pet pet = new Pet();
            for (int j = 0; j < childNodes.getLength(); j++) {
                String nodeName = childNodes.item(j).getNodeName();
                if ("ns2:id".equals(nodeName)) {
                    pet.setId(Long.parseLong(childNodes.item(j).getTextContent()));
                } else if ("ns2:name".equals(nodeName)) {
                    pet.setName(childNodes.item(j).getTextContent());
                } else if ("ns2:species".equals(nodeName)) {
                    pet.setSpecies(childNodes.item(j).getTextContent());
                } else if ("ns2:breed".equals(nodeName)) {
                    pet.setBreed(childNodes.item(j).getTextContent());
                } else if ("ns2:age".equals(nodeName)) {
                    pet.setAge(Integer.parseInt(childNodes.item(j).getTextContent()));
                }
            }
            pets.add(pet);
        }
        return pets;
    }

    private static Pet parsePet(Document document) {
        NodeList petNodes = document.getElementsByTagName("ns3:pet");
        NodeList childNodes = petNodes.item(0).getChildNodes();
        Pet pet = new Pet();
        for (int j = 0; j < childNodes.getLength(); j++) {
            String nodeName = childNodes.item(j).getNodeName();
            if ("ns2:id".equals(nodeName)) {
                pet.setId(Long.parseLong(childNodes.item(j).getTextContent()));
            } else if ("ns2:name".equals(nodeName)) {
                pet.setName(childNodes.item(j).getTextContent());
            } else if ("ns2:species".equals(nodeName)) {
                pet.setSpecies(childNodes.item(j).getTextContent());
            } else if ("ns2:breed".equals(nodeName)) {
                pet.setBreed(childNodes.item(j).getTextContent());
            } else if ("ns2:age".equals(nodeName)) {
                pet.setAge(Integer.parseInt(childNodes.item(j).getTextContent()));
            }
        }
        return pet;
    }
}
