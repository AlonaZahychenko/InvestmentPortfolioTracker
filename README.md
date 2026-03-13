# Investment Portfolio Tracker

Backend application for tracking an investment portfolio.

The system allows users to manage accounts, assets and transactions, and calculates the current portfolio state based on transaction history.

## Core Idea

Transactions are the single source of truth.
Portfolio state (cash balance, positions, portfolio value) is calculated dynamically from transactions.

## Tech Stack

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate
* PostgreSQL
* Docker
* Maven

## Domain Model

Main entities:

* User
* Account
* Asset
* Transaction

Relationships are unidirectional to avoid large collections and lazy-loading issues.

## Current Status

Project is under development.

Completed:

* Core domain entities
* Repository layer
* Database integration (PostgreSQL via Docker)

Next step:

* PortfolioService implementation
