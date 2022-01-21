import React, { useState } from 'react';
import "./main.css";
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


const Main = () => {

    const [values, setValues] = useState({
        user_id: 0,
        username: '',
        Credit_line: 0.0,
        Debt: 0.0,
        Credit_balance: 0.0
    })

    const handleChange = e => {
        const {name, value} = e.target;
        setValues({
            ...values,
            [name]: value
        });
        console.log(values);
    }

    const handleSubmit = e => {
        e.preventDefault();
        var json_vals = JSON.stringify(values);
        console.log("JSON  " + json_vals);

        var urlEnd = 'http://localhost:8080/WebApp/InsertPrivateAccount';

        $.ajax({
            url: urlEnd,
            type: "POST",
            contentType: "application/json",
            data: json_vals,
            success: function (result) {
                console.log("SUCCESS")
              },
              error: function (result) {
                console.log("FAIL")
                
              }
    
        })
    }


    return(
        <form method='POST' onSubmit={handleSubmit} noValidate>
            <Stack maxWidth={1000} margin='auto' spacing={7} margin-top={5}>
                <Text fontSize='5xl' >Register Private</Text>
                <FormControl isRequired id='user_id'>
                    <FormLabel>user_id</FormLabel>
                    <NumberInput
                        colorScheme='Purple'
                        clampValueOnBlur={false}
                    >
                        <NumberInputField
                        name='user_id'
                        onChange={handleChange}
                        placeholder='0'
                        />
                        <FormErrorMessage> error </FormErrorMessage>
                    </NumberInput>
                </FormControl>
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
                <FormControl isRequired id='Credit_line'>
                    <FormLabel>Credit_line</FormLabel>
                    <NumberInput
                        colorScheme='Purple'
                        clampValueOnBlur={false}
                    >
                        <NumberInputField
                        name='Credit_line'
                        onChange={handleChange}
                        placeholder='0.0'
                        />
                        <FormErrorMessage> error </FormErrorMessage>
                    </NumberInput>
                </FormControl>
                <FormControl isRequired id='Debt'>
                    <FormLabel>Debt</FormLabel>
                    <NumberInput
                        colorScheme='Purple'
                        clampValueOnBlur={false}
                    >
                        <NumberInputField
                        name='Debt'
                        onChange={handleChange}
                        placeholder='0.0'
                        />
                        <FormErrorMessage> error </FormErrorMessage>
                    </NumberInput>
                </FormControl>
                <FormControl isRequired id='Credit_balance'>
                    <FormLabel>Credit_balance</FormLabel>
                    <NumberInput
                        colorScheme='Purple'
                        clampValueOnBlur={false}
                    >
                        <NumberInputField
                        name='Credit_balance'
                        onChange={handleChange}
                        placeholder='0.0'
                        />
                        <FormErrorMessage> error </FormErrorMessage>
                    </NumberInput>
                </FormControl>

                <Button
                    mt={2}
                    type="submit"
                 >
                Submit
                </Button>
                
            </Stack>
        </form>
    )




};
export default Main;