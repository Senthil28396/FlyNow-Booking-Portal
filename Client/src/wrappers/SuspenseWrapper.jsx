import { Suspense } from "react";

const SuspenseWrapper = ({ children }) => {
  return <Suspense fallback={<h1>Loading...!</h1>}>{children}</Suspense>;
};

export default SuspenseWrapper;
