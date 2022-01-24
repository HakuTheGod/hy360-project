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


    const [show, toggleShow] = React.useState(false);

    const [values, setValues] = useState({
        user_id: 0,
        user_name: '',
        Credit_line: 0.0,
        Debt: 0.0,
        Credit_balance: 0.0
    })

    const [Svalues, setSValues] = useState({
        user_id: 0,
        user_name: '',
        Products: '',
        Profit: 0.0,
        Percent_toCCC: 0.0,
        Debt: 0.0,
        Product_price: 0.0
    })

 
    let type = 'Private';
    const [final, setFinal] = useState('Private');

    const handleState = e => {
        console.log(e.target.value);
        type = e.target.value;
        setFinal(type);
        if(type === 'Supplier'){
            toggleShow(true)
        }
        else{
            toggleShow(false);
        }
        console.log(type);
    }

    const handleChange = e => {
        const {name, value} = e.target;
        console.log(e.target.value);
        setValues({
            ...values,
            [name]: value
        });
        console.log(values);
    }

    const handleChangeS = e => {
        const {name, value} = e.target;
        console.log(e.target.value);
        setSValues({
            ...Svalues,
            [name]: value
        });
        console.log(Svalues);
        console.log(final);
    }
    

    const handleSubmit = e => {
        e.preventDefault();

        var urlEnd;
        var json_vals;

        console.log(final);

        if(final === 'Supplier'){
            console.log(final);
             json_vals = JSON.stringify(Svalues);
            console.log("JSON  " + json_vals);
            urlEnd = 'http://localhost:8080/WebApp/InsertSupplierAccount';

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
        else{
            json_vals = JSON.stringify(values);
            console.log("JSON  " + json_vals);

            if(final === 'Private'){
                urlEnd = 'http://localhost:8080/WebApp/InsertPrivateAccount';
            }
            else{
                urlEnd = 'http://localhost:8080/WebApp/InsertCompanyAccount';
            }
            
    
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

        
    }


    return(
        <>
        <form method='POST' onSubmit={handleSubmit} noValidate>
            <Stack maxWidth={1000} margin='auto' spacing={7} margin-top={5}>
                <Text fontSize='5xl' >Register Private</Text>
                {show &&
                    <div>
                    <FormControl isRequired id='user_id'>
                    <FormLabel>user_id</FormLabel>
                    <NumberInput
                        colorScheme='Purple'
                        clampValueOnBlur={false}
                    >
                        <NumberInputField
                        name='user_id'
                        onChange={handleChangeS}
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
                        onChange={handleChangeS}
                        placeholder='Username'
                    >
                    </Input>
                </FormControl>

                    <FormControl isRequired id='Products'>
                        <FormLabel>Product</FormLabel>
                            <Input
                                type='text'
                                name='Products'
                                autoComplete='on'
                                onChange={handleChangeS}
                                placeholder='Drugs'
                            >
                        </Input>
                    </FormControl>

                    <FormControl isRequired id='Profit'>
                    <FormLabel>Profit</FormLabel>
                    <NumberInput
                        colorScheme='Purple'
                        clampValueOnBlur={false}
                    >
                        <NumberInputField
                        name='Profit'
                        onChange={handleChangeS}
                        placeholder='0.0'
                        />
                        <FormErrorMessage> error </FormErrorMessage>
                    </NumberInput>
                </FormControl>

                <FormControl isRequired id='Percent_toCCC'>
                        <FormLabel>Percent_toCCC</FormLabel>
                        <NumberInput
                            colorScheme='Purple'
                            clampValueOnBlur={false}
                        >
                            <NumberInputField
                            name='Percent_toCCC'
                            onChange={handleChangeS}
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
                        onChange={handleChangeS}
                        placeholder='0.0'
                        />
                        <FormErrorMessage> error </FormErrorMessage>
                    </NumberInput>
                </FormControl>

                <FormControl isRequired id='Product_price'>
                    <FormLabel>Product Price</FormLabel>
                    <NumberInput
                        colorScheme='Purple'
                        clampValueOnBlur={false}
                    >
                        <NumberInputField
                        name='Product_price'
                        onChange={handleChangeS}
                        placeholder='0.0'
                        />
                        <FormErrorMessage> error </FormErrorMessage>
                    </NumberInput>
                </FormControl>
                </div>
                }
               {    !show &&
                    <div>
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
                    </div>
                }
                

                <FormControl isRequired id='RegType'>
                    <FormLabel>Register Type</FormLabel>
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
                
            </Stack>
        </form>
        </>
    )




};
export default Main;