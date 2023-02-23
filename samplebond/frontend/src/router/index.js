import { createRouter, createWebHistory } from 'vue-router';

// import views
import MainLayout     from '@/views/MainLayout.vue'

/**
 * router 세팅
 * component에 () => import 구문으로 필요할때 js파일을 호출
 */
const routes = [
  {
    path: '/login',
    name: 'login',
    component: () => import('@/views/LoginPage.vue')
  },
  {
    path: '/',
    name: 'MainLayout',
    component: MainLayout,
    children: [
		{
    		path: '',
    		name: 'MainPage',
    		component: () => import('@/views/MainPage.vue')
    	},
    	{
    		path: '/sample/list',
    		name: 'SampleList',
    		component: () => import('@/views/sample/SampleListPage.vue')
    	},
		{
    		path: '/sample2/list',
    		name: 'SampleList2',
    		component: () => import('@/views/sample/SampleList2Page.vue')
    	},
    	{
    		path: '/sample/detail/:sampleId',
    		name: 'SampleDetail',
    		component: () => import('@/views/sample/SampleDetailPage.vue'),
			props: true
    	},
    	{
    		path: '/sample/register',
    		name: 'SampleRegister',
    		component: () => import('@/views/sample/SampleRegisterPage.vue')
    	}
    ]
  },
  {
	path: '/:pathMatch(.*)*',
	name: 'NotFound', // error code 404
	component: () => import('@/views/NotFoundPage.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
