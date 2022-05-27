import { apiAxios } from "../api";

async function getList() {
  const data = await apiAxios({
    method: "get",
    url: "/product",
  });

  return data.data;
}

export const productService = {
  getList,
};
