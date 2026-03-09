# Domain Model

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

---

## Asset

Represents a tradable instrument.

Examples:

- stock
- ETF
- crypto

### Financial values

Financial values use `BigDecimal` instead of `double`
to avoid floating-point precision errors.

### Design decisions

- Transaction is the single source of truth
- Portfolio state is not stored
- All financial values use BigDecimal
- Entity relationships are unidirectional