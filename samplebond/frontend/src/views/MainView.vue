<template>
	<div>Main Page</div>
  <div>
    <my-confirm-modal ref="modal" :content="modalContent"/>
    <button type="button" @click="openModal">modal</button>
  </div>
</template>

<script setup>
import MyConfirmModal from '@/components/MyConfirmModal.vue';
import router from '@/router';
import { onBeforeUnmount, onMounted, ref } from 'vue';

const modal = ref(null);

const modalContent = ref([
  "확인/취소를 누르고",
  "배경에 결과가 출력되는 것을",
  "확인해보세요"
]);

const testInterval = ref(null);

const openModal = async () => {
  const ok = await modal.value.show();

  if (ok) {
    alert('ok');
  } else {
    alert('no');
  }
}

onMounted(() => {
  console.log('main');
  console.log(modal.value.show);

  testInterval.value = setInterval(() => {
    router.push({ name: 'SampleListView' });
  }, 5000);
});

onBeforeUnmount(() => {
  clearInterval(testInterval.value);
});
</script>

<style scoped>
  div {
    height: 300px;
  }
</style>