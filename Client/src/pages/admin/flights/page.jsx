import { getAll } from "../../../api/flights/fetchers";
import useQuery from "../../../hooks/useQuery";
const AdminDashboardFlights = () => {
  const { data, error } = useQuery(getAll);
  console.log({ err: error?.message });
  return <div>AdminDashboardFlights</div>;
};

export default AdminDashboardFlights;
