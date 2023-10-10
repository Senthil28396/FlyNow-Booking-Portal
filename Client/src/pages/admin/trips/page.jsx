import React, { useEffect, useState } from "react";
import { getAll } from "../../../api/flights/fetchers";
import DashboardHeader from "../../../components/dashboardHeader/Dashboard";

const AdminDashboardTrips = () => {
  const [trips, setTrips] = useState([]);
  useEffect(() => {
    getAll().then(response => {
      console.log({ response });
      setTrips(() => [...response]);
    });
  }, []);
  return (
    <div>
      <DashboardHeader
        sectionClass="flex justify-between p-4"
        buttonLabel="add Trip"
        to="/admin/trips/add"
        title="list of trips"
        buttonClass="bg-indigo-600 text-white px-8 py-2 rounded-sm"
      />
    </div>
  );
};

export default AdminDashboardTrips;
