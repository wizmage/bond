<template>
  <teleport to='body'>
    <!-- Modal의 열리고 닫힘을 관리합니다. -->
    <div class="backdrop" v-if="isVisible">
      <div class="modal-container">
        <!-- slot을 통해 BaseComponent를 확장시킵니다. -->
        <slot></slot>
      </div>
    </div>
  </teleport>
</template>

<script setup>
import { ref, defineExpose } from 'vue';

const isVisible = ref(false);

// eslint-disable-next-line no-unused-vars
const open = () => {
  isVisible.value = true;
};

// eslint-disable-next-line no-unused-vars
const close = () => {
  isVisible.value = false;
};

defineExpose({
  open,
  close
});
</script>

<style scoped>
.backdrop {
  z-index: 999;
  display: flex;
  position: fixed;
  align-items: center;
  justify-content: center;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgb(0, 0, 0, .2);
}

.modal-container {
    background: white;
    max-width: 320px;
    width: 100%;
    padding: 1.5rem;
  }
</style>