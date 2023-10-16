import { useState, useEffect } from "react";
import { getAll, update } from "../../../api/bookings/fetchers";
import _ from "lodash";
import NavBar from "../../../components/navbar/NavBar";
import Table from "../../../components/table/Table";
const BookingListPage = () => {
  const [bookings, setBookings] = useState([]);
  const [invalid, setInvalid] = useState(false);
  useEffect(() => {
    getAll().then((response) => {
      const updatedResponse = response?.map((booking) =>
        _.omit(booking, ["trip", "transactionId"])
      );
      setBookings([...updatedResponse]);
    });
  }, [invalid]);
  const handleCancel = async (row) => {
    try {
      console.log({ row });
      await update({ ...row, status: false });
      setInvalid(!invalid);
      return alert("your ticket has been canceled");
    } catch (error) {
      alert(error.message);
    }
  };
  console.log({ bookings });
  return (
    <main className="flex flex-col gap-4 bg-wing text-gray-200 bg-cover bg-black/30 bg-blend-multiply h-screen">
      <NavBar />
      <h1 className="uppercase text-3xl font-bold px-3">Your bookings</h1>
      {bookings.length > 0 ? (
        <Table
          data={bookings}
          tableClass="py-3"
          hasAction
          render={(row) => (
            <span className="flex justify-center">
              {row?.status && (
                <button
                  onClick={() => handleCancel(row)}
                  className="text-red-500  border-red-500 border px-4 rounded"
                >
                  Cancel
                </button>
              )}
            </span>
          )}
        />
      ) : (
        <section className="h-[calc(100vh-58px)] ">
          <h1 className="text-4xl relative top-20 text-center font-bold uppercase tracking-wide">
            nothing to show...
          </h1>
        </section>
      )}
    </main>
  );
};

export default BookingListPage;
