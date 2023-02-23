<template>
	<!-- header 영역 -->
	<header>
		<span>샘플 메뉴</span>
		<nav>
			<ul>
				<li><router-link to="/">Home</router-link></li>
				<li><router-link to="/sample/list">sample list</router-link></li>
				<li><router-link to="/sample2/list">sample list2</router-link></li>
				<li><router-link to="/login">login</router-link></li>
			</ul>
		</nav>
	</header>
	<!-- /header 영역 -->
	<!-- Contents 영역 -->
	<router-view></router-view>
	<!-- /Contents 영역 -->
	<!-- Footer 영역 -->
	<footer>
		TODO 주소, 전화번호, 개인정보처리방침, Copyright
	</footer>
	<!-- /Footer 영역 -->
</template>

<script>
export default {
  name: 'DefaultLayout'
}
</script>

<style scoped>
nav li {
	float: left;
	margin-right: 30px;
}
nav li a { 
	color: white;
}

header {
	background: gray; 
	padding-top:20px; 
	padding-bottom: 20px; 
	color: white;
}

footer {
	background: gray; 
	padding-top:20px; 
	padding-bottom: 20px; 
	color: white;
}
</style>