<template>
  <div class="container w-75 bg-light mt-5 p-4">
    <h3 class="pt-3 " style="text-align:center">Create New Artwork</h3>
    <hr />
    <div class="container m-5">
      <div class="row justify-content-md-center">
        <div class="col-6">
          <form  v-on:submit.prevent>
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
              <label for="exampleInputEmail1" class="mt-2">Completion Year</label>
              <input
                v-model="artwork.completion_year"
                type="number"
                class="form-control"
                id="exampleInputEmail1"
                aria-describedby="emailHelp"
                placeholder="Enter Surname"
              />
              <label for="exampleInputEmail1" class="mt-2">Artwork Value ( $ )</label>
              <input
                v-model="artwork.value"
                type="number"
                class="form-control"
                id="exampleInputEmail1"
                aria-describedby="emailHelp"
                placeholder="Enter Birth Year"
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
              <select v-model="selected" @change="onChange($event)" class="custom-select custom-select-sm" style="display:block;width:100%">
                    <option :value="artist" v-for="artist in artists" :key="artist.id">{{artist.name}} {{artist.surname}}</option>
                    <!-- <option :value="0" >Add New Artist</option> -->
            </select>

            <!-- <div v-if="openArtistInfoPanel">
            <h3  class="mt-4">New Artist</h3><hr>
            <div  class="mt-1">
            <div class="form-group">
              <label for="exampleInputEmail1">Name</label>
              <input
              v-model="artwork.artist.name"
                type="text"
                class="form-control"
                id="exampleInputEmail1"
                aria-describedby="emailHelp"
                placeholder="Enter Name"
              />
              <label for="exampleInputEmail1" class="mt-2">Surname</label>
              <input
                v-model="artwork.artist.surname"
                type="text"
                class="form-control"
                id="exampleInputEmail1"
                aria-describedby="emailHelp"
                placeholder="Enter Surname"
              />
              <label for="exampleInputEmail1" class="mt-2">Birth Year</label>
              <input
                v-model="artwork.artist.birth_year"
                type="number"
                class="form-control"
                id="exampleInputEmail1"
                aria-describedby="emailHelp"
                placeholder="Enter Birth Year"
              />

              <label for="exampleInputEmail1" class="mt-2">Death Year</label>
              <input
                v-model="artwork.artist.death_year"
                type="number"
                class="form-control"
                id="exampleInputEmail1"
                aria-describedby="emailHelp"
                placeholder="Enter Death Year"
              />

              <label for="exampleInputEmail1" class="mt-2">Image URL</label>
              <input
                v-model="artwork.artist.image_url"
                type="text"
                class="form-control"
                id="exampleInputEmail1"
                aria-describedby="emailHelp"
                placeholder="Enter Image URL"
              />

              <label for="exampleInputEmail1" class="mt-2">Country</label>
              <input
              v-model="artwork.artist.country"
                type="text"
                class="form-control"
                id="exampleInputEmail1"
                aria-describedby="emailHelp"
                placeholder="Enter Country"
              />
              <label for="exampleInputEmail1" class="mt-2">City</label>
              <input
              v-model="artwork.artist.city"
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
                v-model="artwork.artist.biography"
                class="form-control"
                id=""
                rows="5"
                placeholder="Enter Biography"
              ></textarea>
            </div>
          </div>
          
            </div> -->
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
import axios from 'axios'
export default {
    data(){
        return{
        artwork:{
                name:"",
                description:"",
                imagePath:"",
                completion_year:0,
                value:0,
                artist:{
                    name:"",
                    surname:"",
                    birth_year:null,
                    death_year:null,
                    biography:"",
                    image_url:""
                }
            },
            artists:[],
            selected:'',
            openArtistInfoPanel:false
        }
    },
     methods: {
            createArtwork(){
               // console.log(this.selected)
            //    if(this.selected == 0){
            //        console.log(this.artwork.artist);
            //             // axios
            //             // .post("http://127.0.0.1:8080/artwork", this.artwork)
            //             // .then((response) => {
            //             // console.log(response);
            //             // });
            //             // this.$router.push("/artwork");  
            //    }
            //    else{
                    delete this.selected.id;
                    this.artwork.artist=this.selected;
                    console.log(  this.artwork.artist);
                    axios
                        .post("http://127.0.0.1:8080/artwork", this.artwork)
                        .then((response) => {
                        console.log(response);
                        });
                        this.$router.push("/artwork");  
            //    }
            },
             onChange(event){
                   if(event.target.value==0){
                       this.openArtistInfoPanel=true;
                   }else{
                        this.openArtistInfoPanel=false;
                   }
            }
        },
        created(){
                axios.get("http://127.0.0.1:8080/artist/all").then((response) => {
                this.artists = response.data;
                console.log(response.data);
            });
        }
}
</script>

<style scoped>
    
</style>