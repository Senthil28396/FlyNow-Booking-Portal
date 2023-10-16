import { useEffect, useState } from "react";
import { getAll, remove } from "../../../api/flights/fetchers";
import Table from "../../../components/table/Table";
import DashboardHeader from "../../../components/dashboardHeader/Dashboard";
import _ from "lodash";
import { Link } from "react-router-dom";
const AdminDashboardFlights = () => {
  const [flights, setFlights] = useState(null);
  const [invalid, setInvalid] = useState(false);

  useEffect(() => {
    getAll().then((response) => {
      console.log({ response });
      const updatedFlights = response.map((flight) =>
        _.omit(flight, ["createdAt"])
      );
      setFlights(() => [...updatedFlights]);
    });
  }, [invalid]);
  console.log({ flights });
  if (flights) {
    return (
      <div>
        <DashboardHeader
          sectionClass="flex justify-between p-4"
          buttonLabel="add flight"
          to="/admin/flights/add"
          title="list of Flights"
          buttonClass="bg-indigo-600 text-white px-8 py-2  rounded-sm"
        />
        {flights.length ? (
          <Table
            data={flights}
            hasAction
            render={(row) => (
              <Action row={row} setInvalid={setInvalid} invalid={invalid} />
            )}
          />
        ) : (
          <h2>NO flights there</h2>
        )}
      </div>
    );
  }
  return null;
};

export default AdminDashboardFlights;

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
      {row.status && (
        <>
          <Link to={`/admin/flights/${row.id}/edit`}>
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
          <Link className="rounded-sm" to={`/admin/trips/${row.id}/add`}>
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
                d="M12 9v6m3-3H9m12 0a9 9 0 11-18 0 9 9 0 0118 0z"
              />
            </svg>
          </Link>
        </>
      )}
      <button className="" onClick={handleDelete}>
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
