import { Field, Form, Formik } from "formik";

import { addTripInitialValue, validation } from "./utils";
import NavBar from "../../../components/navbar/NavBar";
import AppInput from "../../../components/input/AppInput";
// import useQuery from "../../../hooks/useQuery";
// import { login } from "../../../api/passengers/fetchers";
const AddTripForm = ({ values = addTripInitialValue, onSubmit }) => {
  // const { data, error } = useQuery(login);
  console.log({ values });
  return (
    <div>
      <NavBar bg />
      <main className="bg-gray-200 grid p-16 h-[calc(100vh-50px)]">
        <Formik
          initialValues={values}
          validationSchema={validation}
          onSubmit={onSubmit}
        >
          {({ isSubmitting, dirty }) => (
            <Form className="grid grid-cols-3 gap-x-8">
              <AppInput
                label={"departure airport"}
                divClassName="flex flex-col  h-[100px] gap-2 "
                required
                className="h-10 rounded-sm px-2 focus:outline-indigo-500"
                name="departure"
              />
              <AppInput
                label={"arrival airport"}
                divClassName="flex flex-col  h-[100px] gap-2 "
                required
                className="h-10 rounded-sm px-2 focus:outline-indigo-500"
                name="arrival"
              />
              <AppInput
                label={"depatureDate"}
                divClassName="flex flex-col  h-[100px] gap-2 "
                required
                type="date"
                className="h-10 rounded-sm px-2 focus:outline-indigo-500"
                name="depatureDate"
              />
              <AppInput
                label={"arrivalDate"}
                divClassName="flex flex-col  h-[100px] gap-2 "
                required
                type="date"
                className="h-10 rounded-sm px-2 focus:outline-indigo-500"
                name="arrivalDate"
              />
              <AppInput
                label={"depatureTime"}
                divClassName="flex flex-col  h-[100px] gap-2 "
                required
                type="time"
                className="h-10 rounded-sm px-2 focus:outline-indigo-500"
                name="depatureTime"
              />
              <AppInput
                label={"arrivalTime"}
                divClassName="flex flex-col  h-[100px] gap-2 "
                required
                type="time"
                className="h-10 rounded-sm px-2 focus:outline-indigo-500"
                name="arrivalTime"
              />{" "}
              <AppInput
                label={"duration"}
                type="number"
                divClassName="flex flex-col  h-[100px] gap-2 "
                required
                className="h-10 rounded-sm px-2 focus:outline-indigo-500"
                name="duration"
              />
              <AppInput
                label={"availableSeats"}
                type="number"
                divClassName="flex flex-col  h-[100px] gap-2 "
                required
                className="h-10 rounded-sm px-2 focus:outline-indigo-500"
                name="availableSeats"
              />
              <AppInput
                label={"pricePerSeat"}
                type="number"
                divClassName="flex flex-col  h-[100px] gap-2 "
                required
                className="h-10 rounded-sm px-2 focus:outline-indigo-500"
                name="pricePerSeat"
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

export default AddTripForm;
