<template>
<div>
<div class="bg" style="background:">
    <!-- <img alt="Vue logo" src="./assets/logo.png"> -->
    <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
        <div class="navbar navbar-expand-lg navbar-light bg-light top-navbar">
          <div class="container-md">
          </div>
      </div>
      <nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
    <div class="container">
      <a class="navbar-brand" href="#">Artwork API</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse p-2  " id="navbarNav">
        <ul class="navbar-nav " style="margin-left:4rem ">
          <li class="nav-item">
            <a class="nav-link " aria-current="page" href="#">Artworks</a>
          </li>
          <li class="nav-item">
            <a class="nav-link " aria-current="page" href="#">Artists</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
    <artist-component></artist-component>
</div>
<!-- Footer -->
    <footer class="bg-dark text-center text-lg-start">
      <div class="text-center p-3 text-light" >
        © 2020
        <a class="text-light" href="#">Rasim Cem Aytan</a>
      </div>
    </footer>
</div>
</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'
import ArtistComponent from './components/ArtistComponent.vue'

export default {
  name: 'App',
  components: {
    // HelloWorld,
    ArtistComponent
  }
}
</script>

<style>
/* #app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
} */
.bg{
   background-image: url("./assets/bg.jpg");
  height: auto;
  min-height: 1150px;
  background-attachment: fixed;
}
.top-navbar{
  background: rgb(131,58,180);
background: linear-gradient(90deg, rgba(131,58,180,1) 1%, rgba(253,29,29,1) 22%, rgba(215,105,2,1) 46%, rgba(252,176,69,1) 66%, rgba(2,178,235,1) 86%);
}

@media only screen and (max-width: 1093) {
    #navbarNav ul{
         margin-left: 0% !important;
    }
}

body{
  font-family: 'Montserrat', sans-serif;
}
</style>
