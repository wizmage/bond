import { createRouter, createWebHistory } from 'vue-router';

const hideAll = {
	hideHeader: true, 
	hideFooter: true,
	hideSidebar: true,
	hideContentTop: true
};

const routes = [
	{
		path: '/login',
		name: 'login',
		component: () => import('@/views/LoginView.vue'),
		meta: { ...hideAll }
	},
	{
		path: '',
		name: 'MainPage',
		component: () => import('@/views/MainView.vue'),
		meta: { hideSidebar: true }
	},
	{
		path: '/sample',
		redirect: '/sample/list'
	},
	{
		path: '/sample/list',
		name: 'SampleListView',
		component: () => import('@/views/sample/SampleListView.vue')
	},
	{
		path: '/sample/detail/:id',
		name: 'SampleDetailView',
		component: () => import('@/views/sample/SampleDetailView.vue'),
		props: true
	},
	{
		path: '/sample/edit/:id',
		name: 'SampleEditView',
		component: () => import('@/views/sample/SampleEditView.vue'),
		props: true
	},
	{
		path: '/sample/new',
		name: 'SimpleNewView',
		component: () => import('@/views/sample/SampleNewView.vue')
	},
	{
		path: '/:pathMatch(.*)*',
		name: 'NotFound', // error code 404
		component: () => import('@/views/NotFoundView.vue'),
		meta: { ...hideAll }
	}
]

const router = createRouter({
	history: createWebHistory(process.env.BASE_URL),
	routes
});

router.afterEach((to) => {
	to.meta.title = 'Vue3 Sample';
});

export default router
