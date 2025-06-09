# 🚀 Frontend Initialization Guide

This guide outlines how to initialize the frontend of your fullstack project using your choice of:

- ⚡ Vite (Recommended for speed and modern tooling)
- ⚙️ Create React App (CRA)
- 🌐 Next.js (For SSR and full-stack flexibility)
-  🛠️ Vanilla JavaScript, HTML, and CSS (For simpler projects)

---

## ⚡ Option 1: Initialize with Vite (Recommended)

### ✅ Features
- Super fast build times
- Native ES Modules
- Works great with TypeScript and React

### 🧱 Steps

```bash
npm create vite@latest frontend -- --template react-ts
cd frontend
npm install
npm run dev
```

- Visit: [`http://localhost:5173`](http://localhost:5173)
- Add environment variables in `.env`:

```bash
VITE_API_URL=http://localhost:8080/api
```

## ⚙️ Option 2: Initialize with Create React App (CRA)

### ✅ Features
- Official React scaffolding
- Strong ecosystem support
- Easy setup for beginners

### 🧱 Steps
```bash
npx create-react-app frontend --template typescript
cd frontend
npm start
```

- Visit: [`http://localhost:3000`](http://localhost:3000)
- Add environment variables in `.env`:

```bash
REACT_APP_API_URL=http://localhost:8080/api
```

## 🌐 Option 3: Initialize with Next.js

### ✅ Features
- Server-Side Rendering (SSR)
- API routes support (full-stack)
- Built-in routing

### 🧱 Steps
```bash
npx create-next-app@latest frontend -e with-typescript
cd frontend
npm run dev
```

- Visit: [`http://localhost:3000`](http://localhost:3000)
- Add environment variables in `.env.local`:

```bash
NEXT_PUBLIC_API_URL=http://localhost:8080/api
```

## 🛠️ Option 4: Initialize with Vanilla JavaScript, HTML, and CSS
✅ Features
- Lightweight and simple setup
- No build tools or frameworks required
- Ideal for small static websites or learning projects

### 🧱 Steps

1. Create Project Folder:
    ```bash
    cd frontend
    ```
2. Create Essential Files:
   - `index.html`
   - `style.css`
   - `app.js`
3. Basic HTML Setup ([index.html](../frontend/index.html)):
    ```html
    <!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Fullstack Web Application Frontend</title>
            <link rel="stylesheet" href="style.css">
        </head>
        <body>
            <h1>Hello, Vanilla JS!</h1>
            <script src="app.js"></script>
        </body>
    </html>
    ```
4. Basic Styling ([style.css](../frontend/style.css)):
    ```css
    body {
        font-family: Arial, sans-serif;
        background-color: #f5f5f5;
        text-align: center;
        margin: 0;
    }

    h1 {
        color: #333;
    }
    ```
5. JavaScript Functionality ([app.js](../frontend/app.js)):
    ```js
    document.addEventListener('DOMContentLoaded', () => {
        console.log('Vanilla JS App Initialized');
    });
    ```

6. Open Your Project:

    Open [`index.html`](../frontend/index.html) in any browser to see the project.

## 🔍 After Setup

### 📦 Recommended Packages
```bash
npm install axios react-router-dom @tanstack/react-query
```

### 🧪 Dev Tools
- **Linting**: ESLint + Prettier
- **Testing**: Jest + React Testing Library

```bash
npm install -D eslint prettier jest @testing-library/react
```

**_For Vanilla JS, you may still want some basic tooling for development_**:

- **Live Server**: For auto-refreshing your HTML/CSS/JS while working.
    - Install using `npm` or your editor’s extensions.

- **Axios**: For making API calls, similar to React.
    ```bash
    npm install axios
    ```

## 📎 Related Resources
- [Vite Documentation]()
- [Create React App Docs]()
- [Next.js Documentation]()
- [React Dev Docs]()