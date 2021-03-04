<template>
      <div class="container w-75 bg-light mt-5 p-4">
    <h2 class="pt-3" style="text-align:center">All Artworks</h2>
    <div class="" style="text-align:right">
      <router-link class="btn btn-success btn-sm" to="/artwork-create"
        >Create New Artwork</router-link
      >
      <router-view></router-view>
    </div>
    <hr />
    <div class="container">
      <div class=" row justify-content-center">
        <div class="col col-sm-12 col-md-6 col-lg-4" v-for="artwork in artworks" :key="artwork.id">
          <transition-group tag="div" class="animate__animated animate__slideInUp">
          <div class="card d-flex">
            <router-link :to="'/artwork-detail/'+artwork.id">
            <img
              class="card-img-top"
              src="../assets/bg.jpg"
              alt="Card image cap"
              style="height:250px"
            />
            </router-link>
            <div class="card-body">
              <h5 class="card-title">{{artwork.name}}</h5>
              <p class="card-text small">
                    {{artwork.description}}
              </p>
              <p class="card-text small">
                     <strong>Completion Year: </strong>{{artwork.completion_year}}
              </p>
              <p class="card-text small">
                <strong>Value: </strong>$ {{artwork.value}} 
              </p>
                <p class="card-text small" v-if="artwork.artist">
                <strong> <i>{{artwork.artist.name}} {{artwork.artist.surname}}</i></strong>
              </p>
              <a
              @click="updateArtwork(artwork.id)"
                class="btn btn-success btn-sm m-1"
                style="display:block"
                >Update</a
              >
              <a
                class="btn btn-danger btn-sm m-1"
                   @click="deleteArtwork(artwork.id, $event)"
                style="display:block"
                >Delete</a
              >
            </div>
          </div>
          </transition-group>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import axios from 'axios'
export default {
    data(){
        return{
            artworks:[]
        }
    },
    created() {
        axios.get("http://127.0.0.1:8080/artwork/all").then((response) => {
        this.artworks = response.data;
        console.log(response.data);
    });
    },
    methods: {
        deleteArtwork(id,event){
                axios.delete("http://127.0.0.1:8080/artwork/" + id).then((response) => {
                    console.log(response);
                });
                event.target.parentElement.parentElement.parentElement.className="animate__animated animate__bounceOutUp";
                setTimeout(function(){    event.target.parentElement.parentElement.remove(); }, 1000);
        },
        updateArtwork(id){
             this.$router.push({path:"/artwork-update/"+id});
        }
    }
}
</script>
<style scoped>
.container.w-75 {
  border: 1px solid gray;
  border-radius: 5px;
  background-color: #f0f0f0 !important;
  box-shadow: 2px 3px 10px 2px black;
}
.card img{
  border-radius: 15px !important;
}   
.card{
  background-color:#f0f0f0 !important;
  margin:15px;
   border:none;
}
</style>