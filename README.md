# Movie Ticket Booking - Frontend Integration Guide

## Project Overview

This is a Movie Ticket Booking System built using:

### Backend Stack

* Java
* Spring Boot
* Spring Security
* MySQL
* JPA / Hibernate

### Frontend Stack (Expected)

* React
* TypeScript
* Vite
* Tailwind CSS
* Axios
* React Router DOM

---

# Complete Business Flow

The application follows this exact sequence:

```text
Location
   ↓
Theater
   ↓
Seats (Auto Generated)
   ↓
Movie
   ↓
Show
   ↓
ShowSeats (Copied From Seats)
   ↓
Seat Booking
   ↓
Payment
```

---

# Backend Entity Flow

## 1. Location

Admin creates locations first.

Example:

* Pune
* Mumbai
* Amravati

A theater cannot be created without a valid location.

---

## 2. Theater

Admin creates theaters under a specific location.

Example:

* PVR
* INOX

### Important

While creating a theater:

* locationId is mandatory
* theater seats are automatically generated in backend

### Seat Auto Allocation

Backend automatically creates seats when theater is added.

Example:

```text
Rows: 5
Seats Per Row: 10
```

Generated seats:

```text
A1 A2 A3 ...
B1 B2 B3 ...
```

---

## 3. Movie

Admin creates movie and assigns it to a theater.

A movie cannot exist independently without theater mapping.

Example:

```text
Avengers → PVR
Batman → INOX
```

---

## 4. Show

Admin creates shows for movies.

Example:

```text
Movie: Avengers
Time: 10:00 AM
Date: 20-05-2026
```

### Important

When show is created:

* backend automatically copies theater seats
* creates ShowSeats

---

## 5. ShowSeats

ShowSeats are generated from theater seats.

### Why?

Because every show has different booking status.

Example:

```text
Show 1:
A1 = Booked

Show 2:
A1 = Available
```

---

# Seat Pricing Logic

Pricing is seat-wise.

Example:

```text
SILVER → ₹150
GOLD → ₹250
PLATINUM → ₹400
RECLINER → ₹700
```

### Dynamic Pricing

Show timing may affect pricing.

Example:

```text
Morning Show → Normal Price
Evening Show → +₹50
Night Show → +₹100
```

Final price is generated in backend while creating ShowSeats.

---

# User Flow

## Step 1 - Select Location

User selects location.

Frontend should fetch:

```text
GET /location/getAllLocations
```

---

## Step 2 - View Theaters

Frontend fetches theaters according to selected location.

Example:

```text
GET /theater/getTheaterByLocation/{locationId}
```

---

## Step 3 - View Movies

Frontend fetches movies available in selected theater.

---

## Step 4 - View Shows

Frontend fetches all shows of selected movie.

---

## Step 5 - Seat Selection

Frontend fetches ShowSeats.

### Seat States

* AVAILABLE
* BOOKED
* SELECTED

### Rules

* Maximum 6 seats selectable
* Real-time total calculation
* Seat-wise pricing

---

## Step 6 - Payment

Payment process starts after seat validation.

### Important Backend Rule

If seat already booked:

```text
Throw Exception
```

Otherwise:

```text
Proceed to payment
```

---

# Frontend Requirements

## Pages Required

### User Side

```text
Location Selection Page
Theater Page
Movie Page
Show Page
Seat Booking Page
Payment Page
Booking Success Page
Booking History Page
```

---

### Admin Side

```text
Dashboard
Add Location
Add Theater
Add Movie
Add Show
```

---

# UI Requirements

### Theme

* Dark Premium UI
* Responsive
* Modern Animations
* Glassmorphism Cards

### Seat Colors

```text
Available → Green
Booked → Red
Selected → Yellow
```

---

# Frontend Folder Structure

```text
src
 ├── api
 ├── assets
 ├── components
 ├── pages
 │    ├── admin
 │    └── user
 ├── services
 ├── types
 ├── utils
 ├── App.tsx
 └── main.tsx
```

---

# API Integration

Use Axios.

Example:

```ts
import axios from 'axios'

const api = axios.create({
  baseURL: 'http://localhost:8088'
})
```

---

# Important Frontend Notes

## Use localStorage for temporary flow data

Example:

```text
locationId
theaterId
movieId
showId
```

---

# Expected Frontend Flow

```text
Location
↓
Theater
↓
Movies
↓
Shows
↓
Seat Selection
↓
Payment
↓
Success
```

---

# Important Development Notes

* Backend runs on port 8088
* Spring Security may be disabled during development
* CORS should allow frontend origin
* APIs are ID based
* Frontend must be fully dynamic
* No hardcoded data in final implementation

---

# Final Goal

Create a production-level movie ticket booking frontend that fully integrates with the backend business flow and database relationships.
