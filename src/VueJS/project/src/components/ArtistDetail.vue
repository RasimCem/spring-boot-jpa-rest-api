<template>
  <div class="container w-75 bg-light mt-5 p-4">
    <h3 class="pt-3 " style="text-align:center">
      {{ artist.name }} {{ artist.surname }}
    </h3>
    <hr />
    <div class="container">
      <div class="row justify-content-center">
        <div class="col col-md-6 mt-2" style="text-align:center">
          <img
            :src="artist.image_url"
            style="width:50%; border-radius:15px"
            class="img-fluid"
          />
          <p class="m-2">{{ artist.name }} {{ artist.surname }}</p>
          <small>{{ artist.birth_year }}-{{ artist.death_year }}</small>
          <small style="display:block" v-if="artist.nation"
            >{{ artist.nation.city }} / {{ artist.nation.country }}
          </small>
        </div>
      </div>
      <div class="row justify-content-md-center">
        <div class="col col-10 mt-2">
          <p>{{ artist.biography }}</p>
        </div>
      </div>
      <div style="text-align:center" class="my-3">
        <button
          @click="showArtworks = !showArtworks"
          style="width:55px"
          class="btn btn-sm btn-success"
        >
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="16"
            height="16"
            fill="currentColor"
            class="bi bi-arrow-bar-down"
            viewBox="0 0 16 16"
          >
            <path
              fill-rule="evenodd"
              d="M1 3.5a.5.5 0 0 1 .5-.5h13a.5.5 0 0 1 0 1h-13a.5.5 0 0 1-.5-.5zM8 6a.5.5 0 0 1 .5.5v5.793l2.146-2.147a.5.5 0 0 1 .708.708l-3 3a.5.5 0 0 1-.708 0l-3-3a.5.5 0 0 1 .708-.708L7.5 12.293V6.5A.5.5 0 0 1 8 6z"
            />
          </svg>
        </button>
      </div>
      <transition-group tag="p" name="fade">
        <div
          class="row justify-content-md-center"
          style="text-align:center"
          v-if="showArtworks"
        >
          <div class="col-sm" v-for="artwork in artworks" :key="artwork.id">
            <div class="mt-3">
              <img
                style="width:300px; height:250px;border-radius:15px"
                 :src=artwork.imagePath
                alt=""
              />
              <div class="card-body">
                <p class="card-title">{{ artwork.name }}</p>
              </div>
            </div>
          </div>
        </div>
      </transition-group>
    </div>
  </div>
</template>
<script>
import axios from "axios";
export default {
  created() {
    this.id = this.$route.params.id;
    axios.get("http://127.0.0.1:8080/artist/" + this.id).then((response) => {
      this.artist = response.data;
    });
    axios.get("http://127.0.0.1:8080/artwork/all").then((response) => {
      response.data.forEach((element) => {
        if (element.artist.id == this.artist.id) {
          this.artworks.push(element);
        }
      });
    });
  },
  data() {
    return {
      artist: {},
      id: null,
      showArtworks: false,
      artworks: [],
    };
  },
};
</script>

<style scoped>
.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.5s;
}
.fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
  opacity: 0;
}
</style>
