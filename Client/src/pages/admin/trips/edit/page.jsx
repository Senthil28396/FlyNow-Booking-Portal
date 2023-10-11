import { useEffect, useState } from "react";
import AddTripForm from "../../form/AddTrip";
import { addTripInitialValue } from "../../form/utils";
import { getOne, update } from "../../../../api/trips/fetchers";
import { useNavigate, useParams } from "react-router-dom";
import _ from "lodash";
const TripEditPage = () => {
  const { tripId: id } = useParams();
  const navigate = useNavigate();
  const [trip, setTrip] = useState(addTripInitialValue);
  useEffect(() => {
    getOne(Number(id)).then((response) => setTrip({ ...response }));
  }, [id]);
  const handleEdit = async (values) => {
    try {
      const updatedValues = _.omit(values, ["createdAt", "flight"]);
      const response = await update(updatedValues);
      alert(response);
      return navigate("/admin/dashboard/trips");
    } catch (error) {
      alert(error.message);
    }
  };
  return (
    <main>
      <AddTripForm
        values={trip}
        onSubmit={handleEdit}
        buttonLabel={"Update Trip"}
      />
    </main>
  );
};

export default TripEditPage;
