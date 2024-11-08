import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import './index.css'; // CSS dosyasını import ediyoruz

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


  const handleButtonClick = () => {
    navigate('/home'); // Butona tıklandığında '/home' sayfasına yönlendirir
  };

  return (
    <div className="login-container">
      <div className="login-card">
        <h2 className="login-title">Login</h2>
        <div className="input-container">
          <input
            type="email"
            value={email}
            placeholder="Enter your email here"
            onChange={(e) => setEmail(e.target.value)}
            className="login-input"
          />
          {emailError && <label className="error-label">{emailError}</label>}
        </div>

        <div className="input-container">
          <input
            type="password"
            value={password}
            placeholder="Enter your password here"
            onChange={(e) => setPassword(e.target.value)}
            className="login-input"
          />
          {passwordError && <label className="error-label">{passwordError}</label>}
        </div>

        <button className="login-button" type="button" onClick={onButtonClick}>
          Login
        </button>

        <button className="login-button" type="button"   onClick={handleButtonClick}>
        Home
        </button>

        <div className="link-container">
          Don’t have an account? <Link to="/register">Register</Link>
        </div>
      </div>
    </div>
  );
};

export default Login;