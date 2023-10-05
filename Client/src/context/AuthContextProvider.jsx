import React, {
  useEffect,
  useState,
  createContext,
  useCallback,
  useContext,
} from "react";

const userTokenContext = createContext(null);
const AuthContext = ({ children }) => {
  const [token, setToken] = useState(localStorage.getItem("token"));
  useEffect(() => {
    console.log({ currentUserToken: token });
  }, [token]);
  const login = useCallback(userToken => {
    setToken(userToken);
    localStorage.setItem("token", userToken);
  }, []);
  const logout = useCallback(() => {
    setToken(null);
    localStorage.removeItem("token");
  }, []);
  return (
    <userTokenContext.Provider
      value={{
        login,
        logout,
        userAccessToken: token,
      }}
    >
      {children}
    </userTokenContext.Provider>
  );
};

export default AuthContext;

export const useAuth = () => useContext(userTokenContext);
