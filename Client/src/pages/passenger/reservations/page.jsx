import AppInput from "../../../components/input/AppInput";
import NavBar from "../../../components/navbar/NavBar";
import RadioGroup from "../../../components/radio/Radio";
import { Form, Formik } from "formik";
import { initialValues, validation } from "./utils";
import { useNavigate, useParams } from "react-router-dom";
import { create } from "../../../api/bookings/fetchers";
const ReversationDetailsPage = () => {
  const { tripId } = useParams();
  const navigate = useNavigate();

  const handleSubmit = async (values, actions) => {
    const body = {
      ...values,
      numberOfPassangers: Number(values?.numberOfPassangers),
      status: true,
      paymentStatus: "paid",
      trip: {
        id: Number(tripId),
      },
    };
    try {
      const response = await create(body);
      console.log(response);
      actions.resetForm();
      return navigate("/passagers/bookings");
    } catch (error) {
      alert(error.message);
    }
  };
  return (
    <main className="bg-flight bg-black/40 bg-blend-multiply bg-cover">
      <NavBar />
      <section className="h-[calc(100vh-50px)] grid place-content-center">
        <Formik
          initialValues={initialValues}
          validationSchema={validation}
          onSubmit={handleSubmit}
        >
          {({ isSubmitting, isValidating, dirty }) => (
            <Form className="grid gap-6  border-white w-[35vw] px-10 py-4 rounded text-white ">
              <AppInput
                name="numberOfPassangers"
                required
                label="Number of Passengers"
                divClassName="flex flex-col  h-[100px] gap-2 "
                className="h-10 rounded-sm px-2 focus:outline-indigo-500 text-black"
              />
              <RadioGroup
                label="choose Payment type"
                values={["cash", "upi"]}
                name="paymentMode"
                groupClassName="flex gap-4 mt-2"
              />
              <AppInput
                name="transactionId"
                label="transaction id"
                divClassName="flex flex-col  h-[100px] gap-2 "
                className="h-10 rounded-sm px-2 focus:outline-indigo-500 text-black"
              />
              <input
                type="submit"
                value="Book"
                className="bg-indigo-600 text-white px-12 rounded capitalize mx-auto h-12 disabled:bg-indigo-400 "
                disabled={isSubmitting || isValidating || !dirty}
              />
            </Form>
          )}
        </Formik>
      </section>
    </main>
  );
};

export default ReversationDetailsPage;
