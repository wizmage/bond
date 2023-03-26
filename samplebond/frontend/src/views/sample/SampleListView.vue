<template>
	<!-- searchbar -->
	<div>
		<label>Y/N</label>
		<select v-model="searchParam.useYn">
			<option value="">전체</option>
			<option value="Y">Y</option>
			<option value="N">N</option>
		</select>
		<button @click="search">검색</button>
	</div>
	<!-- /searchbar -->
	<!-- data table -->
	<div class="table">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" summary="카테고리ID, 케테고리명, 사용여부, Description, 등록자 표시하는 테이블">
			<caption style="visibility:hidden">카테고리ID, 케테고리명, 사용여부, Description, 등록자 표시하는 테이블</caption>
			<colgroup>
				<col width="60"/>
				<col width="100"/>
				<col width="150"/>
				<col width="80"/>
				<col width="?"/>
				<col width="60"/>
			</colgroup>
			<tr>
				<th align="center">no</th>
				<th align="center">id</th>
				<th align="center">name</th>
				<th align="center">useYn</th>
				<th align="center">description</th>
				<th align="center">regUser</th>
			</tr>
			<tr v-for="(sample, i) in sampleList" :key="i">
				<td>{{ tableRowNo() }}</td>
				<td align="center" class="listtd"><router-link :to="`/sampleDetail/${sample.id}`">{{ sample.id }}</router-link></td>
				<td align="left" class="listtd">{{ sample.name }}</td>
				<td align="center" class="listtd">{{ sample.useYn }}</td>
				<td align="center" class="listtd">{{ sample.useYn }}</td>
				<td align="center" class="listtd">{{ sample.regUser }}</td>
			</tr>
		</table>
	</div>
	<!-- /data table -->
	<!-- pagination -->
	<my-paging :page-size="pagingParam.pageSize"
						 :page-no="pagingParam.pageNo"
						 :total-count="pagingParam.totalCount"
							@update:modelValue="goPage"/>
	<!-- /pagination -->
</template>

<script setup>
import { onMounted, ref, toRaw } from 'vue';
import sampleDummy from '@/dummy/sampleDummy';
import MyPaging from '@/components/MyPaging.vue';

const searchParam = ref({
	useYn: '',
	pageNo: 1,
	pageSize: 5
});

const pagingParam = ref({
	totalCount: 0,
	pageSize: 5,
	pageNo: 1
});

const sampleList = ref(null);

const tableRowNo = () => {
	return 1;
};

const search = () => {
	console.log(searchParam.value);
	getSampleList();
};

const goPage = (pageNo) => {
	console.log(pageNo);
	searchParam.value.pageNo = pageNo;
	getSampleList();
};

const getSampleList = () => {
	const dummy = sampleDummy.dummyList(toRaw(searchParam.value));
	sampleList.value = dummy.resultList;
	pagingParam.value = dummy.paging;
};

onMounted(() => {
	getSampleList();
});
</script>

<style scoped>
.table {
	width: 100%;
}
</style>