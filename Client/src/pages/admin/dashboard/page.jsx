import { Link, Outlet } from "react-router-dom";
import NavBar from "../../../components/navbar/NavBar";
import _ from "lodash";
const links = ["flights", "trips", "passengers"];

const Dashboard = () => {
  return (
    <div>
      <NavBar bg />
      <main className="flex  gap-1 m-5 bg-slate-200  h-[calc(100vh-90px)]">
        <aside className="basis-56 border-r-2 px-4 flex text-slate-50 flex-col gap-4 bg-indigo-700">
          <h2 className="text-2xl font-bold tracking-wide uppercase">
            dashboard
          </h2>
          <nav>
            <ul className="flex flex-col gap-3 w-full">
              {links.map(link => (
                <li key={link} className="font-semibold tracking-wide w-full">
                  <Link
                    to={link === "flights" ? "" : link}
                    className="block w-full"
                  >
                    {_.capitalize(link)}
                  </Link>
                </li>
              ))}
            </ul>
          </nav>
        </aside>
        <section className="flex-1">
          <Outlet />
        </section>
      </main>
    </div>
  );
};

export default Dashboard;
