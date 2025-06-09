# 📘 Frontend Documentation

This document provides technical and code documentation for the frontend component of the project, built using **React**. It includes architecture details, setup instructions, coding practices, and troubleshooting guidance.

---

## 🧱 1. Technical Documentation

### 🧭 Architecture Overview

The frontend is a **single-page application (SPA)** built with **React** and optionally configured with **TypeScript**. It interacts with the backend via RESTful APIs and is deployed on the web using AWS services (S3/CloudFront).

#### Key Components:
- **Pages** – Top-level route components.
- **Components** – Reusable UI building blocks.
- **Services** – API interaction logic (using `axios`).
- **Hooks** – Custom React hooks for shared logic.
- **State Management** – React Context API or external libraries (e.g., Zustand or Redux).

```txt
[ Pages ] → [ Components ] → [ Hooks/State ]
     ↓
[ Services (API) ] → [ Backend (Spring Boot) ]
```

### 🗂 Folder Structure
```bash
frontend/
├── public/
├── src/
│   ├── assets/            # Static files
│   ├── components/        # UI components
│   ├── hooks/             # Custom hooks
│   ├── pages/             # Route pages
│   ├── services/          # API calls
│   ├── App.tsx            # Root component
│   └── main.tsx           # Entry point
├── .env                   # Environment variables
├── package.json
├── tsconfig.json
└── vite.config.ts         # (or CRA config)
```

### 🌐 Routing & Navigation

React Router is used for client-side navigation.

```tsx
import { BrowserRouter, Routes, Route } from 'react-router-dom';

<BrowserRouter>
  <Routes>
    <Route path="/" element={<Home />} />
    <Route path="/login" element={<Login />} />
    <Route path="/dashboard" element={<Dashboard />} />
  </Routes>
</BrowserRouter>
```

## 🧾 2. Code Documentation

### 🧠 Best Practices
- Use functional components and React Hooks.
- Keep components small and reusable.
- Document all custom hooks and API service methods.
- Use TypeScript for type safety.
- Use meaningful file and variable names.

### 📝 Inline Comments Example
```tsx
// Fetch user data after component mounts
useEffect(() => {
  fetchUserData();
}, []);
```

### 📄 Component JSDoc Example
```tsx
/**
 * Renders the login form for users.
 */
export const LoginForm = () => { ... }
```

## ⚙️ Setup Guide

### 🧰 Prerequisites
- Node.js 18+
- `npm` or `yarn` or `pnpm`
- Code Editor (VSCode recommended)

### 🔧 Local Development
```bash
cd frontend
npm install
npm run dev
```

Visit [`http://localhost:5173`](http://localhost:5173) (Vite) or [`http://localhost:3000`](http://localhost:3000) (CRA) in your browser.

### 🌍 Environment Variables

Create a `.env` file in [`frontend/`](../frontend/) with:
```bash
VITE_API_URL=http://localhost:8080/api
```

For Create React App:
```bash
REACT_APP_API_URL=http://localhost:8080/api
```

## 🔁 API Integration

Use axios or fetch to connect to backend APIs.

```ts
import axios from 'axios';

const API = axios.create({
  baseURL: import.meta.env.VITE_API_URL,
});

export const getUsers = () => API.get('/users');
```

## 🔬 Testing & Linting
- **Testing**: Jest + React Testing Library
- **Linting**: ESLint, Prettier

```bash
npm test
npm run lint
```

## 🚑 Troubleshooting

| Problem | Solution |
| ------- | -------- |
API not working     | Check `.env` and CORS config on backend
Styling not applied | Verify Tailwind/SCSS setup
React build fails   | Check TypeScript errors or missing imports

## 🔄 Change Log

Track changes in [`frontend/CHANGELOG.md`](../frontend/CHANGELOG.md). Example:

```markdown
## [1.0.0] - 2025-04-20
### Added
- Home, Login, and Dashboard pages
- Axios service layer

### Fixed
- Routing issue on refresh
```

## 📎 Related Links
- [React Docs]()
- [React Router]()
- [Axios Docs]()
- [Jest Testing]()
- [Vite Docs]()
