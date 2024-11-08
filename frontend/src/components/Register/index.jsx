import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import './index.css';

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
    <div className="register-container">
      <div className="register-form-wrapper">
        <h2 className="register-title">Register</h2>
        <form onSubmit={handleRegister}>
          <label htmlFor="email" className="register-label">Email:</label>
          <input
            type="email"
            id="email"
            className="register-input"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
            placeholder="Enter your email"
          />

          <label htmlFor="password" className="register-label">Password:</label>
          <input
            type="password"
            id="password"
            className="register-input"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
            placeholder="Enter your password"
          />
          {showPasswordError && <p className="register-field-error">Password should have at least 8 characters</p>}

          <button type="submit" className="register-button">Register</button>
        </form>

        <p className="register-link-text">
          Already have an account? <Link to="/login">Login here</Link>
        </p>
      </div>
    </div>
  );
};

export default Register;