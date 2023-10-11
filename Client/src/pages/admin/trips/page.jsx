import React, { useEffect, useState } from "react";
import { getAll } from "../../../api/trips/fetchers";
import DashboardHeader from "../../../components/dashboardHeader/Dashboard";
import Table from "../../../components/table/Table";
import _ from "lodash";
import { remove } from "../../../api/trips/fetchers";
import { Link } from "react-router-dom";
const AdminDashboardTrips = () => {
  const [trips, setTrips] = useState(null);
  const [invalid, setInvalid] = useState(false);
  useEffect(() => {
    getAll().then((response) => {
      console.log({ response });

      const updatedResponse = response?.map((trip) =>
        _.omit(trip, ["createAt", "depatureTime", "arrivalTime"])
      );
      setTrips(() => [...updatedResponse]);
    });
  }, [invalid]);
  if (trips) {
    return (
      <div>
        <DashboardHeader
          sectionClass="flex justify-between p-4"
          buttonLabel="add Trip"
          to="/admin/trips/add"
          title="list of trips"
          buttonClass="bg-indigo-600 text-white px-8 py-2 rounded-sm"
          notHas
        />
        {trips.length ? (
          <Table
            data={trips}
            hasAction
            render={(row) => {
              console.log({ row });
              return (
                <Action row={row} invalid={invalid} setInvalid={setInvalid} />
              );
            }}
          />
        ) : null}
      </div>
    );
  }
  return null;
};

export default AdminDashboardTrips;
const Action = ({ row, setInvalid, invalid }) => {
  const handleDelete = async () => {
    try {
      await remove(row.id);
      setInvalid(!invalid);
    } catch (error) {
      alert(error.message);
    }
  };
  return (
    <div className="flex justify-evenly">
      <Link to={`/admin/trips/${row.id}/edit`}>
        <svg
          xmlns="http://www.w3.org/2000/svg"
          fill="none"
          viewBox="0 0 24 24"
          strokeWidth={1.5}
          stroke="currentColor"
          className="w-6 h-6"
        >
          <path
            strokeLinecap="round"
            strokeLinejoin="round"
            d="M16.862 4.487l1.687-1.688a1.875 1.875 0 112.652 2.652L10.582 16.07a4.5 4.5 0 01-1.897 1.13L6 18l.8-2.685a4.5 4.5 0 011.13-1.897l8.932-8.931zm0 0L19.5 7.125M18 14v4.75A2.25 2.25 0 0115.75 21H5.25A2.25 2.25 0 013 18.75V8.25A2.25 2.25 0 015.25 6H10"
          />
        </svg>
      </Link>
      <button className="mx-3" onClick={handleDelete}>
        <svg
          xmlns="http://www.w3.org/2000/svg"
          fill="none"
          viewBox="0 0 24 24"
          strokeWidth={1.5}
          stroke="currentColor"
          className="w-6 h-6"
        >
          <path
            strokeLinecap="round"
            strokeLinejoin="round"
            d="M9.75 9.75l4.5 4.5m0-4.5l-4.5 4.5M21 12a9 9 0 11-18 0 9 9 0 0118 0z"
          />
        </svg>
      </button>
    </div>
  );
};
