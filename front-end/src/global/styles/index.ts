import "styled-components";
import { createGlobalStyle } from "styled-components";

export const GlobalStyle = createGlobalStyle`
  * {
    padding: 0;
    margin: 0;
    border: 0;

    box-sizing: border-box;

    font-family: Helvetica, Arial, sans-serif;
  }
`;

declare module "styled-components" {
  export interface DefaultTheme {
    main: string;
    contrast: string;
    primary: string;

    borderRadius: string;
  }
}
