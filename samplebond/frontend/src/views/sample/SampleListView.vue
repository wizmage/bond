<template>
	<!-- searchbar -->
	<div>TODO search bar</div>
	<!-- /searchbar -->
	<!-- data table -->
	<div class="table">
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
			<tr v-for="sample in state.dataList" :key="sample.id">
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
	<my-paging :paging="state.paging"
							@update:page="goPage"/>
	<!-- /pagination -->
</template>

<script setup>
import { onMounted, reactive } from 'vue';
import sampleDummy from '@/dummy/sampleDummy';
import MyPaging from '@/components/MyPaging.vue';

const state = reactive({
	dataList: [],
	searching: {},
	paging: {
		totalRecordCount: 0,
		recordCountPerPage: 10,
		pageSize: 5,
		pageNo: 1
	}
});

const goPage = (pageNo) => {
	console.log(pageNo);
};

onMounted(() => {
	const dummy = sampleDummy.dummyList(1);
	state.dataList = dummy.resultList;
	state.paging = dummy.paging;
	console.log(state.paging);
});
</script>

<style scoped>
.table {
	width: 100%;
}
</style>