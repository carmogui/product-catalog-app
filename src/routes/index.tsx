import { useAuth } from "../context/auth";
import { AuthenticatedRoutes } from "./authenticated";
import { OtherRoutes } from "./other";

export function Routes() {
  const { user } = useAuth();

  return user ? <AuthenticatedRoutes /> : <OtherRoutes />;
}
