import './App.css';
import { AppProvider } from './context/AppContext';
import AuthProvider from "./context/AuthProvider";
import Routes from "./routes/index";

function App() {
  return (
    <AppProvider>
      <AuthProvider>
        <Routes />
      </AuthProvider>
    </AppProvider>
  );
}

export default App;
