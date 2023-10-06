import { Form, Formik } from "formik";
import Navbar from "../../../components/navbar/NavBar";
import AppInput from "../../../components/input/AppInput";
import { initialValues, validation } from "./utils";
import { useLoginPassangerMutation } from "../../../api/passengers/hook";
const PassengerLoginPage = () => {
  const { mutate: login } = useLoginPassangerMutation();
  const handleSubmit = async (values, actions) => {
    console.log({ values, actions });
    login(values);
    actions.resetForm();
    return null;
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
          {({ isValidating, isSubmitting }) => (
            <Form>
              <AppInput label={"username"} required name="username" />
              <AppInput
                label={"password"}
                required
                name="password"
                type="password"
              />
              <input
                type="submit"
                value="signin"
                className="bg-indigo-600 text-white px-8 rounded py-2 disabled:bg-indigo-400"
                disabled={isValidating || isSubmitting}
              />
            </Form>
          )}
        </Formik>
      </main>
    </div>
  );
};

export default PassengerLoginPage;
