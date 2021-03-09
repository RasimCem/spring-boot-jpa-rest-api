<template>
  <div class="container w-75 bg-light mt-5 p-4">
    <h3 class="pt-3 " style="text-align:center">Artist Update</h3>
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
              />
              <label for="exampleInputEmail1" class="mt-2">Surname</label>
              <input
                v-model="artist.surname"
                type="text"
                class="form-control"
                id="exampleInputEmail1"
              />
              <label for="exampleInputEmail1" class="mt-2">Birth Year</label>
              <input
                v-model="artist.birth_year"
                type="number"
                class="form-control"
                id="exampleInputEmail1"
              />

              <label for="exampleInputEmail1" class="mt-2">Death Year</label>
              <input
                v-model="artist.death_year"
                type="number"
                class="form-control"
                id="exampleInputEmail1"
              />

              <label for="exampleInputEmail1" class="mt-2">Country</label>
              <input
                v-model="artist.nation.country"
                type="text"
                class="form-control"
                id="exampleInputEmail1"
              />
              <label for="exampleInputEmail1" class="mt-2">City</label>
              <input
                v-model="artist.nation.city"
                type="text"
                class="form-control"
                id="exampleInputEmail1"
              />
              <label for="exampleFormControlTextarea1" class="mt-2"
                >Biography</label
              >
              <textarea
                v-model="artist.biography"
                class="form-control"
                id=""
                rows="5"
              ></textarea>
              <label for="exampleInputEmail1" class="mt-2">Current Image</label>
              <img
                :src="artist.image_url"
                alt=""
                style="display:block;width:250px;height:200px;border-radius:5px"
              />

              <label for="exampleInputEmail1" class="mt-2">Image URL</label>
              <input
                v-model="artist.image_url"
                type="text"
                class="form-control"
                id="exampleInputEmail1"
              />
            </div>
            <button
              @click="updateArtist"
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
      artist: {
        id: 0,
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
    updateArtist() {
      axios
        .put("https://artwork-app.herokuapp.com/artist/", this.artist)
        .then((response) => {
          console.log(response.data);
        });
      this.$router.push("/artist");
    },
  },
  created() {
    this.artist.id = this.$route.params.id;
    axios
      .get("https://artwork-app.herokuapp.com/artist/" + this.artist.id)
      .then((response) => {
        this.artist = response.data;
      });
  },
};
</script>
