import { useMutation, useQuery, useQueryClient } from "@tanstack/react-query";
import { create, getAll, getOne, remove, update } from "./fetchers";

// all trips custom hook
export const useGetTripsQuery = () =>
  useQuery({
    queryKey: "trips",
    queryFn: getAll,
  });

// single trip custom hook
export const useGetTripQuery = id =>
  useQuery({
    queryKey: "trips",
    queryFn: () => getOne(id),
  });

// registering custom hook
export const useCreateTripMutation = body => {
  const queryClient = useQueryClient();
  return useMutation({
    mutationFn: () => create(body),
    onMutate: responseData => {
      const oldData = queryClient.getQueryData("trips");
      queryClient.setQueryData("trips", [...oldData, responseData]);
    },
    onSuccess: () => {
      queryClient.invalidateQueries("trips");
    },
  });
};

//updating trip custom hook
export const useUpdateTripMutation = body => {
  const queryClient = useQueryClient();
  return useMutation({
    mutationFn: () => update(body),
    onMutate: responseData => {
      const oldData = queryClient.getQueryData("trips");
      queryClient.setQueryData("trips", [...oldData, responseData]);
    },
    onSuccess: () => {
      queryClient.invalidateQueries("trips");
    },
  });
};

// deleting passenger
export const useDeleteTripMutation = id => {
  const queryClient = useQueryClient();
  return useMutation({
    mutationFn: () => remove(id),
    onMutate: () => {
      const oldData = queryClient.getQueryData("trips");
      queryClient.setQueryData("trips", [
        ...oldData.filter(trip => trip.id !== id),
      ]);
    },
    onSuccess: () => {
      queryClient.invalidateQueries("trips");
    },
  });
};
