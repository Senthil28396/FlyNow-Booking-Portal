import AddFlightForm from "../../form/AddFlight";
import { create } from "../../../../api/flights/fetchers";
import { useNavigate } from "react-router-dom";
const AddFlightPage = () => {
  const navigate = useNavigate();
  const handleSubmit = async (values, actions) => {
    try {
      const response = await create(values);
      console.log({ values, response });
      actions.resetForm();
      alert("flight created successfully");
      return navigate("/admin/dashboard");
    } catch (error) {
      alert(error.message);
    }
  };
  return (
    <>
      <AddFlightForm onSubmit={handleSubmit} buttonLabel="Add Flight" />
    </>
  );
};

export default AddFlightPage;
