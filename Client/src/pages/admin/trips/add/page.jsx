import AddTripForm from "../../form/AddTrip";

const TripRegister = () => {
  const handleSubmit = async (values, actions) => {
    console.log({ values });
    actions.resetForm();
    return null;
  };
  return (
    <>
      <AddTripForm onSubmit={handleSubmit} />
    </>
  );
};

export default TripRegister;
