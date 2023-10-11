import React, { useEffect, useState } from "react";
import { getAll } from "../../../api/trips/fetchers";
import DashboardHeader from "../../../components/dashboardHeader/Dashboard";
import Table from "../../../components/table/Table";
import _ from "lodash";
import { Link } from "react-router-dom";
const AdminDashboardTrips = () => {
  const [trips, setTrips] = useState(null);
  useEffect(() => {
    getAll().then((response) => {
      console.log({ response });

      const updatedResponse = response?.map((trip) =>
        _.omit(trip, ["createAt", "depatureTime", "arrivalTime", "id"])
      );
      setTrips(() => [...updatedResponse]);
    });
  }, []);
  if (trips) {
    return (
      <div>
        <DashboardHeader
          sectionClass="flex justify-between p-4"
          buttonLabel="add Trip"
          to="/admin/trips/add"
          title="list of trips"
          buttonClass="bg-indigo-600 text-white px-8 py-2 rounded-sm"
        />
        {trips.length ? <Table data={trips} /> : null}
      </div>
    );
  }
  return null;
};

export default AdminDashboardTrips;
