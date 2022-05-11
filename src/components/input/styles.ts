import styled from "styled-components";

export const Main = styled.input`
  border: 1px solid ${({ theme }) => theme.contrast};
  border-radius: ${({ theme }) => theme.borderRadius};
  padding: 3px 6px;
`;
