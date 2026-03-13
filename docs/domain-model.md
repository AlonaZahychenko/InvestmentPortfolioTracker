# Domain Model

## Overview

The system tracks an investment portfolio using transactions.

Core entities:

- User
- Account
- Asset
- Transaction

Portfolio state (cash, positions, portfolio value) is **not stored in the database** and is calculated dynamically.

---

# Design Decisions

## Transaction as Source of Truth

The system stores only **transactions** as persistent financial data.

Derived values such as:

- cash balance
- positions
- average price
- portfolio value

are calculated dynamically.

Reasons:

- avoid data inconsistencies
- avoid synchronization problems
- simplify persistence model

---

## Financial Values

All financial values use **BigDecimal** instead of `double` to avoid floating-point precision errors.

---

## Entity Relationships

Entity relationships are **unidirectional**.

Account → User
Transaction → Account
Transaction → Asset

Collections such as:
User → List<Account>
Account → List<Transaction>

are intentionally avoided to prevent:

- large collections in memory
- lazy loading issues
- JSON recursion problems

---

## Average Price Calculation

The system uses the **Weighted Average Cost** method.
average_price = total_cost / total_quantity

Where:
total_cost = Σ (BUY.quantity * BUY.price + BUY.fee)

Sell transactions **do not change average price**.

FIFO/LIFO accounting is **not implemented in the current version**.

Reasons:

- simpler implementation
- no need to track purchase lots
- sufficient for portfolio tracking

---

# Entities

## User

Represents a system user.
A user can have multiple accounts.

---

## Account

Represents a financial account.

Types:
- BANK
- BROKER
- WALLET

Each account belongs to a user.
Accounts define the **base currency for cash balance**.

---

## Asset

Represents a tradable instrument.

Examples:
- stock
- ETF
- crypto

Each asset has a currency.

---

## Transaction

Represents a financial event that changes the portfolio.
Transactions are the **single source of truth** for portfolio calculations.

---

# Transaction Types

Supported transaction types:

- BUY
- SELL
- DEPOSIT
- WITHDRAW
- DIVIDEND
- TAX
- TRANSFER
- FX (planned)

Transaction fees are stored as a **field in the transaction**, not as a separate transaction type.

---

# Transaction Field Requirements

| Type     | asset     | quantity | price    | amount   |
|----------|-----------|----------|----------|----------|
| BUY      | required  | required | required | null     |
| SELL     | required  | required | required | null     |
| DEPOSIT  | forbidden | null     | null     | required |
| WITHDRAW | forbidden | null     | null     | required |
| DIVIDEND | required  | null     | null     | required |
| TAX      | optional  | null     | null     | required |

---

# Currency Rules

Each account has a **base currency**.

Each asset also defines a currency.

Current system limitation:
asset currency must match account currency

Reasons:

- simplifies portfolio calculations
- avoids FX complexity

Currency conversion (FX) may be implemented in future versions.