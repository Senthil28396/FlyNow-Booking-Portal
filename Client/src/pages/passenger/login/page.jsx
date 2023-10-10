import { Form, Formik } from "formik";
import Navbar from "../../../components/navbar/NavBar";
import AppInput from "../../../components/input/AppInput";
import { initialValues, validation } from "./utils";
import { login } from "../../../api/passengers/fetchers";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../../../context/AuthContextProvider";
const PassengerLoginPage = () => {
  const navigate = useNavigate();
  const { login: loginUser } = useAuth();
  const handleSubmit = async (values, actions) => {
    try {
      const token = await login(values);
      loginUser(token);
      actions.resetForm();
      navigate("/");
    } catch (error) {
      alert(error);
    }
  };
  return (
    <div>
      <Navbar bg />
      <main className="bg-gray-200 grid place-content-center h-[calc(100vh-50px)]">
        <Formik
          initialValues={initialValues}
          validationSchema={validation}
          onSubmit={handleSubmit}
        >
          {({ isSubmitting }) => (
            <Form className="rounded-md shadow-md shadow-gray-200 flex flex-col gap-2 py-10 px-5  h-[70vh] w-[40vw]">
              <AppInput
                label={"email"}
                divClassName="flex flex-col  h-[100px] gap-2 "
                required
                className="h-10 rounded-sm px-2 focus:outline-indigo-500"
                name="email"
              />
              <AppInput
                label={"password"}
                required
                className="h-10 rounded-sm px-2 focus:outline-indigo-500"
                divClassName="flex flex-col  h-[100px] gap-2 "
                name="password"
                type="password"
              />
              <input
                type="submit"
                value="signin"
                className="bg-indigo-600  capitalize self-center  text-white px-10 rounded py-2 disabled:bg-indigo-400"
                disabled={isSubmitting}
              />
            </Form>
          )}
        </Formik>
      </main>
    </div>
  );
};

export default PassengerLoginPage;
