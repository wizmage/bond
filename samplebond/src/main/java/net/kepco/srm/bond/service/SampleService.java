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
package net.kepco.srm.bond.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.kepco.srm.bond.domain.Sample;
import net.kepco.srm.bond.dto.SampleDto;
import net.kepco.srm.bond.mapper.SampleMapper;
import net.kepco.srm.bond.repository.SampleRepository;
import net.kepco.srm.framework.exception.CustomEntityNotFoundException;

/**
 * @Class Name : EgovSampleService.java
 * @Description : Sample Business Implement Class
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
////////////////////////////////////////
// EgovAbstractServiceImpl 상속 받을 경우
// Exeption 발생시 Exception을 발생하지 않으면서 후처리(Handler) 로직에 들어간다
// 적용 여부는 추후 결정
////////////////////////////////////////
@Slf4j
@Service("sampleService")
public class SampleService /*extends EgovAbstractServiceImpl*/ {

	/** SampleDAO */
	// mybatis 사용
	@Resource(name="sampleMapper")
	private SampleMapper sampleMapper;
	
	// jpa 사용
	@Resource(name = "sampleRepository")
	private SampleRepository sampleRepository;

	/** ID Generation */
	@Resource(name = "egovIdGnrService")
	private EgovIdGnrService egovIdGnrService;

	/**
	 * 샘플을 등록한다
	 * @param registRequest
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public String registSample(SampleDto.RegistRequest registRequest) throws Exception {
		log.debug(registRequest.toString());

		/** ID Generation Service */
		String id = egovIdGnrService.getNextStringId();
		registRequest.setId(id);
		log.debug(registRequest.toString());
		
		Sample sample = new Sample(registRequest);

		sampleRepository.save(sample);
		return id;
	}

	/**
	 * 샘플을 수정한다
	 * @param updateRequest
	 * @throws Exception
	 */
	@Transactional
	public void updateSample(SampleDto.UpdateRequest updateRequest) throws Exception {
		Sample sample = findSample(updateRequest.getId());
		sample.update(updateRequest);
	}

	/**
	 * 글을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SampleVO
	 * @return void형
	 * @exception Exception
	 */
	@Transactional
	public void deleteSample(SampleDto.DeleteRequest deleteRequest) throws Exception {
		sampleRepository.deleteById(deleteRequest.getId());
	}

	/**
	 * 샘플을 조회한다
	 * @param searchRequest
	 * @return
	 * @throws Exception
	 */
	public SampleDto selectSample(SampleDto.SearchRequest searchRequest) throws Exception {
		return sampleMapper.selectSample(searchRequest)
				.map(SampleDto::of)
				.orElseThrow(() -> new CustomEntityNotFoundException(searchRequest.getId(), null, null));
	}

	/**
	 * 샘플 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 글 목록
	 * @exception Exception
	 */
	public List<SampleDto> selectSampleList(SampleDto.SearchRequest searchRequest) throws Exception {
		return sampleMapper.selectSampleList(searchRequest)
				.stream()
				.map(SampleDto::of)
				.collect(Collectors.toList());
	}

	/**
	 * 샘플 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 글 총 갯수
	 * @exception
	 */
	public int selectSampleListTotCnt(SampleDto.SearchRequest searchRequest) {
		return sampleMapper.selectSampleListTotCnt(searchRequest);
	}
	
	/**
	 * 업데이트용 샘플 조회(JPA)
	 * @param id
	 * @return
	 */
	public Sample findSample(String id) {
		return sampleRepository.findById(id)
				.orElseThrow(() -> { throw new CustomEntityNotFoundException(id, null, null); });
	}
}
