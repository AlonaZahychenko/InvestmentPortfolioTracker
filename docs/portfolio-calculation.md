# Portfolio Calculation Rules

Portfolio state is **derived from transactions** and is not persisted in the database.

---

# Cash Calculation

Cash balance is calculated from all account transactions.

cash = DEPOSIT - BUY (quantity * price) + SELL (quantity * price) - fee

Explanation:

- deposits increase cash
- buy operations decrease cash
- sell operations increase cash
- transaction fees reduce cash

---

# Position Quantity

Position quantity for each asset is calculated as:
position quantity = sum(BUY.quantity) - sum(SELL.quantity)

---

# Average Price

The system uses **Weighted Average Cost**.

average_price = total_cost / total_quantity

Where:

total_cost = Σ (BUY.quantity * BUY.price + BUY.fee)

Sell transactions **do not change the average price**.

---

# Portfolio Value

Portfolio value is calculated as:

portfolio_value = cash + Σ(position_quantity * current_market_price)

Market prices are expected to be provided by an external market data service.

---

# Notes

Portfolio data such as:

- positions
- portfolio value
- average price

are **calculated dynamically** and are not stored in the database.

This approach ensures that:

- the transaction history remains the single source of truth
- recalculations are always consistent
- historical imports are supported