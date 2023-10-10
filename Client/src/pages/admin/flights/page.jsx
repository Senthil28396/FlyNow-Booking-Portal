import { useEffect, useState } from "react";
import { getAll } from "../../../api/flights/fetchers";
import DashboardHeader from "../../../components/dashboardHeader/Dashboard";
const AdminDashboardFlights = () => {
  const [flights, setFlights] = useState([]);
  useEffect(() => {
    getAll().then((response) => {
      console.log({ response });
      setFlights(() => [...response]);
    });
  }, []);
  return (
    <div>
      <DashboardHeader
        sectionClass="flex justify-between p-4"
        buttonLabel="add flight"
        to="/admin/flights/add"
        title="list of Flights"
        buttonClass="bg-indigo-600 text-white px-8 py-2 rounded-sm"
      />
    </div>
  );
};

export default AdminDashboardFlights;
