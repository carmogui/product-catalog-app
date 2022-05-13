import { FC, InputHTMLAttributes } from "react";
import * as S from "./styles";

interface Props extends InputHTMLAttributes<HTMLInputElement> {}

export const Input: FC<Props> = ({ ...rest }) => {
  return <S.Main {...rest} />;
};
