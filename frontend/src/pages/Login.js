import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import styled from 'styled-components';

const Container = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background-color: #f0f4f8;
`;

const Card = styled.div`
  width: 400px;
  padding: 2rem;
  background-color: #ffffff;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
  border-radius: 8px;
  text-align: center;
`;

const Title = styled.h2`
  font-size: 1.5rem;
  font-weight: bold;
  color: #333333;
  margin-bottom: 1.5rem;
`;

const InputContainer = styled.div`
  margin-bottom: 1rem;
`;

const Input = styled.input`
  width: 100%;
  padding: 0.75rem;
  margin-bottom: 0.5rem;
  border: 1px solid #d1d5db;
  border-radius: 5px;
  font-size: 0.9rem;
  outline: none;
  &:focus {
    border-color: #3b82f6;
  }
`;

const Button = styled.button`
  width: 100%;
  padding: 0.75rem;
  font-size: 1rem;
  font-weight: bold;
  color: #ffffff;
  background-color: #3b82f6;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  margin-bottom: 1rem;
  transition: background-color 0.3s ease;
  &:hover {
    background-color: #2563eb;
  }
`;

const LinkContainer = styled.div`
  font-size: 0.9rem;
  color: #666666;
  margin-top: 1rem;
`;

const ErrorLabel = styled.label`
  color: #ef4444;
  font-size: 0.85rem;
`;

const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [emailError, setEmailError] = useState('');
  const [passwordError, setPasswordError] = useState('');
  const navigate = useNavigate();

  const onButtonClick = () => {
    // Kayıt işlemleri burada yapılacak
    console.log('Email:', email);
    console.log('Password:', password);
    navigate('/dashboard'); // Örnek olarak bir başka sayfaya yönlendirme
  };

  return (
    <Container>
      <Card>
        <Title>Login</Title>
        <InputContainer>
          <Input
            type="email"
            value={email}
            placeholder="Enter your email here"
            onChange={(e) => setEmail(e.target.value)}
          />
          {emailError && <ErrorLabel>{emailError}</ErrorLabel>}
        </InputContainer>

        <InputContainer>
          <Input
            type="password"
            value={password}
            placeholder="Enter your password here"
            onChange={(e) => setPassword(e.target.value)}
          />
          {passwordError && <ErrorLabel>{passwordError}</ErrorLabel>}
        </InputContainer>

        <Button type="button" onClick={onButtonClick}>Login</Button>

        <LinkContainer>
          Don’t have an account? <Link to="/register">Register</Link>
        </LinkContainer>
      </Card>
    </Container>
  );
};

export default Login;