import { FC } from "react";
import * as S from "./style";

interface Props extends React.ButtonHTMLAttributes<HTMLButtonElement> {
  variant?: "primary" | "link";
}

export const Button: FC<Props> = ({
  variant = "primary",
  children,
  ...rest
}) => {
  return (
    <S.Main className={variant} {...rest}>
      {children}
    </S.Main>
  );
};
