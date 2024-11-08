import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import styled from 'styled-components';
import Login from './Login';

const Container = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background-color: #f3f4f6;
`;

const FormWrapper = styled.div`
  width: 400px;
  padding: 2.5rem;
  background-color: #ffffff;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
  border-radius: 8px;
  text-align: center;
  max-width: 100%;
`;

const Title = styled.h2`
  font-size: 1.75rem;
  font-weight: bold;
  color: #333333;
  margin-bottom: 1.5rem;
`;

const Label = styled.label`
  display: block;
  font-size: 1rem;
  color: #333333;
  margin-bottom: 0.5rem;
  text-align: left;
`;

const Input = styled.input`
  width: 100%;
  padding: 1rem;
  margin-bottom: 1.5rem;
  border: 1px solid #d1d5db;
  border-radius: 8px;
  font-size: 1rem;
  outline: none;
  box-sizing: border-box;
  transition: border-color 0.3s ease;
  &:focus {
    border-color: #3b82f6;
  }
`;

const Button = styled.button`
  width: 100%;
  padding: 1rem;
  font-size: 1.1rem;
  font-weight: bold;
  color: #ffffff;
  background-color: #3b82f6;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  margin-bottom: 1.5rem;
  transition: background-color 0.3s ease;
  &:hover {
    background-color: #2563eb;
  }
`;

const FieldError = styled.p`
  color: #ef4444;
  font-size: 0.875rem;
  margin-top: -0.5rem;
  margin-bottom: 1rem;
  text-align: left;
`;

const PasswordErrorMessage = () => {
  return <FieldError>Password should have at least 8 characters</FieldError>;
};

const LinkText = styled.p`
  font-size: 0.9rem;
  color: #333333;
  margin-top: 1.5rem;
`;

const Register = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [showPasswordError, setShowPasswordError] = useState(false);
  const navigate = useNavigate();

  const handleRegister = (e) => {
    e.preventDefault();
    if (password.length < 8) {
      setShowPasswordError(true);
      return;
    }
    setShowPasswordError(false);
    console.log('Email:', email);
    console.log('Password:', password);
    navigate('/login');
  };

  return (
    <Container>
      <FormWrapper>
        <Title>Register</Title>
        <form onSubmit={handleRegister}>
          <Label>Email:</Label>
          <Input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
            placeholder="Enter your email"
          />

          <Label>Password:</Label>
          <Input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
            placeholder="Enter your password"
          />
          {showPasswordError && <PasswordErrorMessage />}

          <Button type="submit">Register</Button>
        </form>

        <LinkText>
          Already have an account? <Link to="/login">Login here</Link>
        </LinkText>
      </FormWrapper>
    </Container>
  );
};

export default Register;