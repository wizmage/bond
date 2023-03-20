<template>
	<!-- searchbar -->
	<div>TODO search bar</div>
	<!-- /searchbar -->
	<!-- data table -->
	<div id="table">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" summary="카테고리ID, 케테고리명, 사용여부, Description, 등록자 표시하는 테이블">
			<caption style="visibility:hidden">카테고리ID, 케테고리명, 사용여부, Description, 등록자 표시하는 테이블</caption>
			<colgroup>
				<col width="100"/>
				<col width="150"/>
				<col width="80"/>
				<col width="?"/>
				<col width="60"/>
			</colgroup>
			<tr>
				<th align="center">title.sample.id</th>
				<th align="center">title.sample.name</th>
				<th align="center">title.sample.useYn</th>
				<th align="center">title.sample.description</th>
				<th align="center">title.sample.regUser</th>
			</tr>
			<tr v-for="sample in state.grid.rows" :key="sample.id">
				<td align="center" class="listtd"><router-link :to="`/sampleDetail/${sample.id}`">{{ sample.id }}</router-link></td>
				<td align="left" class="listtd">{{ sample.name }}</td>
				<td align="center" class="listtd">{{ sample.useYn }}</td>
				<td align="center" class="listtd">{{ sample.description }}</td>
				<td align="center" class="listtd">{{ sample.regUser }}</td>
			</tr>
		</table>
	</div>
	<!-- /data table -->
	<!-- pagination -->
	<div>TODO pagination</div>
	<!-- /pagination -->
</template>

<script>
import { reactive, onMounted } from 'vue';
import router from "@/router";
import { getSampleListApi } from '@/api';

export default {
  name: 'SampleList2Page',
  setup() {
  	/** data */
  	const state = reactive({
  		paginationInfo: {
  			pageIndex: 1
  		},
  		grid: { rows: [] }
  	});

	console.log(router);
  
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
  	
  	/** hooks */
  	onMounted(() => {
  		getSampleList(state.paginationInfo.pageIndex);
  	});
  	
  	
  	/** return */
  	return {
  		state,
  		getSampleList
  	}
  }
}
</script>

<style scoped>

</style>