# Furryaide

## Overview

Furryaide is a SOAP-based application designed to facilitate the process of pet adoption. It enables users to list pets for adoption, apply for adoption, and manage pet adoption-related operations. The architecture follows Service-Oriented Architecture (SOA) principles.

# Installation Instructions for Furryaide Application

## Prerequisites

Ensure that Java 8 is installed on your system.

## Clone the Repository

```
git clone git@github.com:PromaChow/furryaide.git
cd furryaide
```

## Run the Project from IntelliJ

- Load Each Folder into IntelliJ
- Open IntelliJ IDEA.
- Load each folder (e.g., User, Permissions, Pets) as distinct projects:
- Click on File > Open.
- Select the folder and click OK.
- For each project, edit the configurations if necessary and run the application.

## Run the Project from Command Prompt

Run

```
cd <project_path>
mvn spring-boot:run
```

from the command prompt to run individual projects

## Actors

There are two main actors in the system:

1. **Customer**
2. **Pet Relinquisher**

## Request for Adoption by Customer

1. **Customer logs in**
2. **Customer browses through the list of pets and selects a pet to adopt**
3. **Customer gets a questionnaire prepared by the pet relinquisher. This questionnaire contains questions created by the Pet Relinquisher. The purpose is to check if the Customer is eligible to adopt the Pet or not.**
4. **Customer submits the questionnaire**

## Approval of Adoption by Pet Relinquisher

1. **Pet Relinquisher logs in**
2. **Pet Relinquisher creates a pet profile to give up for adoption**
3. **Pet Relinquisher creates a questionnaire to check if the customer is eligible for adopting**
4. **Pet Relinquisher approves adoption**

The thought process when designing the services was from the perspective how each events will happen in the user interface and how each service needs to be invoked. For example, we have two roles in our system and each role will be able to access certain services. So, instead of creating two separate services namely Customer and Pet Relinquisher it seemed more convenient to us to introduce `User` and `Permissions` Services. Moreover, each of the services responsibility was carefully designed so that it doesn't become reduntant while maintaining the SOA principles. The services we have designed are

## Utility Services

### JWTAuth Service

The JWTAuth service is responsible for generating and validating JSON Web Tokens (JWTs) to handle authentication securely. It is a utility service because it provides a reusable function for token-based authentication across different services.

### Notification Service

The Notification service sends notifications to users (both Customers and Pet Relinquishers) about various events such as adoption approval, questionnaire submission, etc. This service ensures that all stakeholders are kept informed about the status of their interactions within the system.

## Entity Services

### User Service

The User service performs basic CRUD operations on Users and uses JWTAuth and handles system-specific user credentials and login operations.

### Permissions Service

The Permissions service manages and verifies user permissions to ensure that users have the necessary rights to perform certain actions. It is not a utility service because it is managing system-specific permission control. It uses a private dummy database (a .txt file) mapping the usernames and the permissions. The checkPermission operation takes a token and a permission (the permission is a string that the request is checking if that particular user has) as input, validates the token through communicating with the JWTAuth service, parses the username from the token, and checks if that user possesses the particular permission.

### Pet Service

The Pet Service provides CRUD operations for pets.

## Task Services

### Manage Adoption Service

The Manage Adoption service comes up with functionalities like `requestAdoption`, `cancelAdoption`, '`rejectAdoption`, `getAdoptionStatus`,`getAdoptionDetails`. These operations cannot be accessed by everyone. A permission check is first done to check if a particular user can access a particular operation. For example, `requestAdoption` can only be used by users who have permission `request-adoption`. These service uses `User`, `Pet`, `Notification` and `Permission` service to achieve its functionality. 

### Manage Questionnaire Service

The Manage Questionnaire service comes up with functionalities like `createQuestionnaire`, `updateQuestionnaire`, `submitQuestionnaire`, `approveQuestionnaire`. In the same way as manage adoption service, a permission check is done. For example, `submitQuestionnaire` can only be accessed by the customer, hence users with permission  `submit-questionnaire` can access the operation.



