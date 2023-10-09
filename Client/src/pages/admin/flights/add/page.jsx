import AddFlightForm from "../../form/AddFlight";

const AddFlightPage = () => {
  const handleSubmit = async (values, actions) => {
    console.log({ values });
    actions.resetForm();
    return null;
  };
  return (
    <>
      <AddFlightForm onSubmit={handleSubmit} />
    </>
  );
};

export default AddFlightPage;
