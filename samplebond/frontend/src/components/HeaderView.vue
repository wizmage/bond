<template>
	<header id="header">
		<img src="@/assets/images/admin-user-img.svg">
		<title>title</title>
		<nav>
			<ul>
				<li><router-link to="/">Home</router-link></li>
				<li><router-link to="/sample">sample</router-link></li>
				<li><router-link to="/login">login</router-link></li>
			</ul>
		</nav>
	</header>
</template>

<script>
export default {
	name: 'HeaderView',
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
header {
	padding-top:20px; 
	padding-bottom: 20px; 
	color: white;
}
nav li {
	float: left;
	margin-right: 30px;
}
nav li a { 
	color: white;
}
</style>