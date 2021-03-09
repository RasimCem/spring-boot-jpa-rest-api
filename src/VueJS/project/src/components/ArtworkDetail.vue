<template>
  <div class="container w-75 bg-light mt-5 p-4">
    <h3 class="pt-3 " style="text-align:center">{{ artwork.name }}</h3>
    <hr />
    <div class="container">
      <div class="row justify-content-center">
        <div class="col col-md-8 mt-2" style="text-align:center">
          <img
              :src=artwork.imagePath
         style="height:350px;border-radius:15px"
            class="img-fluid"
          />
          <small style="display:block" class="mt-2" v-if="artwork.artist"
            >Artist:
            <strong>
              {{ artwork.artist.name }} {{ artwork.artist.surname }}</strong
            ></small
          >
          <small>Completion Year: {{ artwork.completion_year }}</small>
          <small style="display:block">Value: $ {{ artwork.value}}</small>
        </div>
      </div>
      <div class="row justify-content-md-center">
        <div class="col col-10 mt-2">
          <p>{{ artwork.description }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      id: null,
      artwork: {},
      artist: {},
    };
  },
  created() {
    this.id = this.$route.params.id;
    axios.get("https://artwork-app.herokuapp.com/artwork/" + this.id).then((response) => {
      this.artwork = response.data;
    });
  },
};
</script>

<style scoped></style>
