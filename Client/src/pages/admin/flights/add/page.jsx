import AddFlightForm from "../../form/AddFlight";
import { create } from "../../../../api/flights/fetchers";
const AddFlightPage = () => {
  const handleSubmit = async (values, actions) => {
    try {
      const response = await create(values);
      console.log({ values, response });
      actions.resetForm();
      return alert("flight created successfully");
    } catch (error) {
      alert(error.message);
    }
  };
  return (
    <>
      <AddFlightForm onSubmit={handleSubmit} />
    </>
  );
};

export default AddFlightPage;
