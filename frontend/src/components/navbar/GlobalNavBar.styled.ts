import styled from 'styled-components';
import tw from 'twin.macro';

const Box = styled.div`
  ${tw`
    flex
    items-center
    justify-center

    m-[5px]

    w-[60px]
    h-[60px]
  `}
`;

const Button = styled.button`
  ${tw`
      flex
      items-center
      justify-center

      mt-[5px]
      w-[60px]
      h-[60px]

      rounded-full
    `}

  &:hover {
    ${tw`
      bg-default-warmgray

      duration-100
    `}
  }
`;

const Image = styled.img`
  ${tw`
    h-[24px]
    w-[24px]
`}
`;

export { Box, Button, Image };
