# Wildflower

## Overview

Furryaide is a SOAP-based application designed to facilitate the process of pet adoption. It enables users to list pets for adoption, apply for adoption, and manage pet adoption-related operations. The architecture follows Service-Oriented Architecture (SOA) principles, ensuring schema centralization, loose coupling, and service reusability.

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

### Request Adoption Service
The Request Adoption service can only be accessed by users having the permission request-adoption. This service includes capabilities such as listing all pets and submitting a questionnaire for a pet.

### Approve Adoption Service
The Approve Adoption service can only be accessed by users having the permission approve-adoption. This service includes capabilities such as listing all questionnaires and approving a questionnaire submission request for a pet.

### Send Notification Service
The Send Notification service includes functionalities like sending notifications to users.

**Point to be noted:** In all our services, we embed the token as an attribute and check if the token is valid and if the user has permission for accessing a particular service. We were inspired by SOAP request authenticated with WS-UsernameToken(https://stackoverflow.com/questions/3448498/example-of-soap-request-authenticated-with-ws-usernametoken). We did not use the wsse protocol but we tried to mimic that.

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

**Aspect** | **Description**
--- | ---
**Functional Abstraction (Content Abstraction)** | Concise: The service contract provides targeted functionality with limited constraints. For example, we perform searchPets for Pet, validateToken for JWTAuth, and checkPermission for AccessControl services. The service contract hides the algorithmic details but gives a concise definition of how to access the functionalities of the services.
**Technology Information Abstraction (Access Control)** | Open Access: The technologies used to build and implement this service are openly documented and published as part of architecture specifications, ensuring transparency and ease of understanding for developers and consumers.
**Programmatic Abstraction (Access Control)** | Open Access: Source code and design specifications are openly available on the local LAN, allowing developers to review and understand the implementation details if necessary.
**Quality of Service (Access Control)** | Open Access: Since we are not developing our project for industry currently, we have not documented the components of the SLA (except for service description) as mentioned in the official website of IBM (https://www.ibm.com/topics/service-level-agreement).

### Principle #3: Service Reusability
This principle states that "services contain and express agnostic logic and can be positioned as reusable enterprise resources.” This section details the reuse measurement of different services within the Furryaide application. The table below shows how many times each service has been reused across other services, providing insight into the reusability and utilization of these services.

| **Service**             | **Amount of Service Consumers** | **Used In**                               | **Type of Reusability** |
|-------------------------|---------------------------------|-------------------------------------------|-------------------------|
| **User Service**  | 2                               |  ApproveAdoption, RequestAdoption | Complete                |
| **JWTAuth Service**             | 2                               |  ApproveAdoption, RequestAdoption (via UserAuthentication) | Complete                |
| **Permissions Service**       | 2                               |  ApproveAdoption, RequestAdoption | Targeted                |
| **Questionnaire Service**       | 2                               | ApproveAdoption, RequestAdoption          | Complete                |
| **Pets Service**                | 1                               | RequestAdoption                           | Complete                |
| **Notification Service**        | 0                               | -                   | Complete                |


The book stated two types of measures based on the number of service consumers and the frequency at which the consumers have consumed it. However, we are at a preliminary stage of development and have not integrated the services with the user interface to state the frequency yet. So, we have not integrated that measure here.

### Principle #4: Service Autonomy
The autonomy levels mentioned in the book are -

#### Service Isolation Levels
Service isolation is a key principle in Service-Oriented Architecture (SOA) that ensures services operate independently and maintain a clear boundary of responsibility. The isolation levels can be described as follows:

- **Service Contract Isolation**: Service contracts are designed in alignment with each other to avoid overlap of expressed functionality. This ensures that each service has a distinct and well-defined contract, focusing solely on the contract itself without overlapping functionalities.
- **Shared Implementation Isolation**: The logic and resources that comprise the underlying service implementation are shared with other parts of the enterprise. This type of isolation focuses on the capability of the implementation, ensuring that resources can be leveraged across multiple services while maintaining a unified implementation.
- **Service Logic Isolation**: The underlying logic is isolated, but data resources are shared with other parts of the enterprise. This level of isolation focuses on the capability of the service logic, ensuring that while the core logic remains isolated, data resources can be accessed and utilized by different services within the enterprise.
- **Pure Service Isolation**: The underlying logic and data resources are completely isolated and dedicated to the service. This level of isolation ensures that both the logic and data are exclusively used by the service, providing a high degree of independence and minimizing potential dependencies or conflicts with other parts of the enterprise.

We argue that all of our services except for `RequestAdoption` follow Pure Service Isolation. We have carefully curated each service so that the functionality and the underlying logic do not overlap. For example, primarily we have designed PetManagement service having the functionalities of searching, sorting and filtering pets. Then after analysis, we came to a decision that these capabilities should belong to Pet service instead. Moreover, to achieve data isolation, we have maintained separate dedicated dummy databases for services `Pet`, `User`, `Permissions` and `Questionnaire`.
### Principle #5: Loose Coupling
The table contains justification for how we achieved or omitted each type of coupling in our implementation.
# Couplings in Furryaide

| Coupling Type                   | Description                                                                                                                   | Achieved/Omitted in Furryaide                                                                                       |
|---------------------------------|-------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------|
| **Logic-to-Contract Coupling**  | This type of coupling occurs when the service contract is tightly coupled to the underlying logic of the service.             | `Achieved` by automatically generating code from the service logic. We followed a `wsdl-first` approach. |
| **Contract-to-Logic Coupling**  | This occurs when the service contract imposes specific requirements on the underlying logic.                                   | `Omitted`: We kept the service contract independent of the underlying logic and implementation.  |
| **Contract-to-Technology Coupling** | Occurs when service contracts are tied to specific technologies, limiting their interoperability.                         | `Omitted` by using technology-neutral contracts, such as standard WSDL and XML schemas, to promote interoperability. We have used SOAP protocol which establishes communication over HTTP.   |
| **Contract-to-Implementation Coupling** | Happens when service contracts are tied to specific implementations, including data models and APIs.                       | `Omitted` by abstracting implementation details and focusing on service capabilities in the contracts. Each Entity Service also maintains a dedicated database.                  |
| **Contract-to-Functional Coupling** | This occurs when a service contract is tightly coupled to a specific functionality or process within the enterprise.         | Achieved by designing task services like `RequestAdoption` Service and `ApproveAdoption` Service are intentionally designed with functional coupling to specific business processes, ensuring they fulfill targeted roles effectively.|

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

In the Furryaide application, the services are composable. For instance, the `requestAdoption` service allows customers to browse pets, select a pet for adoption, and submit the necessary questionnaires. This service utilizes shared functionalities such as `validateToken` provided by `JWTAuth` to verify the identity of the customer,`checkPermission` provided by `Permissions` service to ensure they have the necessary permissions to access this service, `getAllPets` provided by the `Pet`, `getQuestion` from the  `Questionnaire` service.

On the other hand, the `approveAdoption` service enables pet relinquishers to review submitted questionnaires, approve adoption requests, and manage the adoption process. This service also leverages shared functionalities such as `validateToken` provided by `JWTAuth` to verify the identity of the pet relinquisher,`checkPermission` provided by `Permissions` service to ensure they have the necessary permissions to access this service. 


