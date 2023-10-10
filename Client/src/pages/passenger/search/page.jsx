import { Field, Form, Formik } from "formik";
import Navbar from "../../../components/navbar/NavBar";
import { validation, initialValue } from "./utils";
import AppInput from "../../../components/input/AppInput";
import { getByDetails } from "../../../api/trips/fetchers";
import { useState } from "react";
const SearchFlightsPage = () => {
  const [flighs, setFlights] = useState([]);
  const handleSubmit = async (values, action) => {
    try {
      const data = await getByDetails(values);
      console.log({ data });
      action.resetForm();
    } catch (error) {
      return alert(error.message);
    }
  };
  return (
    <main>
      <Navbar bg />
      <section>
        <Formik
          onSubmit={handleSubmit}
          validationSchema={validation}
          initialValues={initialValue}
        >
          {({ isSubmitting }) => (
            <Form className="grid grid-cols-4 bg-gray-200 gap-10 px-5 py-5 items-center">
              <AppInput
                label={"depature"}
                name="depature"
                required
                divClassName="flex flex-col  h-[100px] gap-2 "
                className="h-10 rounded-sm px-2 focus:outline-indigo-500"
              />
              <AppInput
                label={"arrival"}
                name="arrival"
                required
                divClassName="flex flex-col  h-[100px] gap-2 "
                className="h-10 rounded-sm px-2 focus:outline-indigo-500"
              />
              <AppInput
                label={"arrivalDate"}
                name="arrivalDate"
                type="date"
                required
                divClassName="flex flex-col  h-[100px] gap-2 "
                className="h-10 rounded-sm px-2 focus:outline-indigo-500"
              />
              <Field
                type="submit"
                value="Submit"
                className="bg-indigo-600  capitalize  w-28 text-white  rounded py-2 disabled:bg-indigo-400"
                disabled={isSubmitting}
              />
            </Form>
          )}
        </Formik>
      </section>
    </main>
  );
};

export default SearchFlightsPage;
