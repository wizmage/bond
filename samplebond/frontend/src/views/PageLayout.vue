<template>
	<header-view></header-view>
	<sidebar-view></sidebar-view>
	<!-- Contents 영역 -->
	<router-view></router-view>
	<!-- /Contents 영역 -->
	<footer-view></footer-view>
</template>

<script>
import HeaderView from '@/components/HeaderView.vue'
import FooterView from '@/components/FooterView.vue'
import SidebarView from '@/components/SidebarView.vue'

export default {
	components: { HeaderView, FooterView, SidebarView },
	name: 'DefaultLayout'
}
</script>

<style scoped>

</style>