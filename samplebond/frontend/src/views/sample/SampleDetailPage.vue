<template>
	<div id="content_pop">
		<!-- 타이틀 -->
		<div id="title">
			<ul>
				<li><img src="" /> button.modify
				</li>
			</ul>
		</div>
		<!-- /타이틀 -->
		<!-- 상세내용 -->
		<div id="table">
			<table width="100%" border="1" cellpadding="0" cellspacing="0" style="">
	    		<colgroup>
	    			<col width="150"/>
	    			<col width="?"/>
	    		</colgroup>
	    		<tr>
	    			<td class="tbtd_caption">
	    				<label for="name">title.sample.name</label>
	    			</td>
	    			<td class="tbtd_content">
	    				<input path="name" maxlength="30" class="txt" :value="state.sample.name" />
	    				&nbsp;<span>erros.name</span>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td class="tbtd_caption">
	    				<label for="useYn">title.sample.useYn</label>
    				</td>
	    			<td class="tbtd_content">
	    				<select path="useYn" cssClass="use" v-model="state.sample.useYn">
	    					<option value="Y" label="Yes" />
	    					<option value="N" label="No" />
	    				</select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td class="tbtd_caption">
	    				<label for="description">title.sample.description</label>
    				</td>
	    			<td class="tbtd_content">
	    				<textarea path="description" rows="5" cols="58" v-model="state.sample.description" />
	    				&nbsp;<span>errors.description</span>
	                </td>
	    		</tr>
	    		<tr>
	    			<td class="tbtd_caption">
	    				<label for="regUser">title.sample.regUser</label>
	    			</td>
	    			<td class="tbtd_content">
        				<input path="regUser" maxlength="10" class="essentiality" readonly="true" :value="state.sample.regUser" />
        				&nbsp;<span>errors.regUser</span>
    				</td>
	    		</tr>
	    	</table>
		</div>
		<!-- /상세내용 -->
		<!-- 버튼그룹 -->
		<div id="sysbtn">
			<ul>
    			<li>
                    <span class="btn_blue_l">
                        <router-link to="/sampleList">button.list</router-link>
                        <img src="/images/egovframework/example/btn_bg_r.gif" style="margin-left:6px;" alt=""/>
                    </span>
                </li>
    			<li>
                    <span class="btn_blue_l">
                        <a href="#">button.modify</a>
                        <img src="/images/egovframework/example/btn_bg_r.gif" style="margin-left:6px;" alt=""/>
                    </span>
                </li>
                <li>
                    <span class="btn_blue_l">
                        <a href="#">button.delete</a>
                        <img src="/images/egovframework/example/btn_bg_r.gif" style="margin-left:6px;" alt=""/>
                    </span>
                </li>
    			<li>
                    <span class="btn_blue_l">
                        <a href="#">button.reset</a>
                        <img src="/images/egovframework/example/btn_bg_r.gif" style="margin-left:6px;" alt=""/>
                    </span>
                </li>
            </ul>
		</div>
		<!-- /버튼그룹 -->
	</div>
</template>

<script>
import { reactive, onMounted } from 'vue';
import { getSampleDetailApi } from '@/api';

export default {
  name: 'SampleDetailPage',
  props: { sampleId: String },
  setup(props) {	
	/** data */
	const state = reactive({
		sample: {
			id: props.sampleId
		}
	});

	console.log(props);
	console.log(state);

	/** functions */
	const getSampleDetail = async (sampleId) => {
  		
  		// TODO validation
  		
  		// call api
  		await getSampleDetailApi(sampleId)
  			.then((result) => {
  				const data = result.data.data;
				state.sample = data;
				console.log(data);
  			})
  			.catch((error) => {
  				// TODO error 처리
  				console.log(error);
  			})
  	};

	/** hooks */
	onMounted(() => {
		getSampleDetail(props.sampleId);
	});

	/** return */
	return {
		state	
	}
  }
}
</script>

<style scoped>
table {
	border-color:#D3E2EC; 
	border-color-dark:#FFFFFF; 
	BORDER-TOP:#C2D0DB 2px solid; 
	BORDER-LEFT:#ffffff 1px solid; 
	BORDER-RIGHT:#ffffff 1px solid; 
	BORDER-BOTTOM:#C2D0DB 1px solid; 
	border-collapse: collapse;
}
</style>