import { useNavigate } from "react-router-dom";
import AddTripForm from "../../form/AddTrip";
import { create } from "../../../../api/trips/fetchers";

const TripRegister = () => {
  const navigate = useNavigate();
  const handleSubmit = async (values, actions, id) => {
    try {
      await create({ ...values, flight: { id } });
      actions.resetForm();
      return navigate("/admin/dashboard/trips");
    } catch (error) {
      alert(error.message);
      return null;
    }
  };
  return (
    <>
      <AddTripForm onSubmit={handleSubmit} />
    </>
  );
};

export default TripRegister;
