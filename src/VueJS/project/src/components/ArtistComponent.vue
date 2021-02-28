<template>
    <div class="container w-75 bg-light mt-5 p-4">
       <h2 class="m-2 pt-2 ">All Artists</h2>
       <hr>
       <!-- ARTISTCARD COMPONENT -->
       <div class="container">
       <div class=" row justify-content-between">{{artists}}
           <br><br><br>
            <artist-card-component></artist-card-component>
       </div>
    </div>
    </div>
</template>

<script>
import axios from 'axios';
import ArtistCardComponent from '../components/ArtistCardComponent.vue'
export default {
     components: {
    // HelloWorld,
    ArtistCardComponent
  },
  data(){
      return{
          artists:[]
      }
  },
  created(){
     axios.get("http://127.0.0.1:8080/artist/all")
      //axios.get("localhost:8080/artist/all")
      .then(response => {
      this.artists = response
      console.log(response.data)
    })
  }
}
</script>

<style scoped>
    .container.w-75{
        border: 1px solid black;
        border-radius: 5px;
    }
</style>