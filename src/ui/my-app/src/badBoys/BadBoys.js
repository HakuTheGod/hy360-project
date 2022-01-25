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
import BadRows from './BadRows';
import dayjs from 'dayjs';


const BadBoys = () => {

    const [badBoys, setBadBoys] = useState([]);
    const [ isLoaded, setIsLoaded ] = useState(false);

    useEffect( () => {



            var urlEnd = 'http://localhost:8080/WebApp/BadBoys';

            $.ajax({
                url: urlEnd,
                type: "GET",
                contentType: "application/json",
                success: function (result) {
                    console.log("SUCCESS");
                    setBadBoys(result);
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
            <Th>User ID</Th>
            <Th>User Name</Th>
            </Tr>
        </Thead>
        {isLoaded ?
          <Tbody>
            
            {badBoys.map(badBoy => <BadRows info={badBoy} key={badBoy.user_name} />)}
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

export default BadBoys;