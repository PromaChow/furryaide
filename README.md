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
