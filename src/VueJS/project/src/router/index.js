import { createRouter, createWebHistory } from 'vue-router'
import Artist from '../components/Artist.vue'
import Artwork from '../components/Artwork.vue'
import ArtistCreate from '../components/ArtistCreate.vue'
import ArtistUpdate from '../components/ArtistUpdate.vue'
import ArtworkCreate from '../components/ArtworkCreate.vue'
import ArtworkUpdate from '../components/ArtworkUpdate.vue'
import ArtworkDetail from '../components/ArtworkDetail.vue'
import ArtistDetail from '../components/ArtistDetail.vue'
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
  {
    path: '/artwork-create',
    name: 'ArtworkCreate',
    component: ArtworkCreate
  },
  {
    path: '/artwork-update/:id',
    name: 'ArtworkUpdate',
    component: ArtworkUpdate
  },
  {
    path: '/artwork-detail/:id',
    name: 'ArtworkDetail',
    component: ArtworkDetail
  },
  {
    path: '/artist-detail/:id',
    name: 'ArtistDetail',
    component: ArtistDetail
  },
  
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
  mode: 'history'
})

export default router
