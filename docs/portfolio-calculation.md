# Portfolio Calculation Rules

## Cash calculation

cash =

+ DEPOSIT

- BUY (quantity * price)

+ SELL (quantity * price)

- fee

---

## Transaction rules

DEPOSIT
amount != null
asset == null

BUY
asset != null
quantity != null
price != null

SELL
asset != null
quantity != null
price != null

---

## Notes