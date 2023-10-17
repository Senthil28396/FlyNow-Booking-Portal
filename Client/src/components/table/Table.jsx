import clsx from "clsx";
import { capitalize } from "lodash";

const Row = ({ data, hasAction, render, tableClass }) => {
  const headerColumns = Object.keys(data[0]);

  return (
    <table className={`block w-full px-3 ${clsx(tableClass && tableClass)}`}>
      <thead className="block  w-full text-left">
        <tr className="flex items-center  px-2 mb-1">
          {headerColumns
            .filter((column) => column !== "id")
            .map((val, index) => (
              <th
                key={index}
                className="flex-1 text-ellipsis whitespace-nowrap overflow-hidden"
              >
                {capitalize(val)}
              </th>
            ))}
          {hasAction && (
            <th className="flex-1 text-ellipsis whitespace-nowrap overflow-hidden text-center">
              Actions
            </th>
          )}
        </tr>
      </thead>
      <tbody className="block w-full text-left text-black">
        {data.map((row, index) => (
          <tr
            key={index}
            className={`flex items-center px-2 my-2 shadow-sm  ${
              row?.status === true || headerColumns.includes("gender")
                ? "even:bg-slate-300 odd:bg-indigo-300 "
                : "bg-red-300"
            } py-2`}
          >
            {headerColumns
              .filter((column) => column !== "id")
              .map((column) => (
                <td
                  className="flex-1 font-normal text-ellipsis whitespace-nowrap overflow-hidden"
                  key={column}
                >
                  {typeof row[column] === "object"
                    ? capitalize(row[column]?.flightName) ?? row[column]?.id
                    : column === "id" || column === "status"
                    ? row[column]
                      ? "Booked"
                      : "Cancelled"
                    : capitalize(row[column]) || "..."}
                </td>
              ))}
            {hasAction && (
              <td className="flex-1 font-normal text-ellipsis whitespace-nowrap overflow-hidden">
                {render(row)}
              </td>
            )}
          </tr>
        ))}
      </tbody>
    </table>
  );
};

export default Row;