**Point to be noted:** In all our services, we embed the token as an attribute and check if the token is valid and if the user has permission for accessing a particular service. We were inspired by SOAP request authenticated with WS-UsernameToken(https://stackoverflow.com/questions/3448498/example-of-soap-request-authenticated-with-ws-usernametoken). We did not use the wsse protocol but we tried to mimic that. Also referring this paper ```Dan, Ni, et al. "Attribute based access control (ABAC)-based cross-domain access control in service-oriented architecture (SOA)." 2012 International Conference on Computer Science and Service System. IEEE, 2012.``` since we were also inspired by some of the principles stated in the paper such as putting ABAC at different levels of the SOA.

## SOA Principles

### Principle #1: Service Contracts and Standardization

This principle states that: “Services share standardized contracts. Services within the same service inventory are in compliance with the same contract design standards.”

#### Design Standards

**Functional Expression Standards**

- Entity Services: Named according to the corresponding business entities they represent, such as Pet or Customer.
- Task Services: Named based on the process they automate, prefixed with an appropriate verb, such as ApproveAdoption.
- Operations: Named using the format verb + noun, for example, updateQuestion.
- Operation Naming: Operation names must not repeat the name of the service.

**Data Representation Standards**

- Reuse of Existing Complex Types: When complex types representing data constructs are already established by entity schemas, these existing types must be used.
- Service-Specific Schema Definitions: New complex types specific to a service are allowed only when necessary to meet unique processing requirements.
- XML Schema Definitions: All XML schema definitions must reside in separate files that are linked to the WSDL definitions.
- Centralized Schemas: The schemas reused by multiple services are stored in the central-schemas folder.

### Principle #2: Service Abstraction

Service abstraction is a principle that emphasizes hiding the implementation details of a service and exposing only the essential information necessary for consumers to interact with it. This principle ensures that:

- **Non-essential Information**: Any non-essential information about the service is abstracted away.
- **Service Contracts**: Only essential information is included in the service contracts, providing a clear and concise interface for consumers.
- **Limited Information Disclosure**: Information about the services is restricted to what is published in the service contracts, ensuring a controlled and consistent view of the service capabilities.

| **Aspect**                                              | **Description**                                                                                                                                                                                                                                                                                                                                        |
| ------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **Functional Abstraction (Content Abstraction)**        | Concise: The service contract provides targeted functionality with limited constraints. For example, we perform searchPets for Pet, validateToken for JWTAuth, and checkPermission for AccessControl services. The service contract hides the algorithmic details but gives a concise definition of how to access the functionalities of the services. |
| **Technology Information Abstraction (Access Control)** | Open Access: The technologies used to build and implement this service are openly documented and published as part of architecture specifications, ensuring transparency and ease of understanding for developers and consumers.                                                                                                                       |
| **Programmatic Abstraction (Access Control)**           | Open Access: Source code and design specifications are openly available on the local LAN, allowing developers to review and understand the implementation details if necessary.                                                                                                                                                                        |
| **Quality of Service (Access Control)**                 | Open Access: Since we are not developing our project for industry currently, we have not documented the components of the SLA (except for service description) as mentioned in the official website of IBM (https://www.ibm.com/topics/service-level-agreement).                                                                                       |

### Principle #3: Service Reusability

This principle states that "services contain and express agnostic logic and can be positioned as reusable enterprise resources.” This section details the reuse measurement of different services within the Furryaide application. The table below shows how many times each service has been reused across other services, providing insight into the reusability and utilization of these services.

| **Service**               | **Amount of Service Consumers** | **Used In**                                               | **Type of Reusability** |
| ------------------------- | ------------------------------- | --------------------------------------------------------- | ----------------------- |
| **User Service**          | 2                               | ManageAdoption, ManageQuestionnaire                          | Complete                |
| **JWTAuth Service**       | 2                               | ManageAdoption, ManageQuestionnaire  | Complete                |
| **Permissions Service**   | 2                               | ManageAdoption, ManageQuestionnaire                          | Targeted                |
| **Questionnaire Service** | 1                               |  ManageQuestionnaire                          | Complete                |
| **Pets Service**          | 1                               | ManageAdoption                                           | Complete                |
| **Notification Service**  | 1                               |  ManageAdoption                                                        | Complete                |
| **ManageQuestionnaire Service**  | 0                               | -                                                         | Targeted               |
| **ManageAdoption Service**  | 0                               | -                                                         | Targeted               |

The book stated two types of measures based on the number of service consumers and the frequency at which the consumers have consumed it. However, we are at a preliminary stage of development and have not integrated the services with the user interface to state the frequency yet. So, we have not integrated that measure here.

### Principle #4: Service Autonomy

The autonomy levels mentioned in the book are -

#### Service Isolation Levels

Service isolation is a key principle in Service-Oriented Architecture (SOA) that ensures services operate independently and maintain a clear boundary of responsibility. The isolation levels can be described as follows:

- **Service Contract Isolation**: Service contracts are designed in alignment with each other to avoid overlap of expressed functionality. This ensures that each service has a distinct and well-defined contract, focusing solely on the contract itself without overlapping functionalities.
- **Shared Implementation Isolation**: The logic and resources that comprise the underlying service implementation are shared with other parts of the enterprise. This type of isolation focuses on the capability of the implementation, ensuring that resources can be leveraged across multiple services while maintaining a unified implementation.
- **Service Logic Isolation**: The underlying logic is isolated, but data resources are shared with other parts of the enterprise. This level of isolation focuses on the capability of the service logic, ensuring that while the core logic remains isolated, data resources can be accessed and utilized by different services within the enterprise.
- **Pure Service Isolation**: The underlying logic and data resources are completely isolated and dedicated to the service. This level of isolation ensures that both the logic and data are exclusively used by the service, providing a high degree of independence and minimizing potential dependencies or conflicts with other parts of the enterprise.

We argue that all of our services except for `ManageAdoption` follow Pure Service Isolation. We have carefully curated each service so that the functionality and the underlying logic do not overlap. For example, primarily we have designed PetManagement service having the functionalities of searching, sorting and filtering pets. Then after analysis, we came to a decision that these capabilities should belong to Pet service instead. Moreover, to achieve data isolation, we have maintained separate dedicated dummy databases for services `Pet`, `User`, `Permissions` and `Questionnaire`.

### Principle #5: Loose Coupling

The table contains justification for how we achieved or omitted each type of coupling in our implementation.

# Couplings in Furryaide

| Coupling Type                           | Description                                                                                                          | Achieved/Omitted in Furryaide                                                                                                                                                                                                            |
| --------------------------------------- | -------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Logic-to-Contract Coupling**          | This type of coupling occurs when the service contract is tightly coupled to the underlying logic of the service.    | `Achieved` by automatically generating code from the service logic. We followed a `wsdl-first` approach.                                                                                                                                 |
| **Contract-to-Logic Coupling**          | This occurs when the service contract imposes specific requirements on the underlying logic.                         | `Omitted`: We kept the service contract independent of the underlying logic and implementation.                                                                                                                                          |
| **Contract-to-Technology Coupling**     | Occurs when service contracts are tied to specific technologies, limiting their interoperability.                    | `Omitted` by using technology-neutral contracts, such as standard WSDL and XML schemas, to promote interoperability. We have used SOAP protocol which establishes communication over HTTP.                                               |
| **Contract-to-Implementation Coupling** | Happens when service contracts are tied to specific implementations, including data models and APIs.                 | `Omitted` by abstracting implementation details and focusing on service capabilities in the contracts. Each Entity Service also maintains a dedicated database.                                                                          |
| **Contract-to-Functional Coupling**     | This occurs when a service contract is tightly coupled to a specific functionality or process within the enterprise. | `Achieved` by designing task services like `ManageAdoption` Service and `ManageQuestionnaire` Service are intentionally designed with functional coupling to specific business processes, ensuring they fulfill targeted roles effectively. |

### Principle #6: Statelessness

In the Furryaide application, we have implemented a design strategy known as Internally Deferred State Management to achieve high statelessness. This approach focuses on minimizing the amount of state information that is retained by services between requests. Here, we explain the strategy from the perspective of different types of state data: session data, context data, and business data.

### Types of State Data:

#### Session Data:

- **Definition**: Session data refers to temporary data that pertains to a user's interaction with a service during a session. This can include user preferences, temporary authentication tokens, and other transient information.
- **Implementation in Furryaide**:
  - **Token-Based Authentication**: We use JWT (JSON Web Token) for authentication provided by the `JWTAuth` service, which allows the user’s state (authentication details) to be encapsulated within the token itself. This eliminates the need for the service to maintain session state between requests. The token contains all necessary information, such as user identity and roles, which the service can decode and use to authenticate requests without maintaining session data.

#### Context Data:

- **Definition**: Context data includes information about the specific context of a transaction or request, such as request parameters, user location, and temporary settings that are relevant only for the duration of the transaction.
- **Implementation in Furryaide**:
  - **Request Parameters**: All context data required to process a request is included in the request itself. Each request carries its own context, ensuring that the service does not need to maintain or manage context data between requests. For example, search parameters for pets in case of `Pet` service are included in the search request payload.
  - **Stateless Operations**: Services are designed to process each request independently, relying entirely on the data provided within the request and the database. This ensures that context data is not stored or reused between requests.

#### Business Data:

- **Definition**: Business data consists of core data that is central to the business logic and operations, such as user profiles, pet information, questionnaire information, and other persistent data.
- **Implementation in Furryaide**:
  - **Database Interactions**: Business data is stored in dedicated databases. Services interact with the database to fetch or update business data as needed. This approach ensures that no business data is retained in the service layer between requests. For example, when a user submits an adoption request, the service processes the request by interacting with the database to fetch the relevant `Pet` and `Questionnaire` information from the dedicated databases embedded in their corresponding Entity Services.
  - **Persistent Storage**: By using persistent storage (databases), we ensure that business data is always available and up-to-date without requiring the service to maintain state.

### Principle #7: Composability of Services

In the Furryaide application, the services are composable. For instance, the `manageAdoption` service allows customers to request for adoption, cancel an adoption, and getting notifications whenever their adoption request is approved or rejected. Similarly, for pet relinquisher, this service offers functionalities like rejecting an adoption. This service utilizes shared functionalities such as `validateToken` provided by `JWTAuth` to verify the identity of the user,`checkPermission` provided by `Permissions` service to ensure they have the necessary permissions to access the specific operations exposed by the service, `updatePet` provided by the `Pet`, `sendNotification` from the `Notification` service.

On the other hand, the `manageQuestionnaire` service enables pet relinquishers to create questionnaires, review submitted questionnaires and approve or reject questionnaires. The customers are also able to submit the questionnaire using this service. This service also leverages shared functionalities such as `validateToken` provided by `JWTAuth` to verify the identity of the user,`checkPermission` provided by `Permissions` service to ensure they have the necessary permissions to access this service and `Question` service to make Questionnaire.

**Some things to be noted-**

- We promised to develop an adoption service where the Customer will be able to login and request adoption and the Relinquisher will be able to approve the requests.
- We did not promise profile management or notification services to be integrated. Hence, we did not explicitly handle those in our scenerio for now. 
- We believe the developed services fulfill the basic requirements or functionalities to get a Pet Adoption application up and running. Hence, we do think we have developed the functionalities we have promised.
- We have additionally developed Customer and PetRelinquisher services in somewhat incomplete way. We did not mention in our scenerio before. The reason is we developed it keeping User Profile Management in mind. But since we have not promised it, we did not intergate the services. Moreover, since our entire system is permission based we do not think extra services specifying roles like Customer and PetRelinquisher is necessary for our scenerio.

From the marking perspective, 50% was allocated if we could show we can run a service successfully. So, for that, we are going to add screenshots of the `User` service because we have developed it the very first.

# Service Execution Proof

## User Service

We present the following screenshots for the `User` service:

### AuthenticateUser Endpoint

<img width="1496" alt="Screenshot 2024-07-02 at 1 20 43 PM" src="https://github.com/PromaChow/wildflower/assets/48786787/dc33278d-b420-49a5-aad3-646177a61486">

### ValidateToken Endpoint

<img width="1453" alt="User Service Start" src="https://github.com/PromaChow/wildflower/assets/48786787/2a593df8-d389-4b63-adbb-889e8b8e83f7">

### CreateUser Endpoint

<img width="1473" alt="User Service Endpoint" src="https://github.com/PromaChow/wildflower/assets/48786787/fec967ba-42b7-41a1-9fa8-db46ecb16be4">

### UpdateUser Endpoint

<img width="1487" alt="User Service Response" src="https://github.com/PromaChow/wildflower/assets/48786787/4e65087a-373a-4e2a-8a84-24e919cbc867">

### ReadUser Screenshots

<img width="1501" alt="Additional Screenshot 1" src="https://github.com/PromaChow/wildflower/assets/48786787/be42581f-ce0a-4c14-8638-dba4e7459709">

### DeleteUser Screenshots

<img width="1491" alt="Additional Screenshot 2" src="https://github.com/PromaChow/wildflower/assets/48786787/e072b996-1fb0-4626-88f4-9f2cc6bfbc77">
