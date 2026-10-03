# YUMI Bakery & Cafe — Complete Digital Ordering System

A responsive customer-facing digital menu and ordering foundation for YUMI Bakery & Cafe.

## Stack
- Frontend: React + Vite + Lucide icons
- Backend: Java 21 + Spring Boot 4 + Spring Data JPA
- Database: PostgreSQL 17
- Reverse proxy: Nginx
- Deployment: Docker Compose

## Features
### Customer
- Warm, minimal YUMI visual identity
- Responsive mobile/tablet/desktop UI
- Category chips + search
- Pizza regular/medium pricing
- Persistent cart in localStorage
- Quantity management
- Pickup / delivery
- Delivery fee: ₹30 below ₹299; free at/above ₹299
- Customer details + address validation
- Payment-method selection (UPI/Card/Cash)
- Order submission to Spring Boot API
- Order confirmation with order number

### Backend
- Menu API
- Server-side price calculation (never trust client totals)
- PostgreSQL persistence for menu and orders
- Order status model
- Admin order listing/status endpoint protected by `X-Admin-Key`
- Health endpoint via Spring Actuator
- Seeded YUMI menu from the supplied menu image

## Run locally
### Frontend only
```bash
npm install
npm run dev
```
Open http://localhost:5173

The UI works in demo mode if the backend is unavailable.

### Full stack
```bash
cp .env.example .env
# edit .env and replace secrets

docker compose up --build
```
Open http://localhost:3000

Backend health: http://localhost:3000/api/actuator/health is not exposed through the current nginx path; use the API directly on port 8080 if running it separately.

## API
- `GET /api/menu`
- `POST /api/orders`
- `GET /api/menu/all` (admin use; protect behind auth before exposing publicly)
- `GET /api/admin/orders` with `X-Admin-Key`
- `PATCH /api/admin/orders/{orderNumber}/status?value=PREPARING` with `X-Admin-Key`
- `POST /api/payments/create` — demo payment-provider adapter endpoint

## Payment productionization
The current payment UI intentionally does **not** pretend a payment succeeded. To go live, integrate Razorpay/Cashfree/PhonePe on the backend:
1. Create payment order server-side using the verified order total.
2. Open the gateway checkout on the client.
3. Receive gateway callback/webhook on the backend.
4. Verify the gateway signature server-side.
5. Mark the order `PAID` only after successful verification.
6. Make webhook handling idempotent.

Never put gateway secret keys in React/Vite environment variables.

## Production checklist
- Change `ADMIN_KEY` and DB password.
- Replace the demo payment adapter with a real gateway.
- Add authentication/authorization for the admin API (prefer Spring Security + JWT/session).
- Add rate limiting and request logging.
- Add HTTPS at the hosting/load-balancer layer.
- Add order notification integration (WhatsApp/SMS/email).
- Add backups and database migration tooling (Flyway recommended for production).
- Move menu seed data into migrations.
- Add automated unit/integration tests and CI/CD.
