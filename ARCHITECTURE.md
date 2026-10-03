# YUMI architecture

```text
Browser (mobile / desktop)
        |
        v
     Nginx
   /        \
  /          \
static UI    /api
               |
               v
        Spring Boot API
        |            |
        v            v
    PostgreSQL   Payment adapter

Admin -> /admin.html -> X-Admin-Key -> Admin API
```

## Important trust boundary
The browser sends item IDs, quantities and sizes only. The backend loads current menu prices from PostgreSQL and recalculates subtotal, delivery fee and total. This prevents a customer from changing a price in browser devtools and paying a lower amount.

## Production payment boundary
The browser must never hold Razorpay/Cashfree secret credentials. The backend creates the payment order, receives the gateway callback/webhook, verifies the signature, and only then changes `paymentStatus` to `PAID`.
