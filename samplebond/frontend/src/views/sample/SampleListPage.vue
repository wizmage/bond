<template>
    <div>SampleListPage</div>
	<pagination :page-unit="paginationInfo.pageUnit"
				:page-size="paginationInfo.pageSize"
				@update:modelValue="goPage"/>
</template>

<script>
import Pagination from '@/components/Pagination.vue';
import { reactive } from 'vue';

export default {
  	components: { Pagination },
	name: 'SampleListPage',
	props: {
		pageIndex: { type: Number, default: 1 }
	},
	setup() {
		/** vars */
		const paginationInfo = reactive({
			pageIndex: 0,
			pageUnit: 10,
			pageSize: 50
		});

		/** functions */
		function goPage(modelValue) {
			paginationInfo.pageIndex = modelValue;
			
		}

		/** hooks */

		/** return */
		return {
			paginationInfo,
			goPage
		}
	}
}
</script>

<style scoped>

</style>