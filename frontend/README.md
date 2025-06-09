# 🚀 Frontend (React)

This folder contains the source code for the React frontend.

## ✅ Practical Tasks for Frontend

### 1. Create a Simple Web Application
- Use [Vite](https://vitejs.dev/) or [Create React App](https://create-react-app.dev/) to scaffold.
- Use TypeScript for type safety.
- Include routing with React Router.
- Basic layout with responsive design (Tailwind or Material UI).

### 2. Implement Automated Testing
- Use `Jest` and `React Testing Library`.
- Add unit tests for components.
- Add integration tests for flows (e.g. login, form submit).

```bash
npm install --save-dev jest @testing-library/react
npm test
```

### 3. Linting and Code Quality
- Setup ESLint + Prettier
- Add Git hooks with Husky

```bash
npm install --save-dev eslint prettier husky lint-staged
```

### 4. CI Integration
- Configure GitHub Actions to run tests on push and PRs.