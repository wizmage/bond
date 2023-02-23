/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.kepco.srm.bond.controller;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.kepco.srm.bond.dto.SampleDto;
import net.kepco.srm.bond.service.SampleService;
import net.kepco.srm.framework.ApiResponse;
import net.kepco.srm.framework.MapBuilder;

/**
 * @Class Name : EgovSampleController.java
 * @Description : EgovSample Controller Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Slf4j
@RestController
@RequestMapping("/api/v1/sample")
public class SampleController {

	/** EgovSampleService */
	@Resource(name = "sampleService")
	private SampleService sampleService;

	/** Properties */
	@Value("${bond.pagable.page-size}")
	private int pageSize;
	
	@Value("${bond.pagable.page-size}")
	private int pageUnit;
	
	/** Validator */
	//@Resource(name = "beanValidator")
	//protected DefaultBeanValidator beanValidator;

	/**
	 * 글 목록을 조회한다. (paging)
	 * @param searchVO - 조회할 정보가 담긴 SampleDefaultVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
	@GetMapping("/selectSampleList.json")
	public ApiResponse selectSampleList(SampleDto.SearchRequest searchRequest) throws Exception {
		// log example
		log.debug("/selectSampleList.json");

		// page properties
		searchRequest.setPageUnit(pageSize);
		searchRequest.setPageSize(pageUnit);

		// paging setting
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchRequest.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchRequest.getPageUnit());
		paginationInfo.setPageSize(searchRequest.getPageSize());

		searchRequest.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchRequest.setLastIndex(paginationInfo.getLastRecordIndex());
		searchRequest.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		// sample list
		List<SampleDto> resultList = sampleService.selectSampleList(searchRequest);
		
		// sample list total count
		int totCnt = sampleService.selectSampleListTotCnt(searchRequest);
		paginationInfo.setTotalRecordCount(totCnt);

		return ApiResponse.ok(
				new MapBuilder<String, Object>()
					.put("resultList", resultList)
					.put("paginationInfo", paginationInfo)
					.build());
	}
	
	/**
	 * 
	 * @param sampleVO - 조회할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return @ModelAttribute("sampleVO") - 조회한 정보
	 * @exception Exception
	 */
	@GetMapping("/selectSample.json")
	public ApiResponse selectSample(SampleDto.SearchRequest searchRequest) throws Exception {
		return ApiResponse.ok(sampleService.selectSample(searchRequest));
	}

	/**
	 * 샘플 등록요청
	 * @param registRequest - 등록할 정보가 담긴 dto
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/registSample.json")
	public ApiResponse addSample(SampleDto.RegistRequest registRequest) throws Exception {

		// TODO Server-Side Validation
		
		sampleService.registSample(registRequest);
		return ApiResponse.ok();
	}

	/**
	 * 글을 수정한다.
	 * @param sampleVO - 수정할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/egovSampleList.do"
	 * @exception Exception
	 */
	@PostMapping("/updateSample.json")
	public ApiResponse updateSample(SampleDto.UpdateRequest updateRequest)
			throws Exception {

		// TODO Server-Side Validation

		sampleService.updateSample(updateRequest);
		return ApiResponse.ok();
	}

	/**
	 * 글을 삭제한다.
	 * @param sampleVO - 삭제할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/egovSampleList.do"
	 * @exception Exception
	 */
	@RequestMapping("/deleteSample.json")
	public ApiResponse deleteSample(SampleDto.DeleteRequest deleteRequest) throws Exception {
		sampleService.deleteSample(deleteRequest);
		return ApiResponse.ok();
	}

}
