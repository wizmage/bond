<template>
	<the-header v-if="!$route.meta.hideHeader"></the-header>
	<the-sidebar v-if="!$route.meta.hideSidebar"></the-sidebar>
	<!-- Contents 영역 -->
	<main>
		<content-top v-if="!$route.meta.hideContentTop"></content-top>
		<slot></slot>
	</main>
	<!-- /Contents 영역 -->
	<the-footer v-if="!$route.meta.hideFooter"></the-footer>
</template>

<script setup>
import TheHeader from './TheHeader.vue';
import TheFooter from './TheFooter.vue';
import TheSidebar from './TheSidebar.vue';
import ContentTop from './ContentTop.vue';
</script>

<style scoped>
main {
	display: inline-block;
	width: 80%;
	min-height: 500px;
	border: 1px solid;
	box-sizing: border-box;
	padding: 10px;
}
</style>