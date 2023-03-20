<template>
    <header>
		<span>샘플 메뉴</span>
		<nav>
			<ul>
				<li><router-link to="/">Home</router-link></li>
				<li><router-link to="/sample">sample list</router-link></li>
				<li><router-link to="/login">login</router-link></li>
			</ul>
		</nav>
	</header>
</template>

<style scoped>
header {
	background: gray; 
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