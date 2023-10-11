import { useEffect, useState } from "react";
import { getAll } from "../../../api/passengers/fetchers";
import DashboardHeader from "../../../components/dashboardHeader/Dashboard";
import Table from "../../../components/table/Table";
import _ from "lodash";
const AdminDashboardPassengers = () => {
  const [passangers, setPassangers] = useState([]);
  useEffect(() => {
    getAll().then((response) => {
      console.log({ response });
      const updatedResponse = response?.map((passenger) =>
        _.omit(passenger, ["role", "admin", "reservations", "password", "id"])
      );
      setPassangers(() => [...updatedResponse]);
    });
  }, []);
  return (
    <div>
      <DashboardHeader
        sectionClass="flex justify-between p-4"
        buttonLabel="add passangers"
        to="/passagers/signup"
        title="list of passangers"
        buttonClass="bg-indigo-600 text-white px-8 py-2 rounded-sm"
        notHas
      />
      {passangers.length > 0 ? (
        <Table data={passangers} />
      ) : (
        <h1 className="uppercase text-xl font-bold tracking-wider">
          NO Passengers are there
        </h1>
      )}
    </div>
  );
};

export default AdminDashboardPassengers;
