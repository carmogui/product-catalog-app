import axios from "axios";

const BASE_URL = "http://productcatalog-api.herokuapp.com/api";

export const apiAxios = axios.create({
  baseURL: BASE_URL,
});

apiAxios.interceptors.request.use(
  (config: any) => {
    const accessToken = localStorage.getItem("access_token");

    config.headers.authorization = `Bearer ${accessToken}`;

    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);
