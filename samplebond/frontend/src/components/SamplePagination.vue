<template>
	<div id="paging">
		
	</div>
</template>

<script>
import { reactive, watch } from 'vue';

export default {
  name: 'SamplePagination',
  props: {
    paginationInfo: Object
  },
  setup(props) {
  	/** data */
  	const state = reactive({
  		sampleList: []
  	});
  	
  	/** hooks */
  	watch(() => props.paginationInfo, (newValue) => {
  		state.paginationInfo = newValue;
  	});
  	
  	/** return - 템플릿에 전달 */
  	return {
  		state
  	}
  }
}
</script>

<style scoped>

</style>
