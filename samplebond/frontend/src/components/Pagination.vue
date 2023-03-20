<template>
	<ul id="paging">
		<li><button @click="goToFirst">&laquo;</button></li>
		<pager v-for="page in pagination"
				:key="page"
				:page="page"
				:current="modelValue"
				@update="goPage"></pager>
		<li><button @click="goToLast">&raquo;</button></li>
	</ul>
</template>

<script>
import { ref } from 'vue';
import Pager from '@/components/Pager.vue';

export default {
	components: { Pager },
	// eslint-disable-next-line vue/multi-word-component-names
	name: 'Pagination', 
	props: {
		pageUnit: Number,
		pageSize: Number,
		modelValue: Number
	},
	emits: [ 'update:modelValue' ],
	setup(props, { emit }) {
		/** vars */
		console.log(props.modelValue + ', ' + props.pageUnit + ', ' + props.pageSize);
		const pagination = ref(props.pageUnit);

		/** functions */
		function goPage(pageIndex) {
			console.log(pageIndex);
			emit('update:modelValue', pageIndex);
		}

		function goToFirst() {
			goPage(1);
		}

		function goToLast() {
			goPage(100);
		}

		/** hooks */
		// NOTHING TODO

		/** return */
		return {
			pagination,
			goPage,
			goToFirst,
			goToLast
		}
	}
}
</script>

<style scoped>

</style>
