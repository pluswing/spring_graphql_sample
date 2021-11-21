import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import './App.css';

import Header from './components/Header'
import PostList from './components/PostList'
import CreatePost from './components/CreatePost'
import PostDetail from './components/PostDetail'

const App = () => (
  <Router>
    <div>
      <Header/>
    </div>
    <Routes>
      <Route path="/" element={<PostList/>} />
      <Route path="/create" element={<CreatePost/>} />
      <Route path="/posts/:id" element={<PostDetail />} />
    </Routes>
  </Router>
)

export default App;
