import { useMutation, useQuery, useQueryClient } from "@tanstack/react-query";
import { create, getAll, getOne, remove, update } from "./fetchers";

// all flights custom hook
export const useGetFlightsQuery = () =>
  useQuery({
    queryKey: "flights",
    queryFn: getAll,
  });

// single flight custom hook
export const useGetFlightQuery = id =>
  useQuery({
    queryKey: "flights",
    queryFn: () => getOne(id),
  });

// registering custom hook
export const useCreateFlightMutation = body => {
  const queryClient = useQueryClient();
  return useMutation({
    mutationFn: () => create(body),
    onMutate: responseData => {
      const oldData = queryClient.getQueryData("flights");
      queryClient.setQueryData("flights", [...oldData, responseData]);
    },
    onSuccess: () => {
      queryClient.invalidateQueries("flights");
    },
  });
};

//updating flight custom hook
export const useUpdateFlightMutation = body => {
  const queryClient = useQueryClient();
  return useMutation({
    mutationFn: () => update(body),
    onMutate: responseData => {
      const oldData = queryClient.getQueryData("flights");
      queryClient.setQueryData("flights", [...oldData, responseData]);
    },
    onSuccess: () => {
      queryClient.invalidateQueries("flights");
    },
  });
};

// deleting passenger
export const useDeleteFlightMutation = id => {
  const queryClient = useQueryClient();
  return useMutation({
    mutationFn: () => remove(id),
    onMutate: () => {
      const oldData = queryClient.getQueryData("flights");
      queryClient.setQueryData("flights", [
        ...oldData.filter(flight => flight.id !== id),
      ]);
    },
    onSuccess: () => {
      queryClient.invalidateQueries("flights");
    },
  });
};
