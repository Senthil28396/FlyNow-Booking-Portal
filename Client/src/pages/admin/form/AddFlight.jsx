import { Field, Form, Formik } from "formik";
import { addFlightInitialValue, addFlightValidation } from "./utils";
import NavBar from "../../../components/navbar/NavBar";
import AppInput from "../../../components/input/AppInput";
const AddFlightForm = ({ values = addFlightInitialValue, onSubmit }) => {
  return (
    <div>
      <NavBar bg />
      <main className="bg-gray-200 grid p-16 h-[calc(100vh-50px)]">
        <Formik
          initialValues={values}
          validationSchema={addFlightValidation}
          onSubmit={onSubmit}
        >
          {({ isSubmitting, dirty }) => (
            <Form className="grid w-[340px] mx-auto gap-x-8">
              <AppInput
                label={"Flight Name"}
                divClassName="flex flex-col  h-[100px] gap-2 "
                required
                className="h-10 rounded-sm px-2 focus:outline-indigo-500"
                name="flightName"
              />
              <AppInput
                label={"Flight Number"}
                divClassName="flex flex-col  h-[100px] gap-2 "
                required
                className="h-10 rounded-sm px-2 focus:outline-indigo-500"
                name="flightNumber"
              />

              <AppInput
                label={"totalSeats"}
                type="number"
                divClassName="flex flex-col  h-[100px] gap-2 "
                required
                className="h-10 rounded-sm px-2 focus:outline-indigo-500"
                name="totalSeats"
              />
              <label htmlFor="status">
                <Field id="status" name="status" type="checkbox" />
                <span className="ml-[3px]"> Status</span>
              </label>
              <div className="col-span-full  flex justify-center">
                <input
                  type="submit"
                  value="signup"
                  className="bg-indigo-600 text-white px-10 rounded capitalize  disabled:bg-indigo-400"
                  disabled={isSubmitting || !dirty}
                />
              </div>
            </Form>
          )}
        </Formik>
      </main>
    </div>
  );
};

export default AddFlightForm;
