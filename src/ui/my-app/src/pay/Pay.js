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



const Pay = () =>{

    const [responseMessage, setResponseMessage] = useState('');

    const [color, setColor] = useState('')

    const [values, setValues] = useState({
        user_name: '',
        amount_to_pay: 0.0
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
            const {name, value} = e.target;
            console.log(e.target.value);
            setValues({
                ...values,
                [name]: value
            });

            console.log(values);

        }

    const deleteR = e => {

        e.preventDefault();

        var urlEnd;
        var json_val;

            if(final === 'Private'){
                urlEnd = 'http://localhost:8080/WebApp/PayAccount';
            }
            else if(final === 'Company'){
                urlEnd = 'http://localhost:8080/WebApp/PayCompany';
            }
            else{
                urlEnd = 'http://localhost:8080/WebApp/PaySupplier';
            }
        
        json_val = JSON.stringify(values);

        $.ajax({
            url: urlEnd,
            type: "POST",
            contentType: 'application/json',
            data: json_val,
            success: function (result) {
                console.log("Success");
                console.log(result);
                setResponseMessage('Money transfer was successfull')
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

                    <FormControl isRequired id='price'>
                    <FormLabel>Amount</FormLabel>
                    <NumberInput
                        colorScheme='Purple'
                        clampValueOnBlur={false}
                    >
                        <NumberInputField
                        name='amount_to_pay'
                        onChange={handleChange}
                        placeholder='0'
                        />
                        <FormErrorMessage> error </FormErrorMessage>
                    </NumberInput>
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


export default Pay;