<template>
	<header-view></header-view>
	<!-- Contents 영역 -->
	<div>Main Page</div>
	<!-- /Contents 영역 -->
	<footer-view></footer-view>
</template>

<script>
import HeaderView from '@/components/HeaderView.vue';
import FooterView from '@/components/FooterView.vue';

export default {
  	components: { HeaderView, FooterView },
	name: 'MainPage',
	props: {
		msg: String
	}
}
</script>

<style scoped>
div {
	height: 300px;
}
</style>