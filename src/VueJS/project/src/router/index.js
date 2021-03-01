import { createRouter, createWebHistory } from 'vue-router'
import Artist from '../components/Artist.vue'
import Artwork from '../components/Artwork.vue'
import ArtistCreate from '../components/ArtistCreate.vue'
import ArtistUpdate from '../components/ArtistUpdate.vue'
const routes = [
  {
    path: '/artist',
    name: 'Artist',
    component: Artist
  },
  {
    path: '/artwork',
    name: 'Artwork',
    component: Artwork
  },
  {
    path: '/artist-create',
    name: 'ArtistCreate',
    component: ArtistCreate
  },
  {
    path: '/artist-update/:id',
    name: 'ArtistUpdate',
    component: ArtistUpdate
  },
  
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
