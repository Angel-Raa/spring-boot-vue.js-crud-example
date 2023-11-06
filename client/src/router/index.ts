import { createRouter, createWebHistory, type Router, type RouteRecordRaw } from 'vue-router'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'home',
    component: () => import('../views/HomeViews.vue')
  },
  {
    path: '/list',
    name: 'list',
    component: () => import('../views/ListViews.vue')
  },
  {
    path: '/create',
    name: 'create',
    component: () => import('../views/CreateViews.vue')
  },
  {
    path: '/edit/:id',
    name: 'edit',
    component: () => import('../views/EditProfileViews.vue')
  }
]

const router: Router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
