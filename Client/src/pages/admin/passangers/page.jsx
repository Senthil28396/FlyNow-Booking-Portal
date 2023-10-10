import React, { useEffect, useState } from "react";
import { getAll } from "../../../api/passengers/fetchers";
import DashboardHeader from "../../../components/dashboardHeader/Dashboard";
const AdminDashboardPassengers = () => {
  const [passangers, setPassangers] = useState([]);
  useEffect(() => {
    getAll().then(response => {
      console.log({ response });
      setPassangers(() => [...response]);
    });
  }, []);
  return (
    <div>
      <DashboardHeader
        sectionClass="flex justify-between p-4"
        buttonLabel="add passangers"
        to="/admin/passangers/add"
        title="list of passangers"
        buttonClass="bg-indigo-600 text-white px-8 py-2 rounded-sm"
      />
    </div>
  );
};

export default AdminDashboardPassengers;
