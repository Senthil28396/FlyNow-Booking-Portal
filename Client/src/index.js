import ReactDOM from "react-dom/client";
import reportWebVitals from "./reportWebVitals";
import AppRoutes from "./libs/router/AppRoutes";
import "./index.css";
import GlobalContextWrapper from "./wrappers/GlobalContextWrapper";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <GlobalContextWrapper>
    <AppRoutes />
  </GlobalContextWrapper>
);

reportWebVitals();
