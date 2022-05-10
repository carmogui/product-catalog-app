import styled from "styled-components";

export const Main = styled.button`
  padding: 10px;
  cursor: pointer;
  border-radius: ${({ theme }) => theme.borderRadius};
  font-weight: bold;

  &:hover {
    opacity: 0.7;
  }

  &.primary {
    background-color: ${({ theme }) => theme.primary};
    text-transform: uppercase;
  }

  &.secondary {
    background-color: transparent;
    box-shadow: inset 0 0 0 2px ${({ theme }) => theme.primary};
    text-transform: uppercase;
  }

  &.link {
    text-transform: capitalize;
    text-decoration: underline;
    background-color: transparent;
  }
`;
