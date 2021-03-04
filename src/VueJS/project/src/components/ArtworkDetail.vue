<template>
  <div class="container w-75 bg-light mt-5 p-4">
    <h3 class="pt-3 " style="text-align:center">{{artwork.name}}</h3>
    <hr />
    <div class="container">
      <div class="row justify-content-md-center">
        <div class="col col-6 mt-2" style="text-align:center">
          <img
            src="../assets/bg.jpg"
            style="height:250px;width:350px;border-radius:15px"
          />
          <p class="m-2">
            Lorem ipsum dolor sit amet.lorem5asdsadasdsadasdasdasasd
          </p>
          <small style="display:block" v-if="artwork.artist">Artist: <strong> {{artwork.artist.name}} {{artwork.artist.surname}}</strong></small>
          <small>Completion Year: {{artwork.completion_year}}</small>
          <small style="display:block">Value: $ {{artwork.value}}</small>
        </div>
      </div>
      <div class="row justify-content-md-center">
        <div class="col col-10 mt-2">
          <p>{{artwork.description}}</p>
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
        id:null,
        artwork:{},
        artist:{}
    };
  },
  created() {
    this.id = this.$route.params.id;
    axios.get("http://127.0.0.1:8080/artwork/" + this.id).then((response) => {
      this.artwork = response.data;
    });
  },
};
</script>

<style scoped></style>
