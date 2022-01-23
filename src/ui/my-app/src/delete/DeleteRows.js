import React, { useState } from 'react';
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
    Text
} from '@chakra-ui/react'
import $ from 'jquery';



const DeleteRows = () =>{

    const [responseMessage, setResponseMessage] = useState('');

    const [color, setColor] = useState('')

    const [username, setUsername] = useState({
        user_name: ''
    });

    let type = 'Private';

    const [final, setFinal] = useState('Private');

    const handleState = e => {
            console.log(e.target.value);
            type = e.target.value;
            setFinal(type);
            console.log(type);
        }

    const handleChange = e => {
            console.log(e.target.value);
            setUsername({user_name: e.target.value});
            
            console.log(type);
        }

    const deleteR = e => {

        e.preventDefault();

        var urlEnd;
        var json_val;

            if(final === 'Private'){
                urlEnd = 'http://localhost:8080/WebApp/DeletePrivateAccount';
            }
            else if(final === 'Company'){
                urlEnd = 'http://localhost:8080/WebApp/DeleteCompanyAccount';
            }
            else{
                urlEnd = 'http://localhost:8080/WebApp/DeleteSupplierAccount';
            }
        
        json_val = JSON.stringify(username);

        $.ajax({
            url: urlEnd,
            type: "POST",
            contentType: 'application/json',
            data: json_val,
            success: function (result) {
                console.log("Success");
                console.log(result);
                setResponseMessage('Account terminated successfully!')
                setColor('green');
            },
            error: function (result) {
                console.log("Fail");
                console.log(result.status);
                setResponseMessage('Account could not be terminated. Please ensure that you gave the right credentials.')
                setColor('red')
            }
        });
    }

    return(
        <form method='POST' onSubmit={deleteR} noValidate>
            <Stack maxWidth={1000} margin='auto' spacing={7} margin-top={5}>
                <Text fontSize='3xl'>Enter your credentials</Text>
                <FormControl isRequired id='user_name'>
                    <FormLabel>user_name</FormLabel>
                    <Input
                        type='text'
                        name='user_name'
                        autoComplete='on'
                        onChange={handleChange}
                        placeholder='Username'
                    >
                    </Input>
                    </FormControl>

                    <FormControl isRequired id='RegType'>
                    <FormLabel>user Type</FormLabel>
                    <Select name="type" defaultValue='Private' onChange={handleState}>
                        <option value='Private'> Private </option>
                        <option value='Company'> Company </option>
                        <option value='Supplier'> Supplier </option>
                    </Select>
                </FormControl>

                <Button
                    mt={2}
                    type="submit"
                 >
                Submit
                </Button>
                <h2 style={{color: color}}>{responseMessage}</h2>
            </Stack>
        </form>


    )
}


export default DeleteRows;