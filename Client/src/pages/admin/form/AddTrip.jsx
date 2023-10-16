import { Field, Form, Formik } from "formik";

import { addTripInitialValue, validation } from "./utils";
import NavBar from "../../../components/navbar/NavBar";
import AppInput from "../../../components/input/AppInput";
import { useParams } from "react-router-dom";
// import useQuery from "../../../hooks/useQuery";
// import { login } from "../../../api/passengers/fetchers";
const AddTripForm = ({
  values = addTripInitialValue,
  onSubmit,
  buttonLabel,
}) => {
  const { tripId } = useParams();
  return (
    <div>
      <NavBar bg />
      <main className="bg-gray-200 grid p-16 h-[calc(100vh-50px)]">
        <Formik
          initialValues={values}
          enableReinitialize
          validationSchema={validation}
          onSubmit={(values, actions) => onSubmit(values, actions, tripId)}
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
                className="h-10 rounded-sm px-2 focus:outline-indigo-500"
                required
                type="time"
                name="depatureTime"
              />
              <AppInput
                label={"arrivalTime"}
                divClassName="flex flex-col  h-[100px] gap-2 "
                required
                type="time"
                className="h-10 rounded-sm px-2 focus:outline-indigo-500"
                name="arrivalTime"
              />
              <AppInput
                label={"pricePerSeat"}
                type="number"
                divClassName="flex flex-col  h-[100px] gap-2 "
                required
                className="h-10 rounded-sm px-2 focus:outline-indigo-500"
                name="pricePerSeat"
              />
              <label htmlFor="status" className="">
                <Field id="status" name="status" type="checkbox" />
                <span className="ml-[3px]"> Status</span>
              </label>
              <div className="col-span-full  flex justify-center">
                <input
                  type="submit"
                  value={buttonLabel}
                  className="bg-indigo-600 text-white px-12 rounded capitalize h-12 disabled:bg-indigo-400"
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
