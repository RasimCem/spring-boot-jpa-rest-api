<template>
  <div class="container w-75 bg-light mt-5 p-4">
    <h3 class="pt-3 " style="text-align:center">Update Artwork</h3>
    <hr />
    <div class="container">
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

              <label for="exampleFormControlTextarea1" class="mt-2"
                >Description</label
              >
              <textarea
                v-model="artwork.description"
                class="form-control"
                id=""
                rows="5"
              ></textarea>
              <label for="exampleFormControlTextarea1" class="mt-2"
                >Select Artist</label
              >
              ( Current Artist:
              <span class="font-italic"
                >{{ artwork.artist.name }} {{ artwork.artist.surname }}</span
              >
              )
              <select
                v-model="selected"
                class="custom-select custom-select-sm"
                style="display:block;width:100%"
                required
              >
                <option disabled value="">Please select one</option>
                <option
                  :value="artist"
                  v-for="artist in artists"
                  :key="artist.id"
                  v-bind:selected="artist.id == artwork.artist.id"
                >
                  {{ artist.name }} {{ artist.surname }}
                </option>
              </select>

              <label for="exampleInputEmail1" class="mt-2">Current Image</label>
              <img
                :src="artwork.imagePath"
                alt=""
                style="display:block;width:250px;height:200px;border-radius:5px"
              />
              <label for="exampleInputEmail1" class="mt-2">Image URL</label>
              <input
                v-model="artwork.imagePath"
                type="text"
                class="form-control"
                id="exampleInputEmail1"
                aria-describedby="emailHelp"
              />
            </div>
            <button
              @click="updateArtwork"
              type="submit"
              class="btn btn-primary btn-sm mt-3"
            >
              Update
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
    };
  },
  methods: {
    updateArtwork() {
      this.artwork.artist = this.selected;
      console.log(this.artwork.artist);
      axios
        .put("https://artwork-app.herokuapp.com/artwork/", this.artwork)
        .then((response) => {
          console.log(response.data);
        });
      this.$router.push("/artwork");
    },
  },
  created() {
    this.artwork.id = this.$route.params.id;
    axios
      .get("https://artwork-app.herokuapp.com/artwork/" + this.artwork.id)
      .then((response) => {
        this.artwork = response.data;
      });
    axios.get("https://artwork-app.herokuapp.com/artist/all").then((response) => {
      this.artists = response.data;
    });
  },
  computed: {

  }
};
</script>
