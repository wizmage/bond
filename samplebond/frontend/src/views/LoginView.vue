<template>
	<div>Login Page</div>
</template>

<script setup>
import { useRoute } from "vue-router";

console.log('login view');
const route = useRoute();
console.log(route.meta);
</script>

<style scoped>

</style>