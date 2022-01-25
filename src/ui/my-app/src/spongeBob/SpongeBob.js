import React, { useEffect, useState } from 'react';
import { 
    Stack, 
    Button, 
    FormControl, 
    FormLabel, 
    FormHelperText,
    Input, 
    FormErrorMessage,
    InputGroup,
    InputRightElement,
    Radio,
    HStack,
    RadioGroup,
    Select,
    Grid,
    NumberInput,
    NumberInputField,
    Checkbox,
    Textarea,
    Table,
    Thead,
    Tbody,
    Tr,
    Th,
    Td,
    Skeleton,
    Text
} from '@chakra-ui/react'
import $ from 'jquery';
import SpongeRows from './SpongeRows';
import dayjs from 'dayjs';


const SpongeBob = () => {

    const [spongeBobs, setSpongeBobs] = useState([]);
    const [ isLoaded, setIsLoaded ] = useState(false);

    useEffect( () => {



            var urlEnd = 'http://localhost:8080/WebApp/SpongeBob';

            $.ajax({
                url: urlEnd,
                type: "GET",
                contentType: "application/json",
                success: function (result) {
                    console.log("SUCCESS");
                    setSpongeBobs(result);
                    setIsLoaded(true);
                  },
                  error: function (result) {
                    console.log("FAIL");
                    setIsLoaded(true);
                  }
        

                });
    }   
    ,[]);


    return(
<>
        <Table variant='striped' colorScheme='grey'>
            <Thead>
            <Tr>
            <Th>User Name</Th>
            <Th>Total Sales</Th>
            </Tr>
        </Thead>
        {isLoaded ?
          <Tbody>
            
            {spongeBobs.map(spongeBob => <SpongeRows info={spongeBob} key={spongeBob.user_name} />)}
          </Tbody>
          :
          <Tbody>
            <Tr>
            <Td><Skeleton height='40px' w='100%' /></Td>
            <Td><Skeleton height='40px' w='100%' /></Td>
            </Tr>
            <Tr>
            <Td><Skeleton height='40px' w='100%' /></Td>
            <Td><Skeleton height='40px' w='100%' /></Td>
            </Tr>
            <Tr>
            <Td><Skeleton height='40px' w='100%' /></Td>
            <Td><Skeleton height='40px' w='100%' /></Td>
            </Tr>
            <Tr>
            <Td><Skeleton height='40px' w='100%' /></Td>
            <Td><Skeleton height='40px' w='100%' /></Td>
            </Tr>
            <Tr>
            <Td><Skeleton height='40px' w='100%' /></Td>
            <Td><Skeleton height='40px' w='100%' /></Td>
            </Tr>
            <Tr>
            <Td><Skeleton height='40px' w='100%' /></Td>
            <Td><Skeleton height='40px' w='100%' /></Td>
            </Tr>
            <Tr>
            <Td><Skeleton height='40px' w='100%' /></Td>
            <Td><Skeleton height='40px' w='100%' /></Td>
            </Tr>
            <Tr>
            <Td><Skeleton height='40px' w='100%' /></Td>
            <Td><Skeleton height='40px' w='100%' /></Td>
            </Tr>
          </Tbody>
          }
      </Table>
      </>
    )
}

export default SpongeBob;