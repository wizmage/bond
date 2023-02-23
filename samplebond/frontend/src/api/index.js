import axios from "axios";

const BASE_URL = process.env.VUE_APP_API_URL;

/** interceptors */
// 요청 인터셉터
axios.interceptors.request.use(
	function(config) {
		// TODO 요청을 보내기 전에 수행
		config.headers['Content-Type'] = 'application/json';
		return config;
	},
	function(error) {
		// TODO 오류 요청을 보내기전 수행
		return Promise.reject(error);
	}
);

// 응답 인터셉터
axios.interceptors.response.use(
	function(response) {
		// TODO 응답 데이터를 가공
		return response;
	},
	function(error) {
		// TODO 오류 응답을 처리
		return Promise.reject(error);
	}
);

/** apis */
// Sample Api
// sample list
export const getSampleListApi = (pageIndex) => {
	return axios.get(`${BASE_URL}/sample/selectSampleList.json?pageIndex=${pageIndex}`);
};
// sample detail
export const getSampleDetailApi = (sampleId) => {
	return axios.get(`${BASE_URL}/sample/selectSample.json?id=${sampleId}`);
};
// sample register
// sample update
// sample delete