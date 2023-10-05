import { useMutation, useQuery, useQueryClient } from "@tanstack/react-query";
import { create, getAll, getOne, remove, update } from "./fetchers";

// all reservations custom hook
export const useGetReservationsQuery = () =>
  useQuery({
    queryKey: "reservations",
    queryFn: getAll,
  });

// single reservation custom hook
export const useGetReservationQuery = id =>
  useQuery({
    queryKey: "reservations",
    queryFn: () => getOne(id),
  });

// registering custom hook
export const useCreateReservationMutation = body => {
  const queryClient = useQueryClient();
  return useMutation({
    mutationFn: () => create(body),
    onMutate: responseData => {
      const oldData = queryClient.getQueryData("reservations");
      queryClient.setQueryData("reservations", [...oldData, responseData]);
    },
    onSuccess: () => {
      queryClient.invalidateQueries("reservations");
    },
  });
};

//updating reservation custom hook
export const useUpdateReservationMutation = body => {
  const queryClient = useQueryClient();
  return useMutation({
    mutationFn: () => update(body),
    onMutate: responseData => {
      const oldData = queryClient.getQueryData("reservations");
      queryClient.setQueryData("reservations", [...oldData, responseData]);
    },
    onSuccess: () => {
      queryClient.invalidateQueries("reservations");
    },
  });
};

// deleting passenger
export const useDeleteReservationMutation = id => {
  const queryClient = useQueryClient();
  return useMutation({
    mutationFn: () => remove(id),
    onMutate: () => {
      const oldData = queryClient.getQueryData("reservations");
      queryClient.setQueryData("reservations", [
        ...oldData.filter(reservation => reservation.id !== id),
      ]);
    },
    onSuccess: () => {
      queryClient.invalidateQueries("reservations");
    },
  });
};
