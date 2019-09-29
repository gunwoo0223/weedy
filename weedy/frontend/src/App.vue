<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link> |
      <router-link to="/main">Main</router-link> |
      <router-link to="/register_admin">Register_admin</router-link> | 
      <router-link to="/register_user">Register_user</router-link>
    </div>
    <router-view/>
  </div>
</template>
