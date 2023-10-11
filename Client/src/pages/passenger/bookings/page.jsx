import { useState, useEffect } from "react";
import { getAll } from "../../../api/bookings/fetchers";
import _ from "lodash";
const BookingListPage = () => {
  const [bookings, setBookings] = useState(null);

  useEffect(() => {
    getAll().then((response) => {
      const updatedResponse = response?.map((booking) => _.omit(booking, []));
      setBookings([...updatedResponse]);
    });
  }, []);
  console.log({ bookings });
  return <div>BookingListPage</div>;
};

export default BookingListPage;
