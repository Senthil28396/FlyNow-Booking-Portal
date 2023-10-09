import { useMutation, useQuery, useQueryClient } from "@tanstack/react-query";
import { create, getAll, getOne, login, remove, update } from "./fetchers";

// all passangers custom hook
export const useGetPassangersQuery = () =>
  useQuery({
    queryKey: "passangers",
    queryFn: getAll,
  });

// single passanger custom hook
export const useGetPassangerQuery = id =>
  useQuery({
    queryKey: "passangers",
    queryFn: () => getOne(id),
  });

// loggin custom hook
export const useLoginPassangerMutation = () => {
  return useMutation({
    mutationFn: async () => {
      console.log("working fine");
      return null;
    },
    onSuccess: responseData => {
      localStorage.setItem("token", responseData);
    },
  });
};

// registering custom hook
export const useCreatePassangerMutation = body => {
  const queryClient = useQueryClient();
  return useMutation({
    mutationFn: () => create(body),
    onMutate: responseData => {
      const oldData = queryClient.getQueryData("passangers");
      queryClient.setQueryData("passangers", [...oldData, responseData]);
    },
    onSuccess: () => {
      queryClient.invalidateQueries("passangers");
    },
  });
};

//updating passanger custom hook
export const useUpdatePassangerMutation = body => {
  const queryClient = useQueryClient();
  return useMutation({
    mutationFn: () => update(body),
    onMutate: responseData => {
      const oldData = queryClient.getQueryData("passangers");
      queryClient.setQueryData("passangers", [...oldData, responseData]);
    },
    onSuccess: () => {
      queryClient.invalidateQueries("passangers");
    },
  });
};

// deleting passenger
export const useDeletePassangerMutation = id => {
  const queryClient = useQueryClient();
  return useMutation({
    mutationFn: () => remove(id),
    onMutate: () => {
      const oldData = queryClient.getQueryData("passangers");
      queryClient.setQueryData("passangers", [
        ...oldData.filter(passanger => passanger.id !== id),
      ]);
    },
    onSuccess: () => {
      queryClient.invalidateQueries("passangers");
    },
  });
};
