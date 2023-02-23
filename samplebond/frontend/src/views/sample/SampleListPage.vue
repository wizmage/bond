<template>
	<!-- searchbar -->
	<div>TODO search bar</div>
	<!-- /searchbar -->
	<!-- data table -->
	<vue-good-table
    	:columns="state.grid.columns"
      	:rows="state.grid.rows"
		v-on:cell-click="onCellClick"/>
	<!-- /data table -->
	<!-- pagination -->
	<div>TODO pagination</div>
	<!-- /pagination -->
</template>

<script>
import 'vue-good-table-next/dist/vue-good-table-next.css';

import { reactive, onMounted } from 'vue';
import router from "@/router";
import { getSampleListApi } from '@/api';
import { VueGoodTable } from 'vue-good-table-next';

export default {
  name: 'SampleListPage',
  components: { VueGoodTable },
  setup() {
  	/** data */
  	const state = reactive({
  		paginationInfo: {
  			pageIndex: 1
  		},
  		grid: {
  			columns: [
  				{ label: '아이디', field: 'id', linkYn: true },
  				{ label: '이름', field: 'name' },
  				{ label: '사용여부', field: 'useYn' },
  				{ label: '설명', field: 'description' },
  				{ label: '등록자', field: 'regUser' }
  			],
  			rows: []
  		}
  	});
  
  	/** functions */
  	// Search Sample List
  	const getSampleList = async (pageIndex) => {
  		state.paginationInfo.pageIndex = pageIndex;
  		
  		// TODO validation
  		
  		// call api
  		await getSampleListApi(pageIndex)
  			.then((result) => {
  				const data = result.data.data;
  				state.grid.rows = data.resultList;
  				state.paginationInfo = data.paginationInfo;
  			})
  			.catch((error) => {
  				// TODO error 처리
  				console.log(error);
  			})
  	};

	const onCellClick = (params) => {
		const col = state.grid.columns.find(col => col.field == params.column.field);

		if (col.linkYn) {
			moveToSampleDetail(params.row[params.column.field]);
		}
	};

	const moveToSampleDetail = (sampleId) => {
		router.push({ name: 'Sample', params: { sampleId: sampleId } });
	};
  	
  	/** hooks */
  	onMounted(() => {
  		getSampleList(state.paginationInfo.pageIndex);
  	});
  	
  	
  	/** return */
  	return {
  		state,
  		getSampleList,
		onCellClick
  	}
  }
}
</script>

<style scoped>

</style>