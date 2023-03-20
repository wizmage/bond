<template>
	<li>
        <span v-if="page === null">&middot;</span>
        <button v-else @click="clickHandler"
                :class="{ active: isActive.value }">{{ page }}</button>
    </li>
</template>

<script>
import { ref } from 'vue';

export default {
	// eslint-disable-next-line vue/multi-word-component-names
	name: 'Pager',
	props: {
        page: Number,
        current: Number
	},
    emits: [ 'update' ],
	setup(props, { emit }) {
        /** vars */
        const isActive = ref(props.current === props.page); 

        /** functions */
		function clickHandler() {
            console.log('clickHandler ' + props.page);
            emit('update', props.page);
            console.log('isActive ' + isActive.value);
        }

        /** hooks */

        /** return */
        return {
            clickHandler,
            isActive
        }
	}
}
</script>

<style scoped>
button { cursor: text; }
button.active { background-color: aquamarine; cursor: pointer; }
</style>
