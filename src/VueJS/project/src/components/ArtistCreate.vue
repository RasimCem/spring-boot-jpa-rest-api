<template>
  <div class="container w-75 bg-light mt-5 p-4">
    <h3 class="pt-3 " style="text-align:center">Create New Artist</h3>
    <hr />
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-md-6">
          <form>
            <div class="form-group">
              <label for="exampleInputEmail1">Name</label>
              <input
                v-model="artist.name"
                type="text"
                class="form-control"
                id="exampleInputEmail1"
                aria-describedby="emailHelp"
                placeholder="Enter Name"
              />
              <label for="exampleInputEmail1" class="mt-2">Surname</label>
              <input
                v-model="artist.surname"
                type="text"
                class="form-control"
                id="exampleInputEmail1"
                aria-describedby="emailHelp"
                placeholder="Enter Surname"
              />
              <label for="exampleInputEmail1" class="mt-2">Birth Year</label>
              <input
                v-model="artist.birth_year"
                type="number"
                class="form-control"
                id="exampleInputEmail1"
                aria-describedby="emailHelp"
                placeholder="Enter Birth Year"
              />

              <label for="exampleInputEmail1" class="mt-2">Death Year</label>
              <input
                v-model="artist.death_year"
                type="number"
                class="form-control"
                id="exampleInputEmail1"
                aria-describedby="emailHelp"
                placeholder="Enter Death Year"
              />

              <label for="exampleInputEmail1" class="mt-2">Image URL</label>
              <input
                v-model="artist.image_url"
                type="text"
                class="form-control"
                id="exampleInputEmail1"
                aria-describedby="emailHelp"
                placeholder="Enter Image URL"
              />

              <label for="exampleInputEmail1" class="mt-2">Country</label>
              <input
                v-model="artist.nation.country"
                type="text"
                class="form-control"
                id="exampleInputEmail1"
                aria-describedby="emailHelp"
                placeholder="Enter Country"
              />
              <label for="exampleInputEmail1" class="mt-2">City</label>
              <input
                v-model="artist.nation.city"
                type="text"
                class="form-control"
                id="exampleInputEmail1"
                aria-describedby="emailHelp"
                placeholder="Enter City"
              />
              <label for="exampleFormControlTextarea1" class="mt-2"
                >Biography</label
              >
              <textarea
                v-model="artist.biography"
                class="form-control"
                id=""
                rows="5"
                placeholder="Enter Biography"
              ></textarea>
            </div>
            <button
              @click="createArtist"
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
      artist: {
        name: "",
        surname: "",
        birth_year: 0,
        death_year: 0,
        image_url: "",
        biography: "",
        nation: {
          country: "",
          city: "",
        },
      },
    };
  },
  methods: {
    createArtist() {
      axios
        .post("https://artwork-app.herokuapp.com/artist", this.artist)
        .then((response) => {
          console.log(response);
        });
      this.$router.push("/artist");
    },
  },
};
</script>

<style></style>
