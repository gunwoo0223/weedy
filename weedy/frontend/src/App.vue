<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link> |
      <router-link to="/main">Main</router-link> |
      <router-link to="/registerAdmin">RegisterAdmin</router-link> | 
      <router-link to="/registerUser">RegisterUser</router-link> | 
      <router-link to="/qnaList">QnaList</router-link> |
      <router-link to="/qnaWrite">QnaWrite</router-link> | 
      <router-link to="/qnaDetailAdmin">QnaDetailAdmin</router-link> |
      <router-link to="/qnaDetailUser">QnaDetailUser</router-link> |
      <router-link to="/faq">FAQ</router-link>
    </div>
    <router-view/>
  </div>
</template>
