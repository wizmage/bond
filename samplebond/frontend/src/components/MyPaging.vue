<template>
	<ul id="paging">
		<li><button @click="goToFirst">&laquo;</button></li>
		<li><button @click="goToPrev">&lt;</button></li>
		<li v-for="(no, i) in pageNoList" :key="i">
			<button @click="goPage(no)"
							v-if="no != pageNo">{{ no }}</button>
			<span v-else>{{ no }}</span>
		</li>
		<li><button @click="goToNext">&gt;</button></li>
		<li><button @click="goToLast">&raquo;</button></li>
	</ul>
</template>

<script setup>
import { defineProps, defineEmits } from 'vue';

const emit = defineEmits([ 'update:modelValue' ]);

const props = defineProps({
	totalCount: { type: Number, default: 0 },
	pageSize: { type: Number, default: 5 },
	pageNo: { type: Number, default: 1 }
});

const totalPageCount = Math.ceil(props.totalCount / props.pageSize);
const startPageNo = Math.floor(props.pageNo / props.pageSize) * props.pageSize;
const endPageNo = Math.min(startPageNo + props.pageSize, totalPageCount);
const pageNoList = Array(endPageNo - startPageNo).fill().map((no, i) => startPageNo + i + 1);

const goPage = (pageNo) => {
	emit('update:modelValue', pageNo);
};

const goToFirst = () => {
	goPage(1);
}

const goToPrev = () => {
	goPage(Math.max(props.pageNo - 1, 1));
};

const goToNext = () => {
	goPage(Math.min(props.pageNo + 1, totalPageCount));
};

const goToLast = () => {
	goPage(totalPageCount);
}
</script>

<style scoped>

</style>
