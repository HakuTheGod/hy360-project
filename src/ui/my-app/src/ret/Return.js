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


const Return = () => {


    const [show, toggleShow] = React.useState(true);

    const [responseMessage, setResponseMessage] = useState('');
    const [color, setColor] = useState('');

    const [values, setValues] = useState({
        p_account_name: '',
        seller_name: '',
        product: '',
        quantity: 0,
        total_price: 0.0
    })

    const [Svalues, setSValues] = useState({
        c_account_name: 0,
        seller_name: '',
        product: '',
        employee_id: 0,
        quantity: 0,
        total_price: 0.0
    })

 
    let type = 'Private';
    const [final, setFinal] = useState('Private');

    const handleState = e => {
        console.log(e.target.value);
        type = e.target.value;
        setFinal(type);
        if(type === 'Private'){
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

        if(final === 'Private'){
            console.log(final);
             json_vals = JSON.stringify(values);
            console.log("JSON  " + json_vals);
            urlEnd = 'http://localhost:8080/WebApp/ReturnPrivate';

            $.ajax({
                url: urlEnd,
                type: "POST",
                contentType: "application/json",
                data: json_vals,
                success: function (result) {
                    console.log("SUCCESS");
                    var response = JSON.parse(result.responseText);
                    setResponseMessage(response.success);
                    setColor('green');
                  },
                  error: function (result) {
                    console.log("FAIL");
                    var response = JSON.parse(result.responseText);
                    setResponseMessage(response.fail);
                    setColor('red');
                  }
        
            })
        }
        else{
            json_vals = JSON.stringify(Svalues);
            console.log("JSON  " + json_vals);

          
            urlEnd = 'http://localhost:8080/WebApp/ReturnCompany';
            
            
    
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
                <Text fontSize='5xl' >Return</Text>
                {show &&
                    <div>
                <FormControl isRequired id='p_account_name'>
                    <FormLabel>user_name</FormLabel>
                    <Input
                        type='text'
                        name='p_account_name'
                        autoComplete='on'
                        onChange={handleChange}
                        placeholder='Username'
                    >
                    </Input>
                </FormControl>
                <FormControl isRequired id='seller_name'>
                    <FormLabel>seller_name</FormLabel>
                    <Input
                        type='text'
                        name='seller_name'
                        autoComplete='on'
                        onChange={handleChange}
                        placeholder='Seller'
                    >
                    </Input>
                </FormControl>

                    <FormControl isRequired id='Product'>
                        <FormLabel>Product</FormLabel>
                            <Input
                                type='text'
                                name='product'
                                autoComplete='on'
                                onChange={handleChange}
                                placeholder='Drugs'
                            >
                        </Input>
                    </FormControl>

                    <FormControl isRequired id='Quantity'>
                    <FormLabel>Quantity</FormLabel>
                    <NumberInput
                        colorScheme='Purple'
                        clampValueOnBlur={false}
                    >
                        <NumberInputField
                        name='quantity'
                        onChange={handleChange}
                        placeholder='0'
                        />
                        <FormErrorMessage> error </FormErrorMessage>
                    </NumberInput>
                </FormControl>
                </div>
                }
               {    !show &&
                    <div>
                    <FormControl isRequired id='c_account_name'>
                    <FormLabel>user_name</FormLabel>
                    <Input
                        type='text'
                        name='c_account_name'
                        autoComplete='on'
                        onChange={handleChangeS}
                        placeholder='Username'
                    >
                    </Input>
                </FormControl>
                <FormControl isRequired id='seller_name'>
                    <FormLabel>seller_name</FormLabel>
                    <Input
                        type='text'
                        name='seller_name'
                        autoComplete='on'
                        onChange={handleChangeS}
                        placeholder='Seller'
                    >
                    </Input>
                </FormControl>

                    <FormControl isRequired id='Product'>
                        <FormLabel>Product</FormLabel>
                            <Input
                                type='text'
                                name='product'
                                autoComplete='on'
                                onChange={handleChangeS}
                                placeholder='Drugs'
                            >
                        </Input>
                    </FormControl>

                    <FormControl isRequired id='employee_id'>
                    <FormLabel>Employee ID</FormLabel>
                    <NumberInput
                        colorScheme='Purple'
                        clampValueOnBlur={false}
                    >
                        <NumberInputField
                        name='employee_id'
                        onChange={handleChangeS}
                        placeholder='0'
                        />
                        <FormErrorMessage> error </FormErrorMessage>
                    </NumberInput>
                </FormControl>

                    <FormControl isRequired id='quantity'>
                    <FormLabel>Quantity</FormLabel>
                    <NumberInput
                        colorScheme='Purple'
                        clampValueOnBlur={false}
                    >
                        <NumberInputField
                        name='quantity'
                        onChange={handleChangeS}
                        placeholder='0'
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
        <h2 style={{color: color}}>{responseMessage}</h2>
        </>
    )

}

export default Return;