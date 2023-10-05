import AuthContextProvider from "../context/AuthContextProvider";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import { ReactQueryDevtools } from "@tanstack/react-query-devtools";
const GlobalContextWrapper = ({ children }) => {
  const client = new QueryClient();
  return (
    <>
      <AuthContextProvider>
        <QueryClientProvider client={client}>
          {children}
          <ReactQueryDevtools position="bottom-left" />
        </QueryClientProvider>
      </AuthContextProvider>
    </>
  );
};

export default GlobalContextWrapper;
