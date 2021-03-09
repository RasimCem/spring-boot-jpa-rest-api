<template>
  <div class="container w-75 bg-light mt-5 p-4">
    <h3 class="pt-3 " style="text-align:center">Create New Artwork</h3>
    <hr />
    <div class="container ">
      <div class="row justify-content-center">
        <div class="col-md-6">
          <form v-on:submit.prevent>
            <div class="form-group">
              <label for="exampleInputEmail1">Name</label>
              <input
                v-model="artwork.name"
                type="text"
                class="form-control"
                id="exampleInputEmail1"
                aria-describedby="emailHelp"
                placeholder="Enter Name"
              />
              <label for="exampleInputEmail1" class="mt-2"
                >Completion Year</label
              >
              <input
                v-model="artwork.completion_year"
                type="number"
                class="form-control"
                id="exampleInputEmail1"
                aria-describedby="emailHelp"
     
              />
              <label for="exampleInputEmail1" class="mt-2"
                >Artwork Value ( $ )</label
              >
              <input
                v-model="artwork.value"
                type="number"
                class="form-control"
                id="exampleInputEmail1"
                aria-describedby="emailHelp"
 
              />

              <label for="exampleInputEmail1" class="mt-2">Image URL</label>
              <input
                v-model="artwork.imagePath"
                type="text"
                class="form-control"
                id="exampleInputEmail1"
                aria-describedby="emailHelp"
                placeholder="Enter Image URL"
              />
              <label for="exampleFormControlTextarea1" class="mt-2"
                >Description</label
              >
              <textarea
                v-model="artwork.description"
                class="form-control"
                id=""
                rows="5"
                placeholder="Enter Biography"
              ></textarea>
              <label for="exampleFormControlTextarea1" class="mt-2"
                >Select Creater Of The Artwork</label
              >
              <select
                v-model="selected"
                @change="onChange($event)"
                class="custom-select custom-select-sm"
                style="display:block;width:100%"
              >
                <option
                  :value="artist"
                  v-for="artist in artists"
                  :key="artist.id"
                  >{{ artist.name }} {{ artist.surname }}</option
                >
              </select>
            </div>
            <button
              @click="createArtwork"
              type="submit"
              class="btn btn-primary btn-sm mt-3"
            >
              Create
            </button>
          </form>
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
      artwork: {
        name: "",
        description: "",
        imagePath: "",
        completion_year: 0,
        value: 0,
        artist: {
          name: "",
          surname: "",
          birth_year: null,
          death_year: null,
          biography: "",
          image_url: "",
        },
      },
      artists: [],
      selected: "",
      openArtistInfoPanel: false,
    };
  },
  methods: {
    createArtwork() {
      delete this.selected.id;
      this.artwork.artist = this.selected;
      console.log(this.artwork.artist);
      axios
        .post("https://artwork-app.herokuapp.com/artwork", this.artwork)
        .then((response) => {
          console.log(response);
        });
      this.$router.push("/artwork");
  
    },
    onChange(event) {
      if (event.target.value == 0) {
        this.openArtistInfoPanel = true;
      } else {
        this.openArtistInfoPanel = false;
      }
    },
  },
  created() {
    axios.get("https://artwork-app.herokuapp.com/artist/all").then((response) => {
      this.artists = response.data;
      console.log(response.data);
    });
  },
};
</script>

<style scoped></style>
