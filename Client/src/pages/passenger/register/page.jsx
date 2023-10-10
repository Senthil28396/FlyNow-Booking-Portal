import { Form, Formik } from "formik";
import Navbar from "../../../components/navbar/NavBar";
import AppInput from "../../../components/input/AppInput";
import { initialValues, validation } from "./utils";
import RadioGroup from "../../../components/radio/Radio";
import { create } from "../../../api/passengers/fetchers";
import { useNavigate } from "react-router-dom";
const PassengerRegisterPage = () => {
  const navigator = useNavigate();

  const handleSubmit = async (values, actions) => {
    console.log("working");
    try {
      const response = await create(values);
      actions.resetForm();
      alert(response);
      return navigator("/passagers/login");
    } catch (err) {
      alert(err.message);
      return null;
    }
  };
  return (
    <div>
      <Navbar bg />
      <main className="bg-gray-200 grid p-16 h-[calc(100vh-50px)]">
        <Formik
          initialValues={initialValues}
          validationSchema={validation}
          onSubmit={handleSubmit}
        >
          {({ isSubmitting }) => (
            <Form className="grid grid-cols-3 gap-x-8">
              <AppInput
                label={"firstName"}
                divClassName="flex flex-col  h-[100px] gap-2 "
                required
                className="h-10 rounded-sm px-2 focus:outline-indigo-500"
                name="firstName"
              />
              <AppInput
                label={"lastName"}
                divClassName="flex flex-col  h-[100px] gap-2 "
                required
                className="h-10 rounded-sm px-2 focus:outline-indigo-500"
                name="lastName"
              />
              <AppInput
                label={"email"}
                type="email"
                divClassName="flex flex-col  h-[100px] gap-2 "
                required
                className="h-10 rounded-sm px-2 focus:outline-indigo-500"
                name="email"
              />
              <AppInput
                label={"PhoneNumber"}
                divClassName="flex flex-col  h-[100px] gap-2 "
                required
                className="h-10 rounded-sm px-2 focus:outline-indigo-500"
                name="phoneNumber"
              />
              <AppInput
                label={"password"}
                required
                className="h-10 rounded-sm px-2 focus:outline-indigo-500"
                divClassName="flex flex-col  h-[100px] gap-2 "
                name="password"
                type="password"
              />
              <AppInput
                label={"age"}
                type="number"
                divClassName="flex flex-col  h-[100px] gap-2 "
                required
                className="h-10 rounded-sm px-2 focus:outline-indigo-500"
                name="age"
              />
              <AppInput
                label={"address"}
                required
                className="h-10 rounded-sm px-2 focus:outline-indigo-500"
                divClassName="flex flex-col  h-[100px] gap-2 "
                name="address"
              />
              <AppInput
                label={"passportNumber"}
                divClassName="flex flex-col  h-[100px] gap-2 "
                required
                className="h-10 rounded-sm px-2 focus:outline-indigo-500"
                name="passportNumber"
              />
              <AppInput
                label={"nationality"}
                required
                className="h-10 rounded-sm px-2 focus:outline-indigo-500"
                divClassName="flex flex-col  h-[100px] gap-2"
                name="nationality"
              />
              <RadioGroup
                label="Choose gender"
                name="gender"
                values={["male", "female", "others"]}
                divClassName="col-span-full"
                groupClassName="flex gap-4 mt-2"
              />
              <div className="col-span-full  flex justify-center">
                <input
                  type="submit"
                  value="signup"
                  className="bg-indigo-600 text-white px-14 rounded capitalize h-12 disabled:bg-indigo-400"
                  disabled={isSubmitting}
                />
              </div>
            </Form>
          )}
        </Formik>
      </main>
    </div>
  );
};

export default PassengerRegisterPage;
