import axios from "axios";

const axiosInstance = axios.create({
	baseURL: process.env.VUE_APP_API_URL
});

/** interceptors */
// 요청 인터셉터
axiosInstance.interceptors.request.use(
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
axiosInstance.interceptors.response.use(
	function(response) {
		// TODO 응답 데이터를 가공
		return response;
	},
	function(error) {
		// TODO 오류 응답을 처리
		return Promise.reject(error);
	}
);

export default axiosInstance;