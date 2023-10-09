import AuthContextProvider from "../context/AuthContextProvider";
const GlobalContextWrapper = ({ children }) => {
  return (
    <>
      <AuthContextProvider>{children}</AuthContextProvider>
    </>
  );
};

export default GlobalContextWrapper;
