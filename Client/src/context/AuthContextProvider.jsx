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
    console.log({ currentUserToken: `Bearear - ${token}` });
  }, [token]);
  const login = useCallback(({ token: userToken, isAdmin, id }) => {
    localStorage.setItem("token", userToken);
    localStorage.setItem("currentUserId", id);
    localStorage.setItem("role", isAdmin ? "admin" : "user");
    setToken(userToken);
  }, []);
  const logout = useCallback(() => {
    setToken(null);
    localStorage.removeItem("currentUserId");
    localStorage.removeItem("token");
    localStorage.removeItem("role");
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
