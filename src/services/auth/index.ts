import axios from "axios";

interface AuthProps {
  username: string;
  password: string;
}

const BASE_URL =
  "https://keycloak-full.herokuapp.com/auth/realms/product-catalog";

export async function auth({ username, password }: AuthProps) {
  const grant_type = "password";
  const client_id = "product-catalog-api";
  const client_secret = "0udaNxEkuya5kK2Lq5zK1deHZSWqX7Vl";

  const params = new URLSearchParams();
  params.append("grant_type", grant_type);
  params.append("client_id", client_id);
  params.append("client_secret", client_secret);
  params.append("username", username);
  params.append("password", password);

  const result = await axios({
    method: "POST",
    url: `${BASE_URL}/protocol/openid-connect/token`,
    data: params,
    headers: {
      "Content-Type": "application/x-www-form-urlencoded",
    },
    withCredentials: true,
  }).catch((error) => {
    return error.response;
  });

  return result;
}
