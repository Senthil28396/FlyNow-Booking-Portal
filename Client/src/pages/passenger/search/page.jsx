import { Field, Form, Formik } from "formik";
import Navbar from "../../../components/navbar/NavBar";
import { validation, initialValue } from "./utils";
import AppInput from "../../../components/input/AppInput";
import { getByDetails, getAll } from "../../../api/trips/fetchers";
import { useEffect, useState } from "react";
import Table from "../../../components/table/Table";
import _ from "lodash";
import { Link } from "react-router-dom";
const SearchFlightsPage = () => {
  const [flights, setFlights] = useState([]);
  useEffect(() => {
    getAll().then((data) => {
      const updatedData = data?.map((trip) =>
        _.omit(trip, ["createAt", "status", "duration"])
      );
      setFlights(updatedData);
    });
  }, []);
  const handleSubmit = async (values, action) => {
    try {
      const data = await getByDetails(values);
      const updatedData = data?.map((trip) =>
        _.omit(trip, ["createAt", "status", "duration"])
      );
      setFlights(updatedData);
      action.resetForm();
    } catch (error) {
      return alert(error.message);
    }
  };
  console.log({ flights });
  return (
    <main className="bg-gray-200 h-screen">
      <Navbar bg />
      <section className="my-2">
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
      {flights.length > 0 ? (
        <Table
          data={flights}
          hasAction
          render={(row) => (
            <span className="flex justify-center">
              <Link
                to={`/flights/reservations/${row?.id}`}
                className="bg-indigo-600 p-1 px-5 rounded text-white"
              >
                Book
              </Link>
            </span>
          )}
        />
      ) : (
        <h1>list of flight will be here..!</h1>
      )}
    </main>
  );
};

export default SearchFlightsPage;
