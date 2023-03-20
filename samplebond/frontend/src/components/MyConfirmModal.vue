<template>
  <my-modal ref="baseModal">
    <div class="content-container">
      <p v-for="text in content" :key="text">
        {{ text }}
      </p>
    </div>
    <div class="buttons-container">
      <button class="btn confirm" @click="confirm">확인</button>
      <button class="btn cancel" @click="cancel">취소</button>
    </div>
  </my-modal>
</template>

<script setup>
import MyModal from '@/components/MyModal.vue';
import { defineProps, ref, defineExpose } from 'vue';

// eslint-disable-next-line no-unused-vars
const props = defineProps({
  content: Array
});

const baseModal = ref(null);

const resolvePromise = ref(null);

// eslint-disable-next-line no-unused-vars
const show = () => {
  // baseModal을 직접 컨트롤합니다.
  baseModal.value.open();
  // Promise 객체를 사용하여, 현재 모달에서 확인 / 취소의
  // 응답이 돌아가기 전까지 작업을 기다리게 할 수 있습니다.
  return new Promise((resolve) => {
    // resolve 함수를 담아 외부에서 사용합니다.
    resolvePromise.value = resolve;
  });
};

const confirm = () => {
  baseModal.value.close();
  resolvePromise.value(true);
};

const cancel = () => {
  baseModal.value.close();
  resolvePromise.value(false);
};

defineExpose({
  show
});
</script>