import { lazy } from "react";
import { Route, BrowserRouter as Router, Routes } from "react-router-dom";
import SuspenseWrapper from "../../wrappers/SuspenseWrapper";
const HomePage = lazy(() => import("../../pages/home/page"));

const AppRoutes = () => {
  return (
    <Router>
      <Routes>
        <Route
          path="/"
          element={
            <SuspenseWrapper>
              <HomePage />
            </SuspenseWrapper>
          }
        />
      </Routes>
    </Router>
  );
};

export default AppRoutes;
