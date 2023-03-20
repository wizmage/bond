<template>{{ curPageSize }}
	<ul id="paging">
		<li><button @click="goToPrev">&laquo;</button></li>
		<li><button @click="goPage"></button></li>
		<li><button @click="goToNext">&raquo;</button></li>
	</ul>
</template>

<script setup>
import { defineProps, toRefs, watch } from 'vue';

const props = defineProps({
	totalRecordCount: { type: Number, default: 0 },
	recordCountPerPage: { type: Number, default: 10 },
	pageSize: { type: Number, default: 5 },
	pageNo: { type: Number, default: 0 }
});

const firstPageNo = toRefs(props.pageNo);
const lastPageNo = Math.ceil(props.totalRecordCount / props.recordCountPerPage);
const curPageSize = (lastPageNo - firstPageNo) > props.pageSize ? props.pageSize : lastPageNo - firstPageNo;

const goPage = (pageNo) => {
	alert(pageNo);
};

const goToPrev = () => {
	alert(props.pageNo - 1);
};

const goToNext = () => {
	alert(props.pageNo + 1);
};

watch(() => props.paging, (newValue) => {
 	console.log(newValue);
});
</script>

<style scoped>

</style>
