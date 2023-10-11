import { capitalize } from "lodash";

const Row = ({ data, hasAction, render }) => {
  const columnCount = Object.keys(data[0]).length;
  const headerColumns = Object.keys(data[0]);
  console.log({ columnCount, headerColumns });
  return (
    <table className="block w-full px-3">
      <thead className="block  w-full text-left">
        <tr className="flex items-center  px-2 mb-1">
          {headerColumns.map((val, index) => (
            <th
              key={index}
              className="flex-1 text-ellipsis whitespace-nowrap overflow-hidden"
            >
              {capitalize(val)}
            </th>
          ))}
          {hasAction && <th>Actions</th>}
        </tr>
      </thead>
      <tbody className="block w-full text-left">
        {data.map((row, index) => (
          <tr
            key={index}
            className="flex items-center px-2 my-2 shadow-sm even:bg-slate-300 odd:bg-indigo-300 py-2"
          >
            {headerColumns.map((column) => (
              <td
                className="flex-1 font-normal text-ellipsis whitespace-nowrap overflow-hidden"
                key={column}
              >
                {typeof row[column] === "object"
                  ? row[column]?.id
                  : capitalize(row[column]) || "..."}
              </td>
            ))}
            {hasAction && <td>{render(row)}</td>}
          </tr>
        ))}
      </tbody>
    </table>
  );
};

export default Row;
