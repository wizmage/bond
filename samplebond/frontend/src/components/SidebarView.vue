<template>
	<nav>
		<ul>
			<li><router-link to="/">Home</router-link></li>
			<li><router-link to="/sample">sample</router-link></li>
			<li><router-link to="/login">login</router-link></li>
		</ul>
	</nav>
</template>

<script>
export default {
	name: 'SidebarView',
	props: {},
	setup() {
		/** data */
		// NOTHING TODO

		/** hooks */
		// NOTHING TODO

		/** return */
		// NOTHING TODO
	}
}
</script>

<style scoped>

</style>