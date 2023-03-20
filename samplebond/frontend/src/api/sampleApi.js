import axiosInstance from "./axiosInstance";

export const getSampleListApi = (params) => {
	return axiosInstance.get('/sample/selectSampleList.json', params);
};
// sample detail
export const getSampleDetailApi = (id) => {
	return axiosInstance.get('/sample/selectSample.json', { id: id });
};