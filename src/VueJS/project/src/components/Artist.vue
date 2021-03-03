<template>
  <div class="container w-75 bg-light mt-5 p-4">
    <h2 class="pt-3" style="text-align:center">All Artists</h2>
    <div class="" style="text-align:right">
      <router-link class="btn btn-success btn-sm" to="/artist-create"
        >Create New Artist</router-link
      >
      <router-view></router-view>
    </div>
    <hr />


    <div class="container px-5">
      <div class=" row justify-content-center">
        <div class="col col-sm-12 col-md-6 col-lg-4" v-for="artist in artists" :key="artist.id">
          <transition-group tag="div" class="animate__animated animate__slideInUp">
          <div class="card d-flex">
            <img
              class="card-img-top"
              src="../assets/bg.jpg"
              alt="Card image cap"
              style="height:250px"
            />
            <div class="card-body">
              <h5 class="card-title">{{ artist.name }} {{ artist.surname }}</h5>
              <p class="card-text small">
                {{ artist.birth_year }} - {{ artist.death_year }}
              </p>
              <p class="card-text small">{{ artist.biography }}</p>
              <p class="card-text small" v-if="artist.nation">
                {{ artist.nation.country }}/{{ artist.nation.city }}
              </p>
              <a
                class="btn btn-success btn-sm m-1"
                @click="updateArtist(artist.id)"
                style="display:block"
                >Update</a
              >
              <a
                class="btn btn-danger btn-sm m-1"
                @click="deleteArtist(artist.id, $event)"
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
import axios from "axios";
export default {
  name: "App",
  components: {},
  data() {
    return {
      artists: [],
      id_value: 0,
    };
  },
  created() {
    axios.get("http://127.0.0.1:8080/artist/all").then((response) => {
      this.artists = response.data;
      console.log(response.data);
    });
  },
  methods: {
    deleteArtist(id, event) {
      console.log(id);
      axios.delete("http://127.0.0.1:8080/artist/" + id).then((response) => {
        console.log(response);
      });
      event.target.parentElement.parentElement.parentElement.className="animate__animated animate__bounceOutUp";
      setTimeout(function(){    event.target.parentElement.parentElement.remove(); }, 1000);
    },
    updateArtist(id) {
        this.$router.push({path:"/artist-update/"+id});
    }
  },
};
</script>
<style scoped>
.container.w-75 {
  border: 1px solid gray;
  border-radius: 5px;
  background-color: #f0f0f0 !important;
  box-shadow: 2px 3px 10px 2px black;
}
.card img{
  border-radius: 50% !important;
}
.card{
  background-color:#f0f0f0 !important;
  margin:15px;
border:none;
}
</style>
