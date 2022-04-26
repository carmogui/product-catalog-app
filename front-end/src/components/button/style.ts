import styled from "styled-components";

export const Main = styled.button`
  padding: 10px;
  cursor: pointer;
  border-radius: 5px;
  font-weight: bold;

  &:hover {
    opacity: 0.7;
  }

  &.primary {
    background-color: cadetblue;
    text-transform: uppercase;
  }

  &.link {
    text-transform: capitalize;
    text-decoration: underline;
    background-color: transparent;
  }
`;
